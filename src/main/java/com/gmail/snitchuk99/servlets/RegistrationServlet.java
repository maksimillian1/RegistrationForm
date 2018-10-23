package com.gmail.snitchuk99.servlets;

import com.gmail.snitchuk99.dao.IGenericUserDao;
import com.gmail.snitchuk99.dao.UserProfileDaoImpl;
import com.gmail.snitchuk99.entity.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    private static String index = "/WEB-INF/view/registration.jsp";
    private IGenericUserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = new UserProfileDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String dateOfBirth = req.getParameter("dateOfBirth");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        userDao.add(new UserProfile(firstName, lastName, dateOfBirth, login, password));
        resp.sendRedirect("/");
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.getRequestDispatcher(index).forward(req, res);
    }


    /*
    Rexeg for only alphabetical chars - "/^[A-Z]+$/i"
    Rexeg for valid age format - "^[0-9]*$"
     */
//    private boolean isValidDataInFields(String nameNSurname, int age){
//        if(nameNSurname.matches("\\b[^\\d\\W]+\\b")
//                &&String.valueOf(age).matches("(^[0][1-9]+)|([1-9]\\d*)")
//                &&!nameNSurname.equals("")){
//            return true;
//        }
//        return false;
//    }
}
//&& String.valueOf(age).matches("[1-9]\\d*|0\\d+")