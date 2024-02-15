package com.example.td2_jee;

import com.example.td2_jee.DBConfig.DBConnector;
import com.example.td2_jee.Models.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Traitement", value = "/traitement")
public class Traitement extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Connection connection;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            ServletContext context = getServletContext();
            connection = DBConnector.getConnection(context);
            System.out.println("Database connected from db connector using config......");
        } catch (SQLException e) {
            throw new ServletException("Échec de la connexion à la base de données", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idProduit = Integer.parseInt(request.getParameter("id"));
        int qteProduit = Integer.parseInt(request.getParameter("qte"));
        String query = "UPDATE produits SET qte = ? WHERE id = ?";
//        HttpSession session = request.getSession();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1,qteProduit);
            statement.setInt(2,idProduit);
            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Produit maj avec succès! ....");
                request.setAttribute("msg" , "Produit maj");
                request.getRequestDispatcher("menu.jsp").forward(request,response);

            }else{
                System.out.println("Produit n'est pas maj! ....");
                request.setAttribute("msg" , "Produit pas maj");
                request.getRequestDispatcher("menu.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomProduit = request.getParameter("nom");
        int qteProduit = Integer.parseInt(request.getParameter("qte"));
        Produit prod = new Produit(nomProduit , qteProduit);
        String query = "INSERT INTO produits (nom, qte) VALUES (?, ?)";
//        HttpSession session = request.getSession();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,prod.getNom());
            statement.setInt(2,prod.getQte());
            int insert = statement.executeUpdate();
            if (insert > 0) {
                System.out.println("Produit ajouté avec succès! ....");
                request.setAttribute("msg" , "Produit ajouter");
                request.getRequestDispatcher("menu.jsp").forward(request,response);

            }else{
                System.out.println("Produit n'est pas ajouté! ....");
                request.setAttribute("msg" , "Produit pas ajouter");
                request.getRequestDispatcher("menu.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
