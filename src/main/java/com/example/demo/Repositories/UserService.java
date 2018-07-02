package com.example.demo.Repositories;

import com.example.demo.Dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User,Long> {
}
