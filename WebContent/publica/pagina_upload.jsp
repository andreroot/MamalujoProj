<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css"  href="../resources/bootstrap/css/estilo.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Fast Data Service</title>
</head>
<body>

<script type="text/javascript">
function OnSubmitForm(){  
		document.form.file1.onsubmit;   
}
</script> 
<div style="background:#E6E6FA; color:#4682B4; text-shadow: 1px 1px 0px #000;">Exportacao de arquivos para MongoDB</div>
		 <nav>
		 	<ul class="menu">		 	
		 		
		 		<li>Escolher arquivo Excel(xls):</li>
		 	</ul>
		 </nav>

<center>
<form method="post" action="UploadDataFileNew" enctype="multipart/form-data">
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
<input type="submit" value="Upload" />
</center>	
</body>
</html>
