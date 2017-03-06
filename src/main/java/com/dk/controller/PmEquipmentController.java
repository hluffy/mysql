package com.dk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.entity.PmEquipmentEntity;
import com.dk.result.DKResult;
import com.dk.service.PmEquipmentService;

@Controller
@RequestMapping("pmequipment")
public class PmEquipmentController {
	@Resource
	private PmEquipmentService pmEquipmentService;
	
	
	@RequestMapping("get.ll")
	@ResponseBody
	public DKResult getPmEquipmentEntitys(){
		DKResult result = new DKResult();
		result = pmEquipmentService.getPmEquipmentEntitys();
		return result;
	}
	
	@RequestMapping("save.ll")
	@ResponseBody
	public DKResult addPmEquipmentEntity(PmEquipmentEntity pmEquipmentEntity){
		DKResult result = new DKResult();
		result = pmEquipmentService.addPmEquipmentEntity(pmEquipmentEntity);
		return result;
	}

}
