package com.xworkz.rto.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
private int id;
private String firstName;
private String middleName;
private String lastName;
private String gender;
private String state;
private String country;
private String dob;
private int age;
private String bloodGroup;
private String qualification;
private String placeOfBirth;
private String rtoOffice;
private String permanentAddress;
private int permanentPincode;
private String currentAddress;
private int currentPincode;
private String email;
private long phoneNumber;
private long aadharNumber;
private LocalDateTime registeredDateTime;
private boolean organDonation;
private String applicationNumber;
private String status;
private String otp;



}
