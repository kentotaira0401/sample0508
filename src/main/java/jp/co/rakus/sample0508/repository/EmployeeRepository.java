package jp.co.rakus.sample0508.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.sample0508.domain.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Employee> EMPLOYEE_ROW_MAPPER = (rs,i) -> {
		
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setAge(rs.getInt("age"));
		employee.setGender(rs.getString("gender"));
		employee.setDevelopmentId(rs.getInt("development_id"));
		
		return employee;
	};
	
	
	public Employee load(Integer id) {

		String sql ="select id,name,age,gender,development_id "
				+ " from employees where id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		Employee employee = template.queryForObject(sql, param, EMPLOYEE_ROW_MAPPER);
		
		return employee;
	}
	
	public List<Employee> findAll(){
		System.out.println("repoのfindAll()呼ばれた");
		return new ArrayList<Employee>();
	}
	
	public Employee save(Employee employee) {
		System.out.println("repositoryのsave()が呼ばれた");
		return null;
	}
	public void deleteById(Integer id) {
		System.out.println("repositoryのdelete()が呼ばれた");
	}
}
