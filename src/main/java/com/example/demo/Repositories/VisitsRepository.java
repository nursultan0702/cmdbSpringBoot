package com.example.demo.Repositories;

import com.example.demo.Entities.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitsRepository extends CrudRepository<Visit, Long> {
}
