# gmall2020
Springboot+dubbo的模拟分布式商城微服务demo微服务项目

## web项目

1、gmall-admin-web

后台web项目，提供管理员注册，登录校验，商品上传下架，及文件上传等Controller层功能

2、gmall-shop-portal

前台web项目，提供商品检索、商品具体信息查询、用户登录、在线及离线购物车、订单创建及支付等Controller层功能

## 微服务项目

1、gmall-ums

提供用户管理员登录及信息查询等相关功能

2、gmall-pms

提供商品检索及商品信息详情查询等功能

3、gmall-cart

提供离线与在线购物车，商品加入或从购物车中删除

4、gmall-oms

提供确认订单，创建订单等微服务

5、gmall-payment

提供支付功能模块
