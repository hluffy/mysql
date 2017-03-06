package com.dk.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dk.entity.MapWatchData;
import com.dk.result.DKResult;
import com.dk.service.MapWatchDataService;

@Controller
@RequestMapping("mapwatchdata")
public class MapWatchDataController {
	@Resource
	private MapWatchDataService mapWatchService;
	
	@RequestMapping("save.ll")
	@ResponseBody
	public DKResult saveMapWatchData(MapWatchData mapWatchData){
		DKResult result = new DKResult();
		result = mapWatchService.addMapWatchData(mapWatchData);
		return result;
	}

}
