package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.entity.Students;

public interface StudentsRepository extends JpaRepository<Students, Integer>{

}
