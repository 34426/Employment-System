package com.entity.model;

import com.entity.MessagesEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 留言板
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date
 */
public class MessagesModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 留言人id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：留言人id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：留言人id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
