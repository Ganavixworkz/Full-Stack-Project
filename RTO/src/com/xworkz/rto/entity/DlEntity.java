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
@Table(name="dl_info")
@NamedQueries({
@NamedQuery(name="findByApplication",query = "select entity from DlEntity entity where entity.applicationNumber=:app "),

})

public class DlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    
    @Column(name="FirstName")
	private String firstName;
    
    @Column(name="MiddleName")
	private String middleName;
     
    @Column(name = "LastName")
	private String lastName;
    
    @Column(name = "Gender")
    private String gender;
    
    @Column(name = "Country")
    private String country;
    
    @Column(name = "Dob")
    private String dob;
    
    @Column(name = "Age")
    private int age;
    
    @Column(name = "BloodGroup")
    private String bloodGroup;
    
    @Column(name = "Qualification")
    private String qualification;
    
    @Column(name = "PlaceOfBirth")
    private String placeOfBirth;
    
    @Column(name = "PermanentAddress")
    private String permanentAddress;
    
    @Column(name = "PermanentPincode")
    private int permanentPincode;
    
    @Column(name = "CurrentAddress")
    private String currentAddress;
    
    @Column(name = "CurrentPincode")
    private int currentPincode;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "PhoneNumber")
    private long phoneNumber;
    
    @Column(name = "AadharNumber")
    private long aadharNumber;
    
    @Column(name = "RegisteredDateTime")
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
