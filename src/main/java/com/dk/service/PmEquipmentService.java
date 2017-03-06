package com.dk.service;

import com.dk.entity.PmEquipmentEntity;
import com.dk.result.DKResult;

public interface PmEquipmentService {
	DKResult getPmEquipmentEntitys();
	DKResult addPmEquipmentEntity(PmEquipmentEntity pmEquipmentEntity);
	DKResult updatPmEquipmentEntity(PmEquipmentEntity pmEquipmentEntity);
	DKResult deletePmEquipmentEntity(Integer id);

}
