package com.xworkz.rto.service;

import com.xworkz.rto.dto.DlDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.DlEntity;

public interface RtoDlService {
	public boolean onSave(DlDto dto);
	public abstract boolean updateByIdDl(int id);
	public DlDto findByApplication(String applicationNumber) ;
	public boolean updateByDl(DlDto ddl);

}
