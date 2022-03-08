package com.budailad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @Author Budai
 * @Since 2022-03-07 16:28:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser implements Serializable {
    private static final long serialVersionUID = 900791410939198691L;

    private Integer id;

    private String accountId;

    private String userName;

    private String password;

}

