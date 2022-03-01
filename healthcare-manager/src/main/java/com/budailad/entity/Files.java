package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Files {

    @Id
    @GeneratedValue
    private Integer ID;

    private String accountCode;

    private String fileName;

    private Date inTime;

    private String minioBucket;

    private String minioPath;

}
