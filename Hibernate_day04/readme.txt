ץȡ���ԣ�
	�����Ӧ�ó�����Ҫ�ڣ�hibernateʵ�����ͼ��������ϵ����е���ʱ����ȡ��������Ĳ��ԡ�
	�ӱ����ݵĻ�ȡ����
	1��1��
	   select����ͨ��ѯ���ӳټ�����Ч
	   join��Ĭ��������������ӵķ�ʽ���ӳټ�����Ч
	1�Զ�	:   
		select:ÿ������һ��
		join
		subselect:�����������ݶ�Ӧһ��sql���,  ʹ��in(select from ...)
		������:(select+batch-size)��������in��ѯ,batch-size��ʾ������ĸ���  ��ʽ in(?,?...)
			��hibernate.cfg.xml�����ã�
				<property name="default_batch_fetch_size">10</property>
				��ʾȫ�ֵ�����in��ѯ���١�
		
�������
	1�����棺session���𣬱Ƚ϶̡�(�ڴ�����һ���൱��Map�����ڱ��滺������)
	2������:sessionFactory���𣨽��̷�Χ��
		���ã�
		����jar����ehcache-core-2.4.3.jar��hibernate-ehcache-4.2.21.Final.jar��slf4j-api-1.6.1.jar
		hibernate.cfg.xml:
		<!-- ���ö������� -->
		<property name="cache.use_second_level_cache">true</property>
		<property name="cache.region.factory_class">
			org.hibernate.cache.ehcache.EhCacheRegionFactory
		</property>
		
		��Ӧmapper.xml:
		<!-- ���ö������� -->
        <cache usage="read-only"/>