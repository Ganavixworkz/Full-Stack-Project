package com.xworkz.rto.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.rto.dto.RtoDto;
import com.xworkz.rto.dto.UserDto;
import com.xworkz.rto.mail.RtoMail;
import com.xworkz.rto.mail.RtoMailImpl;
import com.xworkz.rto.service.RtoService;

import io.quarkus.runtime.Application;

@Controller
@RequestMapping("/")
public class RtoController {
	
	@Autowired
	RtoService ser;
	
	@Autowired
	RtoMail rtoMail;
	
public RtoController() {
System.out.println("RtoController");
}

@PostMapping("/save")
public String onSave(@ModelAttribute RtoDto dto,Model model) {
	List<RtoDto> dtos=ser.findAll();
	for(RtoDto rto : dtos) {
		if(rto.getEmail().equalsIgnoreCase(dto.getEmail())) {
			model.addAttribute("err", "*Email is already exists");
			return "signup";
		}else {
	model.addAttribute("Dto", dto);
	
	Set<ConstraintViolation<RtoDto>> voilations=ser.onSave(dto);
		
	if(voilations.isEmpty()) {
		model.addAttribute("message", "No Voilation it is valid data");
		model.addAttribute("success", "Registered Successfully");
		return "signup";
	}else {
		model.addAttribute("voilations", voilations);
		return "signup";
	}
}
}
	return "signup";
}


@PostMapping("/user")
public String onSave(@ModelAttribute UserDto udto,Model model) {
	//List<UserDto> udtos=ser.userFindAll();
	

	//for(UserDto urto :udtos ) {
		ser.onSave(udto);
		if(udto.getApplicationNumber()!=null) {
		model.addAttribute("success", "Registered Successfully!!!! "
				+ " Application Number:"+udto.getApplicationNumber() );
		}
		
		/* if(urto.getEmail().equalsIgnoreCase(udto.getEmail())) {
		 model.addAttribute("uerr", "*Email is already exists"); 
		 return "userapplication"; 
		 }else {
			 model.addAttribute("uDto", udto);*/
			// return "userapplication"; }
		// }
		 
	return "userapplication";
		
	}
		
		
@GetMapping("findAll")
public String findAll(Model model) {
	List<RtoDto> dto=ser.findAll();
	System.out.println(dto.toString());
	model.addAttribute("dtos",dto);
	return "findall";
	}


@GetMapping("signin")
public String onLogin(@RequestParam String email, @RequestParam String password, Model model) {
	RtoDto dto = ser.checkLogin(email, password);
	List<UserDto> uDtos=ser.searchByUserState(dto.getState());
	if (dto != null) {
		model.addAttribute("dtos", dto.getFirstName().toUpperCase());
		model.addAttribute("Dto",dto );
		model.addAttribute("udtos", uDtos);

		return "profile";
	} else {
		model.addAttribute("err", "Invalid email or password");
		return "signin";
	}
}


//@GetMapping("admin")
//public String adminLogin(@ModelAttribute RtoDto rtoDto, @RequestParam String email, Model model ) {
//	//System.out.println(email+ " " + otp);
//
//	//RtoDto dto = ser.adminLogin(email, password);
//
//	//System.out.println(dto);
//
//	
//	List<RtoDto> list=ser.findAll();
//	for (RtoDto rtoDto2 : list) {
//		if(rtoDto2.getEmail().equals(email)) {
//			System.err.println(email);
//			rtoDto2=rtoDto;
//		}
//		
//	}
//	int randumNumber = (int) ((Math.random() * 90000) + 10000);
//
//	rtoMail.sendMail(email, String.valueOf(randumNumber));
//	model.addAttribute("otp", "sent successfully");
////	System.err.println(" beforeee update.."+otp);
//
//	ser.updateOtpById(rtoDto,String.valueOf(randumNumber));
////System.err.println("my otp.."+otp);
//	
//	return "admin";
//
//	//if (dto != null) {
//
//	//model.addAttribute("d", dto);
//
//	//List<UserDto> dtos = ser.searchByUserState(dto.getState());
//
////	if (!dtos.isEmpty()) {
//
//	//model.addAttribute("users", dtos);
//
////	} else { model.addAttribute("err", "No applicationfrom this state");
//
//	//}
//
//
////	return "adminprofile";
//
//	//} else model.addAttribute("exp", "*invalid email or otp");
//
//	//{
//
//	//}
//
//	//return "signin";
//
//}
//

@GetMapping("admin")
public String adminLogin(@RequestParam String email,@RequestParam String otp, Model model,String ganavi) {
	RtoDto rtoDto = null;
if(ganavi.equalsIgnoreCase("sendOtp")) {
	List<RtoDto> dtos = ser.findAll();
	for (RtoDto rtodto1 : dtos) {
		if (rtodto1.getEmail().equals(email)) {
			rtoDto = rtodto1;
			model.addAttribute("emailId", email);
			System.out.println("********"+rtoDto);
		}
	}
	// System.err.println(emailId + "my beautiful otp is " + otp);
	// RTODepartmentDTO dto = service.login(emailId, otp);
// System.out.println(dto);
	int randumNumber = (int) ((Math.random() * 90000) + 10000);
	boolean mail = rtoMail.sendMail(email, String.valueOf(randumNumber));
	// rtoDepartmentDTO = dto;
	System.err.println("my otp is" + String.valueOf(randumNumber));
	if (mail == true/* && rtoDto != null */) {
		ser.updateOtpById(rtoDto, String.valueOf(randumNumber));
		model.addAttribute("dt", rtoDto); 
		System.out.println(rtoDto);
		model.addAttribute("otp", "OTP sent");
		return "admin";
	}
		else {
			model.addAttribute("exp", "*invalid email or password");
					return "admin";
			}
		}else if (ganavi.equalsIgnoreCase("next")) {
			RtoDto dto=ser.adminLogin(email, otp);
			System.err.println("dto"+dto);
			if(dto!=null)
			 {
				model.addAttribute("dt", dto); 
				return "adminprofile"; 
				}else {
			  model.addAttribute("message", "Otp is invalid");
			
		System.out.println(rtoDto);
return "adminprofile";
	}
		
}
return "adminprofile";
}
		

