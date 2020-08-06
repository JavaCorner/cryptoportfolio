package com.ab.cryptoportfolio.service;

import com.ab.cryptoportfolio.model.Authorities;
import com.ab.cryptoportfolio.userdetails.MFAUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ab.cryptoportfolio.entity.CryptoUser;
import com.ab.cryptoportfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceNoSql implements UserDetailsService {

	private final UserRepository userRepository;
	private static final boolean DEFAULT_ACC_NON_EXP = true;
	private static final boolean DEFAULT_CRED_NON_EXP = true;
	private static final boolean DEFAULT_ACC_NON_LOCKED = true;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CryptoUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		/*return User.withUsername(user.getUsername())
				.password(user.getPassword())
				.roles("USER")
				.disabled(!user.isVerified())
				.build();*/
		List<String> authorities = new ArrayList<>();
		//authorities.add("USER");
		if(user.isTotpEnabled()) {
			authorities.add(Authorities.TOTP_AUTH_AUTHORITY);
		} else {
			authorities.add(Authorities.ROLE_USER);
		}
		MFAUser springUser = new MFAUser(user.getUsername(),
				user.getPassword(),
				user.isVerified(),
				DEFAULT_ACC_NON_EXP,
				DEFAULT_CRED_NON_EXP,
				DEFAULT_ACC_NON_LOCKED,
				buildAuthorities(authorities));
		springUser.setSecurityPin(user.getSecurityPin());
		return springUser;
	}

	private List<GrantedAuthority> buildAuthorities(List<String> authorities) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
		for(String authority : authorities) {
			authList.add(new SimpleGrantedAuthority(authority));
		}
		return authList;
	}
}