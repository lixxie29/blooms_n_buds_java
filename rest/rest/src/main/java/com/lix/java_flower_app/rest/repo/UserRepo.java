package com.lix.java_flower_app.rest.repo;

import com.lix.java_flower_app.rest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
}
