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

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String TypeID = request.getParameter("TypeID"); // Đặt tên biến theo quy tắc CamelCase

        // Tạo instance của productlistServlet để sử dụng các phương thức
        productlistServlet servlet = new productlistServlet();

        // Lấy danh sách sản phẩm theo TypeID
        List<product> list = servlet.getProductBycID(TypeID);
        List<producttype> listC = servlet.getAllProducttype();
        product last = servlet.getLast();

        // Đặt các danh sách và thông tin sản phẩm vào request để chuyển đến trang JSP
        request.setAttribute("listP", list);
        request.setAttribute("listCC", listC);
        request.setAttribute("p", last);

        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
