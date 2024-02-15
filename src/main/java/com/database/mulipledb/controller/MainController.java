package com.database.mulipledb.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.database.mulipledb.first.entity.Student;
import com.database.mulipledb.first.repository.StudentRepository;
import com.database.mulipledb.second.entity.Department;
import com.database.mulipledb.second.repository.DeptRepository;
import com.database.mulipledb.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DeptRepository deptRepository;
	
	@Transactional(transactionManager="studentTransactionManager")
	@PostMapping("addstudent") 
    public String addNewStudent(@RequestBody Student student) { 
        studentRepository.save(student); 
        return "Success";
    }
	
	@GetMapping("student/{studentid}")
	public Student getStudents(@PathVariable("studentid") long studentid) {
		return mainService.getStudentById(studentid);
	}
	
	@GetMapping("getstudentdata")
	public List<Student> getAllStudent(){
		return mainService.getAllStudent();
	}
	
	@Transactional(transactionManager="deptTransactionManager")
	@PostMapping("adddept") 
    public String addNewDept(@RequestBody Department dept) { 
        deptRepository.save(dept); 
        return "Success";
    }
	
	@GetMapping("getDeptData")
	public List<Department> getAllDepartment(){
		return mainService.getAllDepartment();
	}
	
	@GetMapping("dept/{deptid}")
	public Department getDept(@PathVariable("deptid") long deptid) {
		return mainService.getDeptById(deptid);
	}
}
