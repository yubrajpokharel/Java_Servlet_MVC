package com.yubarj.controller;

import com.yubarj.model.Person;
import com.yubarj.services.PersonService;
import com.yubarj.services.PersonServiceImpl;

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
@WebServlet(name = "PersonController", urlPatterns = {"/", "/person"})
public class PersonController extends HttpServlet {

    private PersonService service = new PersonServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                            throws ServletException, IOException {

        Person person =  new Person();
        HashMap<String, String> message = new HashMap<>();
        if(request.getParameter("key") != ""
                && request.getParameter("fname") != ""
                && request.getParameter("lname") != ""){

            person.setId(Integer.parseInt(request.getParameter("key")));
            person.setFirst_name(request.getParameter("fname"));
            person.setLast_name(request.getParameter("lname"));
            service.save(person);
            System.out.println("Person : "+person.toString()+ " Added successfully");
            message.clear();
            message.put("success", "Person added Successfully.");

            // Updateing the person services
            ServletContext sc = getServletContext();
            sc.setAttribute("personService", service);


        }else{
            message.clear();
            message.put("error", "Please provide all the details");
        }

        request.setAttribute("message", message);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/addPerson.jsp");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                             throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.setAttribute("personService", service);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/addPerson.jsp");
        requestDispatcher.forward(request, response);

    }
}
