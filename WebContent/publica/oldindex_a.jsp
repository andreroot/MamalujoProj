<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Fast Data Service</title>
</head>
<body>

<script type="text/javascript">
function OnSubmitForm(){  
		document.form.file1.onsubmit;   
}
</script> 
<body> 
<center>
<form method="post" action="../UploadDataFileNew" enctype="multipart/form-data">
Seelecione arquivo:
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
<input type="submit" value="Upload" />
<br>
</center>	
</body>
</html>