	// List<RTOUserDTO> dtos = userService.findState(dto.getState());

//		if (!dtos.isEmpty()) {
//
//			model.addAttribute("users", dtos);
//		} else {
//			model.addAttribute("err", "No applicationfrom this state");
//		}

/*
 * @GetMapping("/checkotp") public String checkOtp(@RequestParam String
 * email,@RequestParam String otp,Model model) { RtoDto
 * dto=ser.checkLogin(email, otp); System.out.println("dto"+dto); if(dto!=null)
 * { model.addAttribute("dt", dto); return "adminprofile"; }else {
 * model.addAttribute("message", "Otp is invalid");
 * 
 * return "admin";
 */



@GetMapping("userlogin")
public String userLogin(@RequestParam String apporphone,@RequestParam String dob,Model model) {
	UserDto udto=ser.userLogin(apporphone, dob);
	if(udto!=null) {
		model.addAttribute("udt", udto);
		return "userprofile";
	}else {
		model.addAttribute("invalid", "Invalid credentials");
		return "userlogin";
	}
}

@GetMapping("seachbystate")
public String searchByState(@RequestParam String state,Model model) {
	List<RtoDto> dto=ser.searchByState(state);
	model.addAttribute("state",dto);
	return "searchbystate";
}

@GetMapping("userState")
public String userState(@RequestParam String state,Model model) {
	System.out.println("search by state......");
	List<UserDto> udto=ser.searchByUserState(state);
	model.addAttribute("ustate",udto);
	System.out.println(udto);
	return "profile";
}


@GetMapping("updateUserStatus")
public String userStatus(@RequestParam int id,Model model) {
	boolean update=		ser.updateById(id);

	if(update==true) {
		model.addAttribute("updateMessage", "Updated successfully");
		return "profile";
	}else {
		{
			model.addAttribute("updateMessage", "Not Updated");
			return "profile";
		}
	}
	}

@GetMapping("pass")
public String forgotPass(@RequestParam String email,@RequestParam String otp, Model model,String navi) {
	RtoDto rtoDto = null;
if(navi.equalsIgnoreCase("SendOtp")) {
	List<RtoDto> dtos = ser.findAll();
	for (RtoDto rtodto1 : dtos) {
		if (rtodto1.getEmail().equals(email)) {
			rtoDto = rtodto1;
			model.addAttribute("emailId", email);
			System.out.println("********"+rtoDto);
		}
	}
	// System.err.println(emailId + "my beautiful otp is " + otp);
	// RTODepartmentDTO dto = service.login(emailId, otp);
// System.out.println(dto);
	int randumNumber = (int) ((Math.random() * 90000) + 10000);
	boolean mail = rtoMail.sendMail(email, String.valueOf(randumNumber));
	// rtoDepartmentDTO = dto;
	System.err.println("my otp is" + String.valueOf(randumNumber));
	if (mail == true/* && rtoDto != null */) {
		ser.updateOtpById(rtoDto, String.valueOf(randumNumber));
		model.addAttribute("dt", rtoDto); 
		System.out.println(rtoDto);
		model.addAttribute("otp", "OTP sent");
		return "forgotpassword";
	}
		else {
			model.addAttribute("exp", "*invalid email or password");
					return "forgotpassword";
			}
		}else if (navi.equalsIgnoreCase("next")) {
			RtoDto dto=ser.forgotPass(email, otp);
			System.err.println("dto"+dto);
			if(dto!=null)
			 {
				model.addAttribute("dt", dto); 
				return "newpassword"; 
				}else {
			  model.addAttribute("message", "Otp is invalid");
			
		System.out.println(rtoDto);
return "newpassword";
	}
		}
return "newpassword";
}
			

/*@GetMapping("updateOtp")
public String updateOtp(@ModelAttribute RtoDto rtoDto,@RequestParam String otp,Model model) {
	boolean update=		ser.updateOtpById(rtoDto,otp);

	if(update==true) {
		model.addAttribute("updateMessage", "Updated successfully");
		return "adminprofile";
	}else {
		{
			model.addAttribute("updateMessage", "Not Updated");
			return "adminprofile";
		}
	}*/
	
@PostMapping("updatepassword")
	public String updatePassword(@RequestParam String email,
			@RequestParam String password,@RequestParam String confirmPassword,Model model) {
		RtoDto dto1=null;
		
		List<RtoDto> dtos=ser.findAll();
		for(RtoDto rtoDto1:dtos) {
			if(rtoDto1.getEmail().equals(email)) {
				dto1=rtoDto1;
			}
		}
		if(dto1!=null) {
			ser.updatePassword(dto1, password, confirmPassword);
			model.addAttribute("pass", "UpdatedPassword Successfully");
		}else {
			model.addAttribute("err", "Unsuccessfully");
		}
		return "newpassword";
	}

}


	


