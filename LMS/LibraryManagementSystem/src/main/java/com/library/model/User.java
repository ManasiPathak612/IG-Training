package com.library.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="user_table")
public class User {
	@Id
	@GeneratedValue
	private long userId;
	private String userName;
	private int userAge;
	private String gender;
	private String userMailId;
	private long mobileNum;
	private String userAddress;
	private String userType;
}
