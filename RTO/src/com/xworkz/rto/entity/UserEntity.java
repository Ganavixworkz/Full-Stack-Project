package com.xworkz.rto.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="User_info")
@NamedQueries({
	
	@NamedQuery(name="userFindAll",query = "select entity from UserEntity entity"),
	@NamedQuery(name="userLogin",query="select entity from  UserEntity entity where"
			+ " entity.applicationNumber=:aporpn or entity.phoneNumber=:aporpn and entity.dob=:db"),
	@NamedQuery(name = "searchByUserState" ,query = "select e from UserEntity e where e.state=:llrstate"),
	@NamedQuery(name="updatestatus",query = "update UserEntity e set e.status='Approved' where e.applicationNumber=:appNum ")
})

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
	private int id;
	
	@Column(name="FirstName")
    private String firstName;
	
	@Column(name="MiddleName")
    private String middleName;
	
	@Column(name="LastName")
    private String lastName;
	
	@Column(name="Gender")
    private String gender;
	
	@Column(name="State")
    private String state;
	
	@Column(name="Country")
    private String country;
	
	@Column(name="DOB")
    private String dob;
	
	@Column(name="Age")
	private int age;

	@Column(name="BloodGroup")
	private String bloodGroup;

	@Column(name="Qualification")
    private String qualification;
	
	@Column(name="PlaceOfBirth")
	private String placeOfBirth;

    @Column(name="RtoOffice")
    private String rtoOffice;
    
	@Column(name="PermanentAddress")
    private String permanentAddress;
	
	@Column(name="PermanentPincode")
	private int permanentPincode;
	
	@Column(name="CurrentAddress")
	private String currentAddress;
	
	@Column(name="CurrentPincode")
	private int currentPincode;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="PhoneNumber")
	private long phoneNumber;
	
	@Column(name="AadharNumber")
	private long aadharNumber;
	
	@Column(name="RegisteredDateTime")
	private LocalDateTime registeredDateTime;
	
	@Column(name="OrganDonation")
    private boolean organDonation;
	
	@Column(name="ApplicationNumber")
    private String applicationNumber;
	
	@Column(name="Status")
     private String status;
	
	@Column(name="OTP")
	private String otp;




}
