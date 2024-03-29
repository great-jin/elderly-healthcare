package xyz.ibudai.controller;

import xyz.ibudai.entity.LoginUser;
import xyz.ibudai.entity.dto.LoginUserDTO;
import xyz.ibudai.model.MinioRespond;
import xyz.ibudai.service.LoginUserService;
import xyz.ibudai.utils.MinioUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import static xyz.ibudai.utils.AESUtil.desEncrypt;
import static xyz.ibudai.utils.AESUtil.encrypt;

/**
 * (LoginUser)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:07
 */
@RestController
@RequestMapping(value = "/api/healthcare/loginUser")
public class LoginUserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final static String KEY_FRONT = "byouthinvincible";
    private final static String IV_FRONT = "byouthinvincible";

    private final static String KEY_BACK = "dyouthinvincible";
    private final static String IV_BACK = "dyouthinvincible";

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 服务对象
     */
    @Resource
    private LoginUserService loginUserService;

    /**
     * 分页查询
     *
     * @param loginUser   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<LoginUser>> queryByPage(LoginUser loginUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.loginUserService.queryByPage(loginUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<LoginUser> queryById(@RequestParam(value = "id") String id) {
        return ResponseEntity.ok(this.loginUserService.queryById(id));
    }

    @PostMapping("/login")
    public int login(@RequestBody LoginUser user) throws Exception {
        // 获取前端输入数据
        String frontEnPwd = user.getUserPwd();
        String frontDePwd = desEncrypt(frontEnPwd, KEY_FRONT, IV_FRONT).trim();

        // 获取后端存储数据
        LoginUser resultUser = loginUserService.queryById(user.getStaffId());
        if (resultUser != null) {
            // 后端数据解密
            String backEnPwd = new String(resultUser.getUserPwd().getBytes(), "UTF-8");
            String backDePwd = desEncrypt(backEnPwd, KEY_BACK, IV_BACK).trim();

            if (frontDePwd.equals(backDePwd)) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 新增数据
     *
     * @param loginUser 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public boolean add(@RequestBody LoginUser loginUser) throws Exception {
        boolean tag = false;
        LoginUser userResult = loginUserService.queryById(loginUser.getStaffId());
        // 判断用户是否已存在
        if (userResult == null) {
            // 获取前端加密数据进行解密
            String frontEnPwd = loginUser.getUserPwd();
            String frontDePwd = desEncrypt(frontEnPwd, KEY_FRONT, IV_FRONT).trim();
            // 对解密数据二次加密
            String backByte = new String(frontDePwd.getBytes(), "UTF-8");
            String backEnPwd = encrypt(backByte, KEY_BACK, IV_BACK);
            loginUser.setUserPwd(backEnPwd);
            // 数据补充
            loginUser.setId(UUID.randomUUID().toString());
            loginUser.setRegisterTime(new Date());
            loginUser.setUpdateTime(null);
            loginUser.setDestroyTime(null);
            loginUser.setComment(null);
            // 设置默认头像
            loginUser.setUserAvatar("default-avatar.jpg");
            loginUser.setBucketAvatar("avatar");

            tag = loginUserService.insert(loginUser) > 0;
        }
        return tag;
    }

    /**
     * 联表查询用户信息
     *
     * @param staffId
     * @return
     */
    @GetMapping("/getInfo")
    public ResponseEntity<LoginUserDTO> getInfo(@RequestParam(value = "staffId") String staffId) {
        return ResponseEntity.ok(loginUserService.getInfo(staffId));
    }

    /**
     * 邮件发送
     *
     * @param mailStr
     */
    @PostMapping("/sendMail")
    public String SendMail(@RequestParam("email") String mailStr) {
        // 生成邮件内容
        StringBuilder msgText = new StringBuilder();
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
        msgText.append("【疗养一体化系统】验证码：");
        msgText.append(code);
        msgText.append("，尊敬的用户，您正在使用邮箱找回密码[验证码告知他人将导致帐号被盗，请勿泄露]");
        // 发送邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("budai_youth@163.com");
        message.setTo(mailStr);
        message.setSubject("【疗养一体化系统】验证码");
        message.setText(msgText.toString());

        mailSender.send(message);
        return code;
    }

    /**
     * @param loginUser
     * @return
     */
    @PostMapping("/forget")
    public ResponseEntity<Boolean> forget(@RequestBody LoginUser loginUser) throws Exception {
        // 获取前端加密数据进行解密
        String frontEnPwd = loginUser.getUserPwd();
        String frontDePwd = desEncrypt(frontEnPwd, KEY_FRONT, IV_FRONT).trim();
        // 对解密数据二次加密
        String backByte = new String(frontDePwd.getBytes(), "UTF-8");
        String backEnPwd = encrypt(backByte, KEY_BACK, IV_BACK);
        // 更新用户密码
        loginUser.setUserPwd(backEnPwd);
        return ResponseEntity.ok(this.loginUserService.update(loginUser) > 0);
    }

    /**
     * 编辑数据
     *
     * @param loginUser 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody LoginUser loginUser) {
        return ResponseEntity.ok(this.loginUserService.update(loginUser) > 0);
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.loginUserService.deleteById(id));
    }

    /**
     * 获取头像外链
     *
     * @param ID
     * @return
     * @throws Exception
     */
    @GetMapping("/getAvatar")
    public String getAvatar(String ID) throws Exception {
        LoginUser user = loginUserService.queryById(ID);
        return minioUtil.getObjectURL(user.getBucketAvatar(), user.getUserAvatar(), 7);
    }

    /**
     * @param ID
     * @return
     * @throws Exception
     */
    @GetMapping("/updateAvatar")
    public boolean updateAvatar(@RequestParam(name = "staffId") String ID,
                                @RequestParam(name = "files") MultipartFile file) {
        boolean tag = false;
        if (file.isEmpty()) {
            return tag;
        }
        LoginUser loginUser = loginUserService.queryById(ID);
        MinioRespond minioRespond = null;
        String bucketName = loginUser.getBucketAvatar();
        try {
            minioRespond = minioUtil.uploadFile(file, bucketName);
            if (minioRespond.getObjectWriteResponse() != null) {
                tag = true;
                loginUser.setUserAvatar(file.getName());
                loginUserService.update(loginUser);
            }
        } catch (Exception e) {
            logger.error("上传失败 : [{}]", Arrays.asList(e.getStackTrace()));
        }
        return tag;
    }
}

