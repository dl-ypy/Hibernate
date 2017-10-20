关联关系

一对一：
	主键关联：
		one-to-one     cascade="all"将表关联起来
	外键关联： 也就是一对多，多的一方设置为唯一
		主表：one-to-one
		从表：many-to-one   unique="true" 将外键字段设为唯一

一对多：
	主表：
		set   key      one-to-many
	从表：     many-to-one

多对多：
	创建联合表
	set table key    many-to-many
	
注：cascade、unique、inverse的使用。
	
配置：
配置hibernate环境
在HibernateSessionFactory.xml中写添加了事务的CRUD方法。
修改pojo中实体类的一些属性。
配置实体类对应的xml文件。
编写单元测试文件。