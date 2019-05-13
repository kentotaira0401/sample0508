package jp.co.rakus.sample0508.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.rakus.sample0508.domain.Employee;
import jp.co.rakus.sample0508.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	
	@RequestMapping("/execute")
	public String execute() {
		
		Employee employee = new Employee();
		employee.setName("山田");
		employee.setAge(20);
		employee.setGender("男");
		employee.setDevelopmentId(1);
		service.save(employee);
		
		Employee employee2 = service.load(3);
		System.out.println(employee2);
		service.deleteById(3);
		service.findAll().forEach(System.out::println);
		
		return "処理終了　コンソール見て";
	}
}
