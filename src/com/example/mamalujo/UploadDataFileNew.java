package com.example.mamalujo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mamalujo.ImportDadosExterno;

/**
 * Servlet implementation class UploadDataFileNew
 */
//@WebServlet("/UploadDataFileNew")
@WebServlet(name = "UploadDataFileNew", urlPatterns={"/"})
public class UploadDataFileNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "data";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDataFileNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    System.out.println(filePath);
                    
                    // saves the file to upload directory
                    item.write(uploadedFile);
                    ImportDadosExterno read = new ImportDadosExterno();
                    read.lerArquivoUpload(filePath);
                }
            }

            // displays done.jsp page after upload finished
            response.setContentType("text/html");
            //PrintWriter out = response.getWriter();
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("sucess.jsp");
            rd.include(request, response);
            //getServletContext().getRequestDispatcher("/sucess.html").forward( request, response);
        	/*
            response.setContentType("text/html");
        	PrintWriter out = response.getWriter();
        	
            out.println("<html>");
            out.println("<body>");
            out.println("<div style=\"background:#E6E6FA; color:#4682B4; text-shadow: 1px 1px 0px #000;\">Error ao Exportar Arquivo</div>");    
            out.println("</body>");
            out.println("</html>");
            */
			
        } catch (FileUploadException ex) {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("error.jsp");
            rd.include(request, response);
            throw new ServletException(ex);
        } catch (Exception ex) {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("error.jsp");
            rd.include(request, response);
            throw new ServletException(ex);
        }

    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
