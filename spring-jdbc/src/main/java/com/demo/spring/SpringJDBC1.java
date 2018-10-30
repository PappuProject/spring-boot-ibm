package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class SpringJDBC1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
		// JdbcTemplate jt=(JdbcTemplate)ctx.getBean("jt");
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		String INSERT_STMT = "insert into emp(empno,name,address,salary) values(?,?,?,?)";

		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(INSERT_STMT);
				pst.setInt(1, 200);
				pst.setString(2, "John");
				pst.setString(3, "Bangalore");
				pst.setDouble(4, 67000);
				return pst;
			}
		});
		System.out.println("Rows inserted : " + count);
	}

}
