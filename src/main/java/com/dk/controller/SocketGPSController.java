package com.dk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.entity.SocketGPSEntity;
import com.dk.result.DKResult;
import com.dk.service.SocketGPSService;

@Controller
@RequestMapping("socketgps")
public class SocketGPSController {
	@Resource
	private SocketGPSService gpsService;
	
	@RequestMapping("save.ll")
	@ResponseBody
	public DKResult saveSocketGps(SocketGPSEntity socketGpsEntity){
		DKResult result = new DKResult();
		result = gpsService.addSocketGPSEntity(socketGpsEntity);
		return result;
	}
	

}
