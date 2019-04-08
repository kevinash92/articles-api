package com.mebcorp.articleApp.security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountDAO extends CrudRepository<Account, Long> {
	// liste des rôles d'un utilisateur identifié par son id
	@Query("select ar.role from AccountRole ar where ar.account.id=?1")
	Iterable<Role> getRoles(long id);
	// liste des rôles d'un utilisateur identifié par son login et son mot de passe
	@Query("select ar.role from AccountRole ar where ar.account.login=?1 and ar.account.password=?2")
	Iterable<Role> getRoles(String login, String password);
	// recherche d'un utilisateur via son login et email
	Account findAccountByLogin(String login);
	Account findAccountByEmail(String email);
}
