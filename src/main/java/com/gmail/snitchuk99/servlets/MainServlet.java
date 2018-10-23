package com.gmail.snitchuk99.servlets;

import com.gmail.snitchuk99.dao.UserProfileDaoImpl;
import com.gmail.snitchuk99.entity.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {

    private static String index = "/WEB-INF/view/index.jsp";
    private UserProfileDaoImpl userDao;


    @Override
    public void init() throws ServletException {
        userDao = new UserProfileDaoImpl();
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {
        List<UserProfile> userList = userDao.getAll();
            req.setAttribute("users", userList);
        req.getRequestDispatcher(index).forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.sendRedirect("/add_user");
    }

    @Override
    public void destroy() {
        userDao.closeConnection();
    }
}