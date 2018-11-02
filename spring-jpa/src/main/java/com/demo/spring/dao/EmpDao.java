package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public String save(Emp e);
	public Emp findByid(int id);
	public List<Emp> findAll();
}
