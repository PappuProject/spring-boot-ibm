package com.demo.spring.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

import io.swagger.annotations.Api;

@RestController
@Api
public class EmpRestController {

	@Autowired
	private EmpRepository repo;

	@GetMapping(path = "/emp/{id}", produces = "application/json")
	public Emp getEmp(@PathVariable("id") int id) {
		Optional<Emp> o = repo.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			throw new RuntimeException("No Emp Found..");
		}

	}

	@PostMapping(path = "/emp/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity createEmp(@RequestBody Emp e) {

		if (repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee Already exists");
		} else {
			repo.save(e);
			return ResponseEntity.ok("Employee Saved Successfully..");
		}
	}

	@DeleteMapping(path = "/emp/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteEmp(@PathVariable("id") int id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok("Employee Deleted");
		} else {
			return ResponseEntity.ok("Employee Not Found..");
		}
	}

	@PutMapping(path = "/emp/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateEmp(@RequestBody Emp e) {

		repo.save(e);
		return ResponseEntity.ok("Employee Updated..");
	}

	@GetMapping(path = "/emp/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emp>> getEmpList() {
		
		return ResponseEntity.ok(repo.findAll());
	}
}
