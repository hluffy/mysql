package com.dk.service;


import com.dk.entity.CfgUrlEntity;
import com.dk.result.DKResult;

public interface CfgUrlService {
	DKResult addCfgUrlEntity(CfgUrlEntity cfgUrlEntity);
	DKResult getCfgUrlEntitys();
	DKResult updateCfgUrlEntity(CfgUrlEntity cfgUrlEntity);
	DKResult deleteCfgUrlEntity(Integer id);

}
