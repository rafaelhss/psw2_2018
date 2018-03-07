/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rafael.Soares
 */
public class Listar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            Session sessao = HibernateUtil
                        .getSessionFactory()
                        .openSession();

            //Livro l = (Livro) sessao.get(Livro.class, "Joao e o pe de feijao");
            Criteria criteria =sessao.createCriteria(Livro.class);
            
            
            if(request.getParameter("ano") != null && !request.getParameter("ano").equals("")){
                criteria.createAlias("edicoes","edicao");
                criteria.add(Restrictions.gt("edicao.ano", Integer.parseInt(request.getParameter("ano"))));    
            }
            
            /*
            criteria.add(Restrictions.like("autor", "%paulo%"));
            criteria.add(Restrictions.eq("editora", "abril"));
            criteria.add(Restrictions.le("ano", "2015"));
            criteria.add(Restrictions.gt("ano", "2005"));
            */
            
            List<Livro> livros = criteria.list(); 
            
            request.setAttribute("listalivro", livros);
            request.getRequestDispatcher("livros.jsp")
                    .forward(request, response);
                    
            
            
        }
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
