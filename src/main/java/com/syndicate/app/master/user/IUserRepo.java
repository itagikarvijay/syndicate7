/**
 * 
 */
package com.syndicate.app.master.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author User
 *
 */
@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

	Optional<User> findByName(String name);
}
