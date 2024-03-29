package xyz.ibudai.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ibudai.model.MiniO;

@Configuration
@EnableConfigurationProperties(MiniO.class)
public class MinioConfig {

    @Autowired
    private MiniO miniO;

    /**
     * 初始化 Minio 对象
     */
    @Bean
    public MinioClient minioClient() {
        return io.minio.MinioClient.builder()
                .endpoint(miniO.getEndpoint())
                .credentials(miniO.getAccessKey(), miniO.getSecretKey())
                .build();
    }
}