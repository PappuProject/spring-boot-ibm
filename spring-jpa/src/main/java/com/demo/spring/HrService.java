package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
@Transactional
public class HrService {
	
	@Autowired
	EmpDao dao;

	public String registerEmp(int id, String name, String city, double salary) {
		String resp = dao.save(new Emp(id, name, city, salary));
		return resp;
	}

	public List<String> listAllEmps() {
		List<Emp> empList = dao.findAll();

		List<String> data = new ArrayList<>();
		for (Emp e : empList) {
			data.add(e.getEmpId() + " " + e.getName() + " " + e.getCity() + " " + e.getSalary());
		}
		return data;
	}
}
