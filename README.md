## 疗养及养老一体化系统

### 一、系统介绍

#### 1. 使用技术介绍

系统为前后端分离工程，前台页面使用``Antd``开发，后端接口使用``Spring Boot``编写。

项目中数据库使用``MySQL``存储，使用``Redis``存储部分热点数据，使用``MinIO``存储头像等文件。



### 二、项目结构

```
+-- healthcare-frontend				# 前端工程目录
+-- healthcare-manager				# 后端工程目录
|   +-- pom.xml
+-- sql								        # 项目SQL脚本
|   +-- home_menu.sql
|   +-- elderly_healthcare.sql
+-- README.html 					    # 项目说明文档
```



### 三、使用说明

#### 1. 前端启动

前端基于 ``Vue`` 需要安装 ``Node.js``, 启动只需在 ``healthcare-frontend`` 目录下直接编译即可。

```bash
npm install

npm run dev
```



#### 2. 后端启动

后端启动需下载 ``Maven`` 依赖，IDEA安装 ``Maven Helper `` 插件在 ``healthcare-manager`` 目录下右击 ``pom.xml`` 文件选择 ``clear install`` 。



后端修改如下配置文件：

```xml
# MySQL 数据库
datasource:
  url: jdbc:mysql://127.0.0.1:3306/elderly_healthcare
  username: root			      	# 替换为你的用户名
  password: 123456			    	# 替换为你的密码

# Redis 数据库
redis:
  host: 127.0.0.1		  	# 替换为你的用户名
  port: 6379					
  password: 123456			# 替换为你的密码

# Minio数据库
minio:
  endpoint: http://127.0.0.1:9000		# 替换地址
  accessKey: minioadmin             # 替换为你的用户名
  secretKey: minioadmin			      	# 替换为你的密码

# 邮件配置
mail:
  host: smtp.163.com
  username: test_mail@163.com	   	# 替换为你的邮箱地址
  password: mail_token      	  	# 替换为你的邮箱 token
```
