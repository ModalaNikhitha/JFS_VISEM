package com.skillnext1;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        int sem = Integer.parseInt(req.getParameter("sem"));
        String dept = req.getParameter("dept");

        Student s = new Student(name, sem, dept);
        StudentDAO.save(s);

        RequestDispatcher rd =
                req.getRequestDispatcher("studentSuccess.jsp");
        rd.forward(req, res);
    }
}
