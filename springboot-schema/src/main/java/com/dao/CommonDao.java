
package com.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用接口
 * 主要与数据库进行交互
 *  DAO层主要是做数据持久层的工作，主要与数据库进行交互。
 *  DAO层首先会创建DAO接口，然后会在配置文件中定义该接口的实现类，
 *  接着就可以在模块中就可以调用DAO 的接口进行数据业务的而处理，并且不用关注此接口的具体实现类是哪一个类。
 *  DAO 层的数据源和数据库连接的参数数都是在配置文件中进行配置的。
 */
public interface CommonDao{
	List<String> getOption(Map<String, Object> params);
	
	Map<String, Object> getFollowByOption(Map<String, Object> params);
	
	void sh(Map<String, Object> params);
	
	int remindCount(Map<String, Object> params);
	
	Map<String, Object> selectCal(Map<String, Object> params);
	
	List<Map<String, Object>> selectGroup(Map<String, Object> params);
	
	List<Map<String, Object>> selectValue(Map<String, Object> params);

	List<String> getFollowByOption2(Map<String, Object> params);
}
