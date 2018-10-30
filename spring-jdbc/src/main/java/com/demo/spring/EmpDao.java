package com.demo.spring;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public String save(Emp e);
	public String update(Emp e);
	public String delete(int id);
	public Emp findById(int id);
	public List<Emp> findAll();
}
