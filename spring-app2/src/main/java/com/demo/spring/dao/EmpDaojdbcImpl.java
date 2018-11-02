package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class EmpDaojdbcImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		System.out.println("JDBC: Data Saved with id " + e.getEmpId());
		return "saved";
	}

}
