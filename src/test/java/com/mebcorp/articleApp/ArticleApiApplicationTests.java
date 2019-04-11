package com.mebcorp.articleApp;

import java.time.Instant;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;
import com.mebcorp.articleApp.entities.Author;
import com.mebcorp.articleApp.metier.IMetier;
import com.mebcorp.articleApp.security.Account;
import com.mebcorp.articleApp.security.AccountDAO;
import com.mebcorp.articleApp.security.AccountRole;
import com.mebcorp.articleApp.security.AccountRoleDAO;
import com.mebcorp.articleApp.security.Role;
import com.mebcorp.articleApp.security.RoleDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleApiApplicationTests {
	@Autowired
	private IMetier metier;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private AccountRoleDAO accountRoleDAO;
	
	private static BCryptPasswordEncoder encoder;
	
	static {
		encoder = new BCryptPasswordEncoder();
	}
	
	@Test
	public void contextLoads() {
		System.out.println("######################################");
		System.out.println("######  TESTING METIER LAYER    ######");
		System.out.println("######################################");

		// Creating new Author once.
		if (metier.getAllAuthors().size() ==0) {
			Author author = new Author("Doe", "John", "Milan, City", Date.from(Instant.now()), "homme");
			metier.createAuthor(author);
		}

		// update
//		Author author = new Author("Joe", "Dassin", "La Seine", Date.from(Instant.now()), "homme");
//		metier.updateAuthor((long)1, author);

		// create article once
//		if (metier.getAllArticles().size() == 0) {
//			Article article = new Article("Rencontre avec le futur", "Lorem ipsum dolor sit amet");
//			metier.createArticle((long)1, article);
//		}

//		//liste author
//		display("Liste d'auteurs", metier.getAllAuthors());
//
//		System.out.println();
//
//		display("Listes d'articles de "+metier.getAuthorById((long)7).getLastname(), metier.getAuthorArticles((long)7));
//
//		System.out.println();
//
//		System.out.println("Auteur de l'article "+metier.getArticleById((long)7).getTitle() +":==> "+ metier.getArticleAuthor((long)7));
//		
//		System.out.println();
		
		Account account = accountDAO.findById((long)7).get();
		
		System.out.println("+++++++++++>"+account);
		
		for (Role role : accountDAO.getRoles(account.getId())) {
			System.out.println(role.getName());
		}

		//		metier.deleteArticle((long)3);

	}

	
	public void securityTests() {
		// create role
		if(Lists.newArrayList(roleDAO.findAll()).size() == 0) {
			Role role = new Role("ROLE_ADMIN");
			roleDAO.save(role);

			role = new Role("ROLE_USER");
			roleDAO.save(role);

			role = new Role("ROLE_GUEST");
			roleDAO.save(role);
		}

		display("Liste des roles", Lists.newArrayList(roleDAO.findAll()));

		// create account
		if(Lists.newArrayList(accountDAO.findAll()).size() == 0) {
			Account account = new Account("admin", encoder.encode("admin"), "admin@test.com");
			accountDAO.save(account);
			
			account = new Account("user", encoder.encode("user"), "user@test.com");
			accountDAO.save(account);
			
			account = new Account("guest", encoder.encode("user"), "guest@email.com");
			accountDAO.save(account);
		}
		
		System.out.println();
		
		display("Liste des comptes", Lists.newArrayList(accountDAO.findAll()));
		
		Account adminAcc = accountDAO.findAccountByLogin("admin");
		Account userAcc = accountDAO.findAccountByLogin("user");
		Account guestAcc = accountDAO.findAccountByLogin("guest");
		
		if(Lists.newArrayList(accountRoleDAO.findAll()).size() == 0) {
			
			
			Role admin = roleDAO.findRoleByName("ROLE_ADMIN");
			Role user = roleDAO.findRoleByName("ROLE_USER");
			Role guest = roleDAO.findRoleByName("ROLE_GUEST");
			
			AccountRole arAdmin = new AccountRole(adminAcc, admin);
			AccountRole arUser = new AccountRole(userAcc, user);
			AccountRole arGuest = new AccountRole(guestAcc, guest);
			
			accountRoleDAO.save(arAdmin);
			accountRoleDAO.save(arUser);
			accountRoleDAO.save(arGuest);
		}
		
	}

	private void display(String message, Iterable<?> elements) {
		System.out.println(message);
		for (Object element : elements) {
			System.out.println(element);
		}
	}


}
