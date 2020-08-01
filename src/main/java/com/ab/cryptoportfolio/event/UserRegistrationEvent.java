package com.ab.cryptoportfolio.event;

import com.ab.cryptoportfolio.entity.CryptoUser;
import org.springframework.context.ApplicationEvent;

import com.ab.cryptoportfolio.entity.CryptoUser;

import lombok.Getter;

@Getter
public class UserRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4113549487933175429L;
	private final CryptoUser user;
	
	public UserRegistrationEvent(CryptoUser user) {
		super(user);
		this.user=user;
	}

}
