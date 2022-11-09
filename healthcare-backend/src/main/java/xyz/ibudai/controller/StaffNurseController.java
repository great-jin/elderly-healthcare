package xyz.ibudai.controller;

import xyz.ibudai.entity.StaffDoctor;
import xyz.ibudai.entity.StaffNurse;
import xyz.ibudai.entity.dto.JsonData;
import xyz.ibudai.service.StaffDoctorService;
import xyz.ibudai.service.StaffNurseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * (StaffNurse)表控制层
 *
 * @author Budai
 * @since 2022-03-11 16:21:06
 */
@RestController
@RequestMapping(value = "/api/healthcare/staffNurse")
public class StaffNurseController {
    /**
     * 服务对象
     */
    @Resource
    private StaffNurseService staffNurseService;

    @Resource
    private StaffDoctorService staffDoctorService;

    /**
     * 条件查询
     *
     * @param staffNurse 筛选条件
     * @return 查询结果
     * @ pageRequest 分页对象
     */
    @GetMapping("/list")
    public ResponseEntity<List<StaffNurse>> conditionQuery(StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.conditionQuery(staffNurse));
    }

    @GetMapping("/getTree")
    public ResponseEntity<List<StaffNurse>> getTree(StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.conditionQuery(staffNurse));
    }

    /**
     * 医师比例
     *
     * @param staffNurse
     * @return
     */
    @GetMapping("/getCount")
    public ResponseEntity<List<JsonData>> getCount(StaffNurse staffNurse) {
        int nurseNum = staffNurseService.conditionQuery(new StaffNurse()).size();
        int doctorNum = staffDoctorService.conditionQuery(new StaffDoctor()).size();
        List<JsonData> charList = new ArrayList<>();
        charList.add(new JsonData("护士", new AtomicInteger(nurseNum)));
        charList.add(new JsonData("医师", new AtomicInteger(doctorNum)));
        return ResponseEntity.ok(charList);
    }

    /**
     * 分页查询
     *
     * @param staffNurse  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/page")
    public ResponseEntity<Page<StaffNurse>> queryByPage(StaffNurse staffNurse, PageRequest pageRequest) {
        return ResponseEntity.ok(this.staffNurseService.queryByPage(staffNurse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get")
    public ResponseEntity<StaffNurse> queryById(@RequestParam(value = "id") Integer id) {
        return ResponseEntity.ok(this.staffNurseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param staffNurse 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public ResponseEntity<StaffNurse> add(@RequestBody StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.insert(staffNurse));
    }

    /**
     * 编辑数据
     *
     * @param staffNurse 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public ResponseEntity<Boolean> edit(@RequestBody StaffNurse staffNurse) {
        return ResponseEntity.ok(this.staffNurseService.update(staffNurse) > 0);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.staffNurseService.deleteById(id));
    }

}

