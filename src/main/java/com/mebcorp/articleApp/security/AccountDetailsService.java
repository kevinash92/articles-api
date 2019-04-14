package com.mebcorp.articleApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailsService implements UserDetailsService {
	@Autowired
	private AccountDAO accountDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// on cherche l'utilisateur via son login
		Account account = accountDAO.findAccountByLogin(username);
		// trouvé ?
		if (account == null) {
			throw new UsernameNotFoundException(String.format("login [%s] inexistant", username));
		}
		// on rend les détails de l'utilsateur
		return new AccountDetails(account, accountDAO);
	}

}