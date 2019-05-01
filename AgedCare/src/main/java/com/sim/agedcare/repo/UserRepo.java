package com.sim.agedcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sim.agedcare.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Query("select u from User u where username=:username and password=:password ")
	User findUser(@Param("username") String name, @Param("password") String password);
}
