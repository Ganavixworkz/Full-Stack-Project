package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DlDto {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String country;
	private String dob;
	private int age;
	private String bloodGroup;
	private String qualification;
	private String placeOfBirth;
	private String permanentAddress;
	private int permanentPincode;
	private String currentAddress;
	private int currentPincode;
	private String email;
	private long phoneNumber;
	private long aadharNumber;
	private LocalDateTime registeredDateTime;
	private long citizenshipNumber;
	private long PassportNumber;
	private int trainerLicenseNo;
	private String trainerName;
	private String citizenshipIssuedDistrict;
	private String passportIssuedCountry;
	private String wFirstName;
	private String wMiddleName;
	private String wLastName;
	private String relationship;
	private String applicationNumber;
	private String state;
	private String status;
	private String file;
	private String contentType;



}
