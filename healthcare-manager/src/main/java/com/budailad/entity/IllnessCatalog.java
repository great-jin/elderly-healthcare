package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (IllnessCatalog)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:24:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IllnessCatalog implements Serializable {
    private static final long serialVersionUID = 731043928018335654L;
    /**
     * 疾病编号
     */
    private String illId;
    /**
     * 疾病类别
     */
    private String illType;
    /**
     * 疾病名
     */
    private String illName;
    /**
     * 备注
     */
    private String comment;

}

