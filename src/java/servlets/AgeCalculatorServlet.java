package servlets;

import com.sun.org.apache.xerces.internal.impl.dv.InvalidDatatypeValueException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String input = request.getParameter("age_in");
        
        if (input.equals("") || input == null) {
            String message = "You must give your current age.";
            request.setAttribute("message", message);
        } else {
            try {
                Integer.parseInt(input);
                request.setAttribute("age", input);
                int age = Integer.parseInt(input);
                age++;
                String message = String.format("Your age next birthday will be %d.", age);
                request.setAttribute("message", message);
            } catch (NumberFormatException e) {
                String message = "You must enter a number.";
                request.setAttribute("message", message);
            }    
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
        return;
    }
}
