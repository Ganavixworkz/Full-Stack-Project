package com.xworkz.rto.repository;

import com.xworkz.rto.dto.DlDto;
import com.xworkz.rto.entity.DlEntity;
import com.xworkz.rto.entity.UserEntity;

public interface RtoDlRepository {
	public boolean onSave(DlDto dto);
	public abstract boolean updateByIdDl(int id);
	public DlEntity findByApplication(String applicationNumber) ;
public boolean updateByDl(DlEntity dl);

}
