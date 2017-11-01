/**
 * 
 */
package com.yehevah.opensource.intelligentfactory.userservice.ha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yehevah.opensource.intelligentfactory.userservice.ha.entities.User;

/**
 * @author Administrator
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
