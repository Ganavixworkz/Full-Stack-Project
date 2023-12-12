package com.xworkz.rto.repository;



import java.util.List;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;

public interface RtoRepository {
public boolean onSave(RtoDto dto);
public boolean onSave(UserDto udto);

public List<RtoEntity> findAll();
public List<UserEntity> userFindAll();

public RtoEntity checkLogin(String email,String password);
public RtoEntity adminLogin(String email,String otp);
public RtoEntity forgotPass(String email,String otp);


public UserEntity userLogin(String apporphone,String dob) ;

public abstract List<RtoEntity> searchByState(String state);

public abstract List<UserEntity> searchByUserState(String state);
public abstract boolean updateStatus(String applicationNumber);
public abstract boolean updateById(int id);
public boolean updateOtpById(RtoDto rtoDto);
public boolean updatePassword(RtoDto rtoDto,String password,String confirmPassword) ;




}