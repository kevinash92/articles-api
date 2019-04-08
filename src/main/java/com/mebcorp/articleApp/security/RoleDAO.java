package com.mebcorp.articleApp.security;

import org.springframework.data.repository.CrudRepository;

public interface RoleDAO extends CrudRepository<Role, Long> {
	Role findRoleByName(String name);
}
