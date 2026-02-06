package com.employeeapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeeapp.dto.DeptEmpResponse;
import com.employeeapp.entities.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	@Query("SELECT DISTINCT d FROM Department d JOIN FETCH d.employees")
	List<Department> findAll();
	
    @Query("select new com.employeeapp.dto.DeptEmpResponse(e.name, e.salary, d.dname) from Department d inner join d.employees e")
    List<DeptEmpResponse> deptEmployeeData();

//	List<DeptEmpResponse> deptEmpInformation();
}
