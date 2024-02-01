package com.xworkz.rto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.entity.RtoEntity;
import com.xworkz.rto.entity.UserEntity;
import com.xworkz.rto.repository.RtoRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RtoServiceImplementation implements RtoService {
	@Autowired
	RtoRepository repo;

	public RtoServiceImplementation() {
		log.info("this is RtoServiceImplementation");
	}

	@Override
	public Set<ConstraintViolation<RtoDto>> onSave(RtoDto dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator valid = factory.getValidator();
		Set<ConstraintViolation<RtoDto>> voilations = valid.validate(dto);
		if (voilations.isEmpty()) {
			repo.onSave(dto);
			System.err.println("###################"+dto);
			log.info("Data saved succesfully....");
		} else {
			log.info("Voilations are present" + voilations);
			return voilations;
		}
		return voilations;

	}
	
	@Override
	public boolean onSave(UserDto udto) {
		int randomNumber = (int) ((Math.random()*800)); String
		  otp=String.valueOf(randomNumber); String code=null;
		  if (udto.getState().equals("Karnataka")) {
		  code="KA2023LLR" + otp; } udto.setApplicationNumber(code);
		 
		repo.onSave(udto);
		log.debug("udto{}"+udto);
		return true;
			
	}

	@Override
	public List<RtoDto> findAll() {

		List<RtoEntity> entityList = repo.findAll();

		List<RtoDto> dtoList = new ArrayList<RtoDto>();

		for (RtoEntity en : entityList) {
			log.debug("{}"+en);
			RtoDto dto = new RtoDto();
			BeanUtils.copyProperties(en, dto);
			dtoList.add(dto);
		}
		log.info(dtoList.toString());
		return dtoList;
	}
	
	/*
	 * @Override public List<UserDto> userFindAll() { List<UserEntity>
	 * userEntityList = repo.userFindAll();
	 * 
	 * List<UserDto> UserdtoList = new ArrayList<UserDto>();
	 * 
	 * for (UserEntity userentity : userEntityList) {
	 * System.out.println(userentity); UserDto udto = new UserDto();
	 * BeanUtils.copyProperties(userentity, udto); UserdtoList.add(udto); }
	 * System.out.println(UserdtoList.toString()); return UserdtoList; }
	 */

	@Override
	public RtoDto checkLogin(String email, String password) {
		RtoEntity entity = repo.checkLogin(email, password);
		//if (email != null && password != null & password.length() >= 8) {
		//	if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equals(email) && dto.getPassword().equals(password)) {
					return dto;
				} else {
					log.info("Invalid email or password");
					return null;
				}
			//} else {
			//	System.out.println("Entity is null");
			//	return null;
		//	}
	//	} else {
		//	System.out.println("email or password is null");
		//	return null;
		//}
	}
	@Override
	public RtoDto adminLogin(String email, String otp) {
		if (email != null && otp != null) {
			RtoEntity entity = repo.checkLogin(email, otp);
			if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equals(email) && dto.getOtp().equals(otp)) {
					return dto;

				
				} else {
					log.info("Invalid email or otp");
					return null;
				}
			} else {
				log.info("Entity is null");
				return null;
			}
		} else {
			log.info("email or otp is null");
		return null;
	}
}
	
	
	public RtoDto forgotPass(String email, String otp) {
		if (email != null && otp != null) {
			RtoEntity entity = repo.checkLogin(email, otp);
			if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equals(email) && dto.getOtp().equals(otp)) {
					return dto;
				} else {
					log.info("Invalid email or otp");
					return null;
				}
			} else {
				log.info("Entity is null");
				return null;
			}
		} else {
			log.info("email or otp is null");
		return null;
	}
}
	
	@Override
	public UserDto userLogin(String apporphone, String dob) {
		if(apporphone!=null  && dob!=null) {
			UserEntity uentity=repo.userLogin(apporphone, dob);
			if(uentity!=null) {
				UserDto udto=new UserDto();
				BeanUtils.copyProperties(uentity, udto);
				if(udto.getApplicationNumber().equals(apporphone) && udto.getDob().equals(dob)) {
					return udto;
				}else {
					log.info("Invalid login credentials");
					return null;
					}
		}else {
			log.info("Entity is null");
			return null;
		}
		}else {
			log.info("credentials are null");
		return null;
	}
	}

	@Override
	public List<RtoDto> searchByState(String state) {
		
		log.info("search by state:"+state);
		List<RtoEntity> entityList=repo.searchByState(state);
		
List<RtoDto> dtoList=new ArrayList<RtoDto>();
		
		for(RtoEntity en:entityList) {
			log.debug("{}"+en);
			RtoDto dto=new RtoDto();
			BeanUtils.copyProperties(en,dto );
			dtoList.add(dto);
		}
		log.info(dtoList.toString());
		return dtoList;
	}

	@Override
	public List<UserDto> searchByUserState(String state) {
		log.info("search by state:"+state);
		List<UserEntity> entityList=repo.searchByUserState(state);
		List<UserDto> udtoList=new ArrayList<UserDto>();
		for(UserEntity uen:entityList) {
			log.debug("{}"+uen);
			UserDto udto=new UserDto();
			BeanUtils.copyProperties(uen,udto );
			udtoList.add(udto);
			}
		return udtoList;
	}

	

	@Override
	public boolean updateStatus(String applicationNumber) {
		repo.updateStatus(applicationNumber);
		return true;
	}

	@Override
	public boolean updateById(int id) {
		boolean update=repo.updateById(id);
		return update;
	}

	@Override
	public boolean updateOtpById(RtoDto rtoDto,String otp) {
		rtoDto.setOtp(otp);
		boolean otpupdate=repo.updateOtpById(rtoDto); 
		
		return otpupdate;
		
	}

	@Override
	public boolean updatePassword(RtoDto rtoDto, String password, String confirmPassword) {
		rtoDto.setPassword(password);
		rtoDto.setConfirmPassword(confirmPassword);
		boolean passwordUpdate=repo.updatePassword(rtoDto, password, confirmPassword) ;
		
		return passwordUpdate;
	}

	@Override
	public boolean updateLoginCount(RtoDto rtoDto) {
		boolean logincount=repo.updateLoginCount(rtoDto);
		return logincount;
	}
	
	
	
	public UserDto dlEntry(String applicationNumber) {
		if(applicationNumber!=null) {
			UserEntity uentity=repo.dlEntry(applicationNumber);
			if(uentity!=null) {
				UserDto udto=new UserDto();
				BeanUtils.copyProperties(uentity, udto);
				if(udto.getApplicationNumber().equals(applicationNumber)) {
					return udto;
				}else {
					log.info("Invalid login credentials");
					return null;
					}
		}else {
			log.info("Entity is null");
			return null;
		}
		}else {
			log.info("credentials are null");
		return null;
	}
	}

	@Override
	public UserDto findApplication(String applicationNumber) {
		UserEntity entity=repo.findApplication(applicationNumber);
		UserDto dto=new UserDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	
	
	/*public RtoDto checkotp(String email, String otp) {
		RtoEntity entity = repo.checkLogin(email, otp);
		//if (email != null && password != null & password.length() >= 8) {
		//	if (entity != null) {
				RtoDto dto = new RtoDto();
				BeanUtils.copyProperties(entity, dto);
				if (dto.getEmail().equals(email) && dto.getPassword().equals(otp)) {
					return dto;
				} else {
					System.out.println("Invalid email or password");
					return null;
				}*/
	
}

