package database;


import java.sql.*;

public class DataBase {

	
	
/*    String url = "jdbc:mysql://localhost/jewoo419";
    String id = "jewoo419";
    String pwd ="bogo2016!@";  */ 
	
	
	String driverName;
    String url ;
    String id ;
    String pwd ; 
    Connection conn;   
    Statement stmt;

    
    String query;
    ResultSet rs;
    
    public DataBase (String url,String id,String pwd)
    {
    	
        this.url = url;
        this.id = id;
        this.pwd =pwd;        
    	driverName="com.mysql.jdbc.Driver";
    	try{
	        Class.forName(driverName);     
	    }catch(ClassNotFoundException e){
	    }
    	
    }
    //select
    public Connection ExcuteSQL(String query) throws SQLException{
	    
    	rs=null;
    	conn= DriverManager.getConnection(url,id,pwd);
	    stmt = conn.createStatement();	    
	    this.query= query;
	    rs=  stmt.executeQuery(query);	
	    resultprint();
        stmt.close();
        
        
	    conn.close();
	    
	    return conn;
    }
    
    //insert 
    public Connection  UpdateSQL(String query) throws SQLException{
	    
    	rs=null;
    	conn= DriverManager.getConnection(url,id,pwd);
	    stmt = conn.createStatement();	    
	    this.query= query;
	    stmt.executeUpdate(query);	
        stmt.close();
	    conn.close();
	    
	    return conn;
    }
    public void resultprint() throws SQLException
    {
    	
        	while(rs.next()) {
    		
    		String str = rs.getNString(1);
			System.out.println(str);
          }
    }
	
}
