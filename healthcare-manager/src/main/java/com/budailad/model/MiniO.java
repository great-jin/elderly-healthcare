package com.budailad.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MiniO {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    public String getEndpoint() {
        return endpoint;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
