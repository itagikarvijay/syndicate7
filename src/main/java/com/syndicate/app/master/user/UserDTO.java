/**
 * 
 */
package com.syndicate.app.master.user;

import lombok.Data;

import java.util.Set;

/**
 * @author User
 *
 */
@Data
public class UserDTO {

	private Long id;
	private String name;
	
	private String password;
	private String token;
	private String user;
	private Long storeId;

	private Set<String> roles;

	private boolean found = false;

	private String login_failuer_message;
//	private Store store;



}
