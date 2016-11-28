package com.yubarj.controller;

import com.yubarj.services.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by yubraj on 11/27/16.
 */
@WebServlet(name = "RemovePersonController", urlPatterns = {"/removenameservlet"})
public class RemovePersonController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        PersonService service = (PersonService) servletContext.getAttribute("personService");
        HashMap<String, String> message = new HashMap<>();


        if(request.getParameter("personkey") != "") {
            int id = Integer.parseInt(request.getParameter("personkey"));
            if(service.checkUserExists(id)){
                service.delete(id);
                message.clear();
                message.put("success", "Person with id : "+id+" Deleted Successfully");
            }else {
                message.clear();
                message.put("error", "Person with id :" + id +" doesnot exists.");
            }
        } else {
            message.clear();
            message.put("error", "Please provide personID to delete");
        }

        request.setAttribute("delMsg", message);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/addPerson.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
