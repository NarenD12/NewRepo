package com.infinite.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

//	@RequestMapping(value = "/username", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Authentication authentication) {
//        return authentication.getName();
//    }

	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	// create employee rest api
	@PostMapping("/employees/save")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PostMapping(path = "/employees/login")
	public LoginMessage loginEmployee(@RequestBody LoginFront loginFront) {
		Employee empemail = employeeRepository.findByEmailId(loginFront.getEmailId());
		if (empemail != null) {
			String email = empemail.getFirstName();
			String password = loginFront.getLastName();
			String emppass = empemail.getLastName();
			if (password.matches(emppass)) {
				return new LoginMessage(email, true);
			} else {
				return new LoginMessage("Email or Password are not Valid", false);
			}
		} else {
			return new LoginMessage("emailId not exist", false);
		}
	}
}
