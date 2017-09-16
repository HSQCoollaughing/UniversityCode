<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form method="get" action="NewsServlet" >  
        <input type="hidden"  name="method"   value="findNews" ></input>
            <input value="1"   type="text"   name="id"></input>  
           

            <button class="but" type="submit">查找</button>  
        </form>  
</body>
</html>