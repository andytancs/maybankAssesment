package com.maybank.maybankassesment.repo;

import com.maybank.maybankassesment.entity.UserProfile;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> , JpaSpecificationExecutor<User> {

    UserProfile findByName(String name);


}
