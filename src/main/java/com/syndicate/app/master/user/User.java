/**
 * 
 */
package com.syndicate.app.master.user;


import com.syndicate.app.master.role.Role;
import com.syndicate.app.master.store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author User
 *
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "user") // , uniqueConstraints = { @UniqueConstraint(columnNames = "id") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "store_id")
	private Long storeId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = {
			@JoinColumn(name = "user", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "role", referencedColumnName = "id") })
	private Set<Role> roles;
	
	@OneToOne
	@JoinColumn(name = "store_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Store store;

}
