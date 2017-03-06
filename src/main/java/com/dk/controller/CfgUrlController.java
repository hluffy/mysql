package com.dk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.entity.CfgUrlEntity;
import com.dk.result.DKResult;
import com.dk.service.CfgUrlService;

@Controller
@RequestMapping("cfgurl")
public class CfgUrlController {
	
	@Resource
	private CfgUrlService cfgService;
	
	@RequestMapping("get.ll")
	@ResponseBody
	public DKResult getCfgUrlEntitys(){
		DKResult result = new DKResult();
		result = cfgService.getCfgUrlEntitys();
		return result;
	}
	
	@RequestMapping("save.ll")
	@ResponseBody
	public DKResult addCfgUrlEntity(CfgUrlEntity cfgUrlEntity){
		DKResult result = new DKResult();
		result = cfgService.addCfgUrlEntity(cfgUrlEntity);
		return result;
	}
	
	@RequestMapping("update.ll")
	@ResponseBody
	public DKResult updateCfgUrlEntity(CfgUrlEntity cfgUrlEntity){
		DKResult result = new DKResult();
		result = cfgService.updateCfgUrlEntity(cfgUrlEntity);
		return result;
	}
	
	@RequestMapping("delete.ll")
	@ResponseBody
	public DKResult deleteCfgUrlEntity(Integer id){
		DKResult result = new DKResult();
		result = cfgService.deleteCfgUrlEntity(id);
		return result;
	}

}
