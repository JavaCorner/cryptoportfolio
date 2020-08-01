package com.ab.cryptoportfolio.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.ab.cryptoportfolio.validation.PasswordConfirmed;
import com.ab.cryptoportfolio.validation.PasswordPolicy;
import com.ab.cryptoportfolio.validation.UniqueEmail;
import com.ab.cryptoportfolio.validation.UniqueUsername;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@PasswordConfirmed
public class UserDto {
	
	@NotEmpty(message="Please enter your firstname")
	private String firstname;
	@NotEmpty(message="Please enter your lastname")
	private String lastname;
	@NotEmpty(message="Please enter a username")
	@UniqueUsername
	private String username;
	@NotEmpty(message="Please enter an email")
	@UniqueEmail
	@Email(message="Email is not valid")
	private String email;
	@NotEmpty(message="Please enter in a password")
	@PasswordPolicy
	private String password;
	@NotEmpty(message="Please confirm your password")
	private String confirmPassword;
}
