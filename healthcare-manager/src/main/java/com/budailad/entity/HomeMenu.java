package com.budailad.entity;

import java.io.Serializable;

/**
 * (HomeMenu)实体类
 *
 * @author Budai
 * @since 2022-04-04 12:12:46
 */
public class HomeMenu implements Serializable {
    private static final long serialVersionUID = -56768433519298482L;

    private Integer id;

    private String menuType;

    private String menuIcon;

    private String menuTitle;

    private String routerName;

    private Integer isShow;

    private String menuKey;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

}

