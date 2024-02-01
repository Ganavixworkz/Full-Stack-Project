package com.xworkz.rto.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.DlDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.DlEntity;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.repository.RtoDlRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class RtoDlImpl implements RtoDlService{
	@Autowired
	RtoDlRepository repo;
	
	@Override
	public boolean onSave(DlDto dto) {
		int randomNumber = (int) ((Math.random()*800)); String
		  otp=String.valueOf(randomNumber);
		String code=null;
		  if (dto.getState().equals("Karnataka")) {
		  code="KA2023DL" + otp;
		  } 
		  dto.setApplicationNumber(code);
		 
		repo.onSave(dto);
		log.debug("dto{}"+dto);
		return true;
	}
	
	@Override
	public boolean updateByIdDl(int id) {
		boolean update=repo.updateByIdDl(id);
		return update;
	}

	@Override
	public DlDto findByApplication(String applicationNumber) {
		DlEntity entity=repo.findByApplication(applicationNumber);
		DlDto dto=new DlDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public boolean updateByDl(DlDto ddl) {
		DlEntity entity=new DlEntity();
		BeanUtils.copyProperties(ddl, entity);

		boolean update=repo.updateByDl(entity);
		System.out.println("servi"+entity);
     return update;
	}

}
