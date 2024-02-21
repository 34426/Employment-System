package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.annotation.IgnoreAuth;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.util.Base64Util;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ConfigEntity;
import com.service.CommonService;
import com.service.ConfigService;
import com.utils.FileUtil;
import com.utils.R;

/**
 * 通用接口
 */
@RestController
public class CommonController{
	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ConfigService configService;
	
	private static AipFace client = null;

	/**
	 * 获取table表中的column列表(联动接口)
	 * @param
	 * @param
	 * @return
	 */
	@IgnoreAuth
	@RequestMapping("/option/{tableName}/{columnName}")
	public R getOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName,String level,String parent) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		if(StringUtils.isNotBlank(level)) {
			params.put("level", level);
		}
		if(StringUtils.isNotBlank(parent)) {
			params.put("parent", parent);
		}
		List<String> data = commonService.getOption(params);
		return R.ok().put("data", data);
	}
	
	/**
	 * 根据table中的column获取单条记录
	 * @param
	 * @param
	 * @return
	 */
	@IgnoreAuth
	@RequestMapping("/follow/{tableName}/{columnName}")
	public R getFollowByOption(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName, @RequestParam String columnValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		params.put("columnValue", columnValue);
		Map<String, Object> result = commonService.getFollowByOption(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 修改table表的sfsh状态
	 * @param
	 * @param map
	 * @return
	 */
	@RequestMapping("/sh/{tableName}")
	public R sh(@PathVariable("tableName") String tableName, @RequestBody Map<String, Object> map) {
		map.put("table", tableName);
		commonService.sh(map);
		return R.ok();
	}

	/**
	 * 单列求和
	 */
	@IgnoreAuth
	@RequestMapping("/cal/{tableName}/{columnName}")
	public R cal(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		Map<String, Object> result = commonService.selectCal(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * 分组统计
	 */
	@IgnoreAuth
	@RequestMapping("/group/{tableName}/{columnName}")
	public R group(@PathVariable("tableName") String tableName, @PathVariable("columnName") String columnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("column", columnName);
		List<Map<String, Object>> result = commonService.selectGroup(params);
		return R.ok().put("data", result);
	}
	
	/**
	 * （按值统计）
	 */
	@IgnoreAuth
	@RequestMapping("/value/{tableName}/{xColumnName}/{yColumnName}")
	public R value(@PathVariable("tableName") String tableName, @PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", tableName);
		params.put("xColumn", xColumnName);
		params.put("yColumn", yColumnName);
		List<Map<String, Object>> result = commonService.selectValue(params);
		return R.ok().put("data", result);
	}
	
}
