package dev.bobscott.simpleservlet;

import com.mysql.cj.x.protobuf.Mysqlx;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@javax.servlet.annotation.WebServlet(value = "/dbtest")
public class Servlet extends javax.servlet.http.HttpServlet {


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       Connection connection = null;
        PrintWriter writer = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            writer.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hb_demo?user=root&password=password_here");
            writer.println(connection.getCatalog());
            connection.close();
       } catch (Exception e) {
            writer.println("Connection error:" + e.getMessage());
        }

    }
}
