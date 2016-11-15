
<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html >
<html>
<head>
<title> request process</title >
</head>
<body>
                 <% 
                
                 request.setCharacterEncoding("UTF-8" ); 
                

                 
                    request.getParameter("ip" ) ;
                    request.getParameter("ip" ) ;
                    request.getParameter("ip" ) ;
                    request.getParameter("ip" ) ;
                    request.getParameter("ip" ) ;
                    request.getParameter("ip" ) ;

                
                    Connection con = null;

        			con = DriverManager.getConnection("jdbc:mysql://localhost/jewoo419","jewoo419", "bogo2016!@");

        			java.sql.Statement st = null;
        			ResultSet rs = null;
        			st = con.createStatement();
        			rs = st.executeQuery("insert into log valuses('2','a','a','a','a,'a',1)");

        			if (st.execute("insert into log valuses('2','a','a','a','a,'a','FAILED')")) {
        				rs = st.getResultSet();
        			}

                    
                    %>
 
</body>
</html>