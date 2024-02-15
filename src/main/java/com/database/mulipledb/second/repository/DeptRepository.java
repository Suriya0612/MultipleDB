package com.database.mulipledb.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.mulipledb.second.entity.Department;
@Repository
public interface DeptRepository extends JpaRepository<Department,Long> {

}
