package com.example.td2_jee;


import com.example.td2_jee.DBConfig.DBConnector;
import com.example.td2_jee.Models.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "connexion", value = "/connexion-auth")
public class Connexion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  Connection connection;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String motDePasse = request.getParameter("mdp");

        User utilisateur = null;
        try {
            utilisateur = authentifier(login, motDePasse);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("erreur", "Échec de la connexion à la base de données");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        if (utilisateur != null) {
            // Rediriger vers la page d'accueil
            request.getSession().setAttribute("nom", utilisateur.getLogin());
            response.sendRedirect("/menu.jsp");
        } else {
            // Afficher un message d'erreur
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<p>Erreur d'authentification !</p>");
            out.println("<a href=\"index.jsp\">Retour à la page d'accueil</a>");
            out.println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }


    public User authentifier(String login, String motDePasse) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM users WHERE login = '" + login + "' AND mdp = '" + motDePasse + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                DBConnector.closeConnection();
                return new User(
                        resultSet.getString("login"),
                        resultSet.getString("mdp") // Consider not storing plain text passwords
                );
            } else {
                DBConnector.closeConnection();
                return null;
            }
        }
    }

}
