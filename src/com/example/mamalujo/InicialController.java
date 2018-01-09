package com.example.mamalujo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InicialController
 */
@WebServlet("/InicialController")
public class InicialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicialController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        
        String action = request.getParameter("action");
 
        if (action == null) {
            throw new ServletException("No action specified.");
        } else if (action.equals("iniciar_criar_conta")) {
            irParaIniciarCriarConta(request, response);
        }
    }
 
    private void irParaIniciarCriarConta(HttpServletRequest request, HttpServletResponse response){
         
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("publica/criar_conta.jsp");
         
        try {
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processarRequisicao(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processarRequisicao(request, response);
	}

}
