package edu.ucla.cs.cs144;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PaymentServlet extends HttpServlet implements Servlet {       
    public PaymentServlet() {}

     public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(true);

    if (!session.isNew()) {
        Item item = (Item)session.getAttribute("item");
        request.setAttribute("id", item.getId());   
        request.setAttribute("name", item.getName());   
        request.setAttribute("price", item.getBuy_price());
        String secureurl = "https://" + session.getAttribute("host") + ":"+session.getAttribute("port")+session.getAttribute("context")+"/confirm";
        request.setAttribute("url",secureurl);
        request.getRequestDispatcher("/payment.jsp").forward(request, response);

    }
}
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
}
}
