/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Cart;
import Bean.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author neera
 */
public class AddToCart extends HttpServlet {

    private List<Product> productList;
    private Set<Product> myProducts;

    public AddToCart() {
        // productList = CourseSearchServlet.getCoursesAvailable();
        //myCourses = new HashSet<Course>();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> listofProduct = new ArrayList<Product>();
        listofProduct = getProducts();
        Cart cart;
        HttpSession session = request.getSession();
        if (null != session.getAttribute("cart")) {
            cart = new Cart();
            cart = (Cart) session.getAttribute("cart");
        } else {
            cart = new Cart();
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        String[] bookvalues = request.getParameterValues("chkbook");
        String[] musicvalues = request.getParameterValues("chkmusic");
        String[] compvalues = request.getParameterValues("chkcomp");
        if (bookvalues != null) {

            for (Product p : listofProduct) {
                for (int i = 0; i < bookvalues.length; i++) {
                    if (p.getID().contains(bookvalues[i])) {
                        cart.addToCart(p);
                        session.setAttribute("cart", cart);
                        out.println("The Products added in Cart are " + bookvalues[i] + "<br/>");
                        //out.println("<input type='checkbox' name='courseId' value='" + cart.getCart().get(i).getName() + "'/>" + cart.getCart().get(i).getName() + cart.getCart().get(i).getPrice() + "<a href='addCourse.htm?name=" + cart.getCart().get(i).getName() + "&price=" + cart.getCart().get(i).getPrice() + "&action=single'> Add this course</a></h1>");
                    }
                }
            }
        }
        if (compvalues != null) {

            for (Product p : listofProduct) {
                for (int i = 0; i < compvalues.length; i++) {
                    if (p.getID().contains(compvalues[i])) {

                        cart.addToCart(p);
                        session.setAttribute("cart", cart);
                        out.println("The Products added in Cart are " + compvalues[i] + "<br/>");
                        //out.println("<input type='checkbox' name='courseId' value='" + cart.getCart().get(i).getName() + "'/>" + cart.getCart().get(i).getName() + cart.getCart().get(i).getPrice() + "<a href='addCourse.htm?name=" + cart.getCart().get(i).getName() + "&price=" + cart.getCart().get(i).getPrice() + "&action=single'> Add this course</a></h1>");
                    }
                }
            }
        }
        // out.println("<input type='hidden' name='action' value='multiple'/>");
        if (musicvalues != null) {
            for (Product p : listofProduct) {
                for (int i = 0; i < musicvalues.length; i++) {
                    if (p.getID().contains(musicvalues[i])) {
                        cart.addToCart(p);
                        session.setAttribute("cart", cart);
                        out.println("The Products in Cart are " + musicvalues[i] + "<br/>");
                    }
                }
            }
        }
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet AddToCart</title>");

        out.println("<br/><a href='/Assignment1Part7/ViewCart'>View Cart</a>");
        out.println("<br/><a href='/Assignment1Part7/Music.html'>Music</a>");
        out.println("<br/><a href='/Assignment1Part7/Computers.html'>Computer</a>");
        out.println("<br/><a href='/Assignment1Part7/Books.html'>Books</a>");
        out.println("</head>");
        out.println("<body>");
        out.println("");
        out.println("</body>");
        out.println("</html>");

    }

    public static List<Product> getProducts() {

        List<Product> productList = new ArrayList<Product>();
        Product pb1 = new Product();
        pb1.setID("B1");
        pb1.setName("B1");
        pb1.setPrice(100);

        Product pb2 = new Product();
        pb2.setID("B2");
        pb2.setName("B2");
        pb2.setPrice(200);

        Product pb3 = new Product();
        pb3.setID("B3");
        pb3.setName("B3");
        pb3.setPrice(300);

        Product pm1 = new Product();
        pm1.setID("M1");
        pm1.setName("M1");
        pm1.setPrice(100);

        Product pm2 = new Product();
        pm2.setID("M2");
        pm2.setName("M2");
        pm2.setPrice(200);

        Product pm3 = new Product();
        pm3.setID("M3");
        pm3.setName("M3");
        pm3.setPrice(300);

        Product pc1 = new Product();
        pc1.setID("C3");
        pc1.setName("C3");
        pc1.setPrice(500);

        Product pc2 = new Product();
        pc2.setID("C2");
        pc2.setName("C2");
        pc2.setPrice(400);

        Product pc3 = new Product();
        pc3.setID("C3");
        pc3.setName("C3");
        pc3.setPrice(300);

        productList.add(pb1);
        productList.add(pb2);
        productList.add(pb3);

        productList.add(pm1);
        productList.add(pm2);
        productList.add(pm3);

        productList.add(pc1);
        productList.add(pc2);
        productList.add(pc3);

        return productList;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
