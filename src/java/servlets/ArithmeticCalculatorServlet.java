package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("result", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String first_in = request.getParameter("first_in");
        String second_in = request.getParameter("second_in");
        
        request.setAttribute("firstIn", first_in);
        request.setAttribute("secondIn", second_in);
        
        String add = request.getParameter("plus");
        String subtract = request.getParameter("minus");
        String multiply = request.getParameter("times");
        
        if (first_in.equals("") || first_in == null || second_in.equals("") || second_in == null) {
            String result = "Invalid input.";
            request.setAttribute("result", result);
        } else {
            try {
                int first = Integer.parseInt(first_in);
                int second = Integer.parseInt(second_in);
                
                int total = 0;
                
                if (add != null) {
                    total = first + second; 
                } else if (subtract != null) {
                    total = first - second;
                } else if (multiply != null) {
                    total = first * second;
                } else {
                    total = first % second;
                }
                
                request.setAttribute("result", total);
            } catch (NumberFormatException e) {
                String result = "Invalid input.";
                request.setAttribute("result", result);
            }    
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
        return;
    }
}
