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
    + 添加其他工具类，StringUtil , CastUtil , CollectionUtil等。
    + 添加数据库的DatabaseHelper类，提供sql的connection加载与关闭。
    + 完善service业务方法。
    + 添加dbutils的jar包，封装常规的getEntity，findList，Update，Insert操作。
    + 并将connection存放到ThreadLocal本地线程中。

    + 完善CustomerService中的增删改查方法。
    + 为避免频繁创建数据库连接，减小系统开销，引入连接池。DPCP连接池。

    + 完善JSP
到此，一个基本的web已经完成了。访问：
http://localhost:8080/web/test
http://localhost:8080/web/customer

+ 开始搭建属于自己的框架：
    + 修改配置文件加载。ConfigHelper 和 ConfigConstant
    + 新建类加载器。ClassUtil。本人难理解指数：★★★★★
    + 建立自己的Controller注解。
    + 新建类工具类，获取所有的类包、service集合、controller集合和bean集合。
### 疑问
1、类加载器加载所有class的方法。
2、Controller注解上的@Target与@Retention
3、class.isAnnotationPresent(Service.class)的函数意义。

