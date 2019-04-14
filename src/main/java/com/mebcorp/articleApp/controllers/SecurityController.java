package com.mebcorp.articleApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mebcorp.articleApp.models.Response;
import com.mebcorp.articleApp.security.Account;
import com.mebcorp.articleApp.security.AccountDAO;
import com.mebcorp.articleApp.security.AccountDetails;
import com.mebcorp.articleApp.security.Role;
import com.mebcorp.articleApp.security.RoleDAO;

@RestController
public class SecurityController {
	@Autowired
	private AccountDAO accountDao;
	@Autowired
	private RoleDAO roleDao;
	
	@PostMapping("/signup")
	public Response signup(@RequestBody Account post) {
		String password = post.getPassword();
		post.setPassword(new BCryptPasswordEncoder().encode(password));
		accountDao.save(post);
		return new Response(0, null);
	}
	
	@PostMapping("/role")
	public Response addRole(@RequestBody Role post) {
		roleDao.save(post);
		return new Response(0, null);
	}
	
	@GetMapping("/currentuser")
	public ResponseEntity<?> currentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AccountDetails principal = (AccountDetails) authentication.getPrincipal();
        System.out.println("logged in user name:: " + principal.getUsername());
        
		return new ResponseEntity<>(new Response(0, principal), HttpStatus.OK);
	}
	
}
