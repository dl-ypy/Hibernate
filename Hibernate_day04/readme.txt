抓取策略：
	概念：当应用程序需要在（hibernate实体对象图）关联关系间进行导航时，获取关联对象的策略。
	从表数据的获取方法
	1对1：
	   select：普通查询，延迟加载有效
	   join（默认情况）：左连接的方式，延迟加载无效
	1对多	:   
		select:每条都查一次
		join
		subselect:多条主表数据对应一条sql语句,  使用in(select from ...)
		批处理:(select+batch-size)批量进行in查询,batch-size表示批处理的个数  格式 in(?,?...)
			在hibernate.cfg.xml中配置：
				<property name="default_batch_fetch_size">10</property>
				表示全局的批量in查询多少。
		
缓存管理
	1级缓存：session级别，比较短。(内存中有一个相当于Map对象在保存缓存数据)
	2级缓存:sessionFactory级别（进程范围）
		配置：
		导入jar包：ehcache-core-2.4.3.jar、hibernate-ehcache-4.2.21.Final.jar、slf4j-api-1.6.1.jar
		hibernate.cfg.xml:
		<!-- 配置二级缓存 -->
		<property name="cache.use_second_level_cache">true</property>
		<property name="cache.region.factory_class">
			org.hibernate.cache.ehcache.EhCacheRegionFactory
		</property>
		
		对应mapper.xml:
		<!-- 配置二级缓存 -->
        <cache usage="read-only"/>