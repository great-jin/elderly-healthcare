package com.budailad;

import io.minio.*;
import io.minio.http.Method;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class MinioTest {

    /**
     * 参考文档
     *
     * https://docs.min.io/docs/java-client-api-reference.html
     * https://docs.aws.amazon.com/AmazonS3/latest/userguide/BucketRestrictions.html
     */

    public MinioClient minioClient;

    /**
     * Describe：初始化 Minio 对象
     */
    @Before
    public void init() throws Exception {
        minioClient = MinioClient.builder()
                // 填入 Minio API
                .endpoint("http://47.100.200.104:9000")
                // 填入用户名、密码
                .credentials("budai", "budai7417..")
                .build();
    }

    @Test
    public void MinioUrl() throws Exception{
        String bucketName = "webtest";
        String objectName = "1.jpg";
        Integer expires = 7;
        String pathHEAD = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName)
                .object(objectName)
                .expiry(expires, TimeUnit.DAYS)
                .build());

        System.out.println(pathHEAD);
    }
}
