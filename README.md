# webdemo
## 设计用例：
    查询客户/显示客户列表/显示客户基本信息/创建客户/编辑客户/删除客户
## 设计表结构
    创建数据库。生成数据库脚本。webemo.sql
## 设计界面原型
## 设计URL

## 搭建开发环境
+ 创建数据库
+ 准备开发环境
+ 编写模型层model
+ 编写控制器层controller
+ 编写服务层 service
+ 编写单元测试 test
+ 编写视图层 jsp

## 细节完善与代码优化
+ 完善服务层
    + 添加日志管理jar包与logback配置文件。我们使用slf4j+logback
    + 添加mysql驱动包，添加mysql配置文件。
    + 添加常用工具类 common-lang3 和 Collections包
    + 既然有了mysql配置文件，则需要添加一个PropsUtil类来读取配置文件。
