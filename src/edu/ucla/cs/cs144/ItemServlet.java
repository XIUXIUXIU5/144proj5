package edu.ucla.cs.cs144;

import java.io.IOException;
import java.io.StringWriter;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ItemServlet extends HttpServlet implements Servlet {       
    public ItemServlet() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String id = request.getParameter("id");
        try {
            String result = AuctionSearchClient.getXMLDataForItemId(id);
             if (result != null) {
                xmlParser parser = new xmlParser();
                Item item = parser.parseXML(result);
                 request.setAttribute("result", item);   
                 if (item != null && item.getBuy_price() != null) {
                    request.setAttribute("pay", "Pay Now");
                    session.setAttribute("item",item);   
                    session.setAttribute("host",request.getServerName());
                    session.setAttribute("port","8443");
                    session.setAttribute("context",request.getContextPath());  
                }             
             }
             else{
                request.setAttribute("result", null);   
             }
        } catch(Exception e){
            request.setAttribute("result", null);   
            request.setAttribute("returned", "error");                
             
        	System.out.println(e);
        }

        request.getRequestDispatcher("/getItemResult.jsp").forward(request, response);
    }
}
