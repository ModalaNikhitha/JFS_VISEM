package com.skillnext1;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    private Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/skillnext_db";
        String user = "root";
        String pass = "pranithasri";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // INSERT Student
    public void addStudent(Student s) throws Exception {
        Connection con = getConnection();
        String sql = "INSERT INTO student(name, sem, dept) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setInt(2, s.getSemester());
        ps.setString(3, s.getDepartment());
        ps.executeUpdate();
        con.close();
    }

    // UPDATE Student
    public void updateStudent(int id, String name, int sem, String dept) throws Exception {
        Connection con = getConnection();
        String sql = "UPDATE student SET name=?, sem=?, dept=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, sem);
        ps.setString(3, dept);
        ps.setInt(4, id);
        ps.executeUpdate();
        con.close();
    }

    // DELETE Student
    public void deleteStudent(int id) throws Exception {
        Connection con = getConnection();
        String sql = "DELETE FROM student WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }

    // GET ALL Students
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("sem"),
                    rs.getString("dept")

            ));
        }
        con.close();
        return list;
    }
}
