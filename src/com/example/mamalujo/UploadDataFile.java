package com.example.mamalujo;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UploadDataFile
 */
@WebServlet(name = "UploadDataFile", urlPatterns={"/UploadDataFile"})
public class UploadDataFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDataFile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //String action = request.getParameter("action");
        String texto = request.getParameter("fileid");
        
        System.out.println(texto);
        String teste = LoadInDataFile.lerArquivo(texto);
        /*
        if (action == null) {
            throw new ServletException("No action specified.");
        } else if (action.equals("selecionar_arquivo")) {
            //irParaIniciarCriarConta(request, response);
        	String teste = LoadInDataFile.lerArquivo("/home/andre/Documentos/cloud/teste/origem_csv");
        	
        	response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("Contato " + teste + 
                    " adicionado com sucesso");    
            out.println("</body>");
            out.println("</html>");
        }*/
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processarRequisicao(request, response);//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
