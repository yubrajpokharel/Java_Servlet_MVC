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

/**
 * Created by yubraj on 11/27/16.
 */
@WebServlet(name = "ShowAllPersonController", urlPatterns = {"/showAll"})
public class ShowAllPersonController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = getServletContext();
        if(sc.getAttribute("personService") != null) {
            PersonService service = (PersonService) sc.getAttribute("personService");
            request.setAttribute("persons", service.showAll());
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/allPerson.jsp");
        dispatcher.forward(request, response);

    }
}
