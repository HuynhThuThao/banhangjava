package Servlet;

import Model.product;
import Model.producttype;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Thực hiện kết nối và lấy danh sách sản phẩm
        productlistServlet servlet = new productlistServlet();
        List<product> list = servlet.getAllProduct();
        List<producttype> listC = servlet.getAllProducttype();
        product last = servlet.getLast();

        // Đặt danh sách sản phẩm vào request để chuyển đến JSP
        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);

        // Forward request và response tới JSP
        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
}
