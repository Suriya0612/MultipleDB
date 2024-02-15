package com.database.mulipledb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.database.mulipledb.first.entity.Student;
import com.database.mulipledb.first.repository.StudentRepository;
import com.database.mulipledb.second.entity.Department;
import com.database.mulipledb.second.repository.DeptRepository;


@Service
public class MainService {
	
	@Autowired
	 private StudentRepository studentRepository;
	
	 @Autowired
	 private DeptRepository deptRepository;
	 
	@Transactional(transactionManager="studentTransactionManager")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
	
	@Transactional(transactionManager="studentTransactionManager")
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}
 
    @Transactional(transactionManager="deptTransactionManager")
    public List<Department> getAllDepartment()
    {
        return deptRepository.findAll();
    }
    
    @Transactional(transactionManager="deptTransactionManager")
	public Department getDeptById(Long id) {
		return deptRepository.findById(id).get();
	}
 
}
