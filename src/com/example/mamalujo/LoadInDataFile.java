package com.example.mamalujo;


import java.io.File;

import java.util.Scanner;
/**
* Importacao de dados de origem externa
*
*/

public class LoadInDataFile{
	
	private Scanner scanner;
	static String sfileinfo;
	
	public static String lerArquivo(String caminho) {
		
		try
			{	
				//caminho = "/home/andre/Documentos/cloud/teste/origem_csv";
				File dir = new File(caminho);
				File arquivos[];
				arquivos = dir.listFiles();	
								
				for(int i = 0; i < arquivos.length; i++){
				    sfileinfo = arquivos[i].toString();
                    System.out.println(sfileinfo);

				    
				}
			}
		
			
	    	catch (Exception e) {
	    			e.printStackTrace();
	    			System.out.println(e);
	    		
	    	}
		return sfileinfo;

		}

	public void pegarArquivo(){
		
		String diretorio = System.getProperty("user.dir");
		String so = System.getProperty("os.name");
		if(so.contains("Linux")==false){
			System.out.println(diretorio);
			System.out.println(so);		
			
		}else{
			System.out.println(diretorio);
			System.out.println(so);		
			
		}
			

	}
	
	//public static void main(String[] args) {
		//LoadInDataFile exe = new LoadInDataFile();
		//exe.lerArquivo("/usr/local/apache-tomcat-7.0.82/wtpwebapps/MamalujoProj/data/teste.txt");
	//}
	
}
