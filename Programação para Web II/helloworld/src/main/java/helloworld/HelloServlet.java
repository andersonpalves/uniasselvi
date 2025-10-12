package helloworld;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        request.setAttribute("mensagem", "Olá, " + nome + "! Bem-vindo ao Hello World.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/hello.jsp");
        dispatcher.forward(request, response);
    }
}