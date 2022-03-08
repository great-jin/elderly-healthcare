package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (PatientDetails)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:26:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDetails implements Serializable {
    private static final long serialVersionUID = -97940837033686646L;

    private Integer id;

}

