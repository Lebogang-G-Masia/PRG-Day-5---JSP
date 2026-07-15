/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Student;
import dao.StudentDAO;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.util.List;

/**
 *
 * @author BC-STUDENT
 */
 @WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String course = request.getParameter("course");

                Student student = new Student(firstName, lastName, email, phone, course);
                StudentDAO dao = new StudentDAO();
                boolean result = dao.saveStudent(student);

                if (result) {
                    response.sendRedirect("success.jsp");
                } else {
                    response.sendRedirect("error.jsp");
                }
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            StudentDAO dao = new StudentDAO();
            List<Student> students = dao.getAllStudents();
            request.setAttribute("students", students);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
    }

  