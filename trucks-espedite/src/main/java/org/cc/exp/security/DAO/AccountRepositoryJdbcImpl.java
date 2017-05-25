/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cc.exp.security.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.cc.exp.domain.Account;
import org.cc.exp.security.sql.exceptions.UsernameAlreadyInUseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AccountRepositoryJdbcImpl implements AccountRepository {

	private final JdbcTemplate jdbcTemplate;

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AccountRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public void createAccount(Account user) throws UsernameAlreadyInUseException {
		try {
			jdbcTemplate.update(
					"insert into Account (firstName, lastName, username, password, role) values (?, ?, ?, ?, ?)",
					user.getFirstName(), user.getLastName(), user.getUsername(),
					passwordEncoder.encode(user.getPassword()), user.getRole());
		} catch (DuplicateKeyException e) {
			throw new UsernameAlreadyInUseException(user.getUsername());
		}
	}

	public Account findAccountByUsername(String username) {
		
	/**
	 * 	This is how it goes by the book - needs REDO  here. 
	 * 
	 * 	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MediaObject> criteriaQuery =
		criteriaBuilder.createQuery(Account.class);
		Root< Account > root = criteriaQuery.from(Account.class);
		Path<String> path = root.<String>get("username");
		criteriaQuery.where(criteriaBuilder.equal(path, username));
		return entityManager.createQuery(criteriaQuery).getResultList();  **/
		
		
		
		return jdbcTemplate.queryForObject("select username, password, firstName, lastName, role from Account where username = ?",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new Account(rs.getString("username"), rs.getString("password"), rs.getString("firstName"), rs
								.getString("lastName"), rs.getString("role"));
					}
				}, username);
	}

}
