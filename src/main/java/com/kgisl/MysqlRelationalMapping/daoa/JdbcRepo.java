package com.kgisl.MysqlRelationalMapping.daoa;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.kgisl.MysqlRelationalMapping.entity.Laptop;
import com.kgisl.MysqlRelationalMapping.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JdbcRepo {
	private final JdbcTemplate jdbcTemplate;

    public JdbcRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Student> getAllStudentsWithLaptops() {
        String sql = "SELECT s.id, s.rollnumber, s.mark, s.name, s.age, s.gender, " +
                     "l.lno, l.lname, l.serialno " +
                     "FROM student s " +
                     "LEFT JOIN laptop l ON s.rollnumber = l.rollnumber"; // Adjust based on your database schema

        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                // Create Student object
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setRollno(rs.getString("rollnumber"));
                student.setMark(rs.getInt("mark"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));

                // Initialize laptop list if needed
                List<Laptop> laptops = new ArrayList<>();

                // Fetch laptop details
                do {
                    int lno = rs.getInt("lno");
                    if (lno > 0) { // Check if there's a laptop
                        Laptop laptop = new Laptop();
                        laptop.setLno(lno);
                        laptop.setLname(rs.getString("lname"));
                        laptop.setSerialno(rs.getString("serialno"));
                        laptops.add(laptop);
                    }
                } while (rs.next() && rs.getInt("id") == student.getId()); // Loop until we reach the next student

                student.setLaptops(laptops);
                return student;
            }
        });
    }
}
