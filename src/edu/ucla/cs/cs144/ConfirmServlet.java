package edu.ucla.cs.cs144;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConfirmServlet extends HttpServlet implements Servlet {       
    public ConfirmServlet() {}

     public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(true);

    if (!session.isNew() && request.isSecure()) {
        Item item = (Item)session.getAttribute("item");
        request.setAttribute("id", item.getId());   
        request.setAttribute("name", item.getName());   
        request.setAttribute("price", item.getBuy_price());
        request.setAttribute("card",request.getParameter("cardinfo"));
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        request.setAttribute("time",timeStamp);
        request.getRequestDispatcher("/confirm.jsp").forward(request, response);

    }
}
  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
}
}
