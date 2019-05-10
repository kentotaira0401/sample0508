package jp.co.rakus.sample0508.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.rakus.sample0508.domain.Employee;
import jp.co.rakus.sample0508.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public Employee load(Integer id) {
		return repository.load(id); 
	}
	
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	public Employee save(Employee employee) {
		return repository.save(employee);
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}}
