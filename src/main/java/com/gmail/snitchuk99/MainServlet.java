package com.gmail.snitchuk99;

import com.gmail.snitchuk99.dao.UserDaoImpl;
import com.gmail.snitchuk99.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class MainServlet extends HttpServlet {

    private static String index = "/WEB-INF/view/index.jsp";
    private UserDaoImpl userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserDaoImpl();
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
            try {
                List<User> userList = userDao.getAll();
                req.setAttribute("users", userList);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            req.getRequestDispatcher(index).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");

        userDao.add(new User(name, surname, Integer.parseInt(age)));

        doGet(req, resp);

    }

    @Override
    public void destroy() {
        userDao.closeConnection();
    }
}