package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (OrganizeDepart)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:25:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizeDepart implements Serializable {
    private static final long serialVersionUID = 759139013285495325L;
    /**
     * 编号
     */
    private String departId;
    /**
     * 部门名
     */
    private String departName;
    /**
     * 部门人数
     */
    private Integer manCount;

}

