package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SavingAccount {
	
	
	public void createAC(String firstname, String lastname, double initialBalance , double balance,int accountNumber) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost/bank";
			String user  ="root";
			String pass = "BOOMboom@1234";
			
			
				Connection conn = DriverManager.getConnection(url, user, pass);
//				Statement st = conn.createStatement();
//				String savingAC ="create table SAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(savingAC);
//				String currentAC ="create table CAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(currentAC);
				String insert="INSERT into SAc (ACno,fname,lname,initail,Tbal) VALUES (?,?,?,?,?)";
//				st.executeUpdate(insert);
				PreparedStatement pstm = conn.prepareStatement(insert);
				pstm.setInt(1, accountNumber);
				pstm.setString(2,firstname);
				pstm.setString(3, lastname);
				pstm.setDouble(4, initialBalance);
				pstm.setDouble(5, balance);
				pstm.execute();
			
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void updatebalance(int accountNumber, double balance) {
		// TODO Auto-generated method stub
		try {
			String url = "jdbc:mysql://localhost/bank";
			String user  ="root";
			String pass = "BOOMboom@1234";
			
			
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement st = conn.createStatement();
//				String savingAC ="create table SAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(savingAC);
//				String currentAC ="create table CAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(currentAC);
				
				
				String update ="UPDATE SAc SET Tbal=? WHERE ACno = ? ";
//				st.executeUpdate(update);
				PreparedStatement pstm = conn.prepareStatement(update);
//				
				pstm.setDouble(1, balance);
				pstm.setInt(2, accountNumber);
				pstm.execute();
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

                 //delete data
	  public void deletedata(int accountNumber) {
		  
		  
	      
		   
		   try {
				String url = "jdbc:mysql://localhost/bank";
				String user  ="root";
				String pass = "BOOMboom@1234";
				
				
					Connection conn = DriverManager.getConnection(url, user, pass);
                   
						 String delete = "DELETE FROM SAc WHERE ACno=?";
						 PreparedStatement pstm = conn.prepareStatement(delete);
						 pstm.setInt(1, accountNumber);
						 pstm.execute();
						conn.close();
						
					
					 
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
	   }
  

                       //access data
   public double accesAC(int accountNumber) {
	      
	   double bal=0;
	   try {
			String url = "jdbc:mysql://localhost/bank";
			String user  ="root";
			String pass = "BOOMboom@1234";
			
			
				Connection conn = DriverManager.getConnection(url, user, pass);
				Statement st = conn.createStatement();
//				String savingAC ="create table SAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(savingAC);
//				String currentAC ="create table CAc (ACno int (255),fname varchar(200),lname varchar(200),initail int(255),Tbal int(255))";
//				st.executeUpdate(currentAC);
				
				
				String acess ="select * from SAc where ACno= '"+accountNumber+"' ";
				
				PreparedStatement pstm = conn.prepareStatement(acess);
				
				pstm.execute();
				
				 ResultSet rs =  st.executeQuery(acess);
				 
					 
					// Fetch each row from the result set
					        while (rs.next()) {
					            // Get the data from the row using the column index
					            bal = rs.getInt(5);
					        }
					            
					        
				 
				
				 
				
				 
				 

				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   return bal;
	   
   }
   
   
   
   
   
}
                          //extra info
//Connection conn = DriverManager.getConnection(url,username,password);
//String query = "INSERT into student (sid,sname,scourse) VALUES (?,?,?) ";
//PreparedStatement pstm = conn.prepareStatement(query);
//
//	   
//
//pstm.setInt(1, id);
//pstm.setString(2,name);
//pstm.setString(3, course);
//pstm.execute();
// 

//when I use this instead I am able to insert data except for the picture:
//	try{ String addrecords="insert into brothers(FirstName, MiddleName, LastName, BirthDate, BirthPlace, Nationality, "
//			+ "InstituteNumber, Status, Picture) values"
//			+ "('"+ fname +"', '" + mname +"', '" + lname +"', '" + dave +"', '" + place +"', '" +
//			isa +"', '" + InstNo +"', '" + statusq +"', '" + photo +"')"; 
	//wrapField(); st.executeUpdate(addrecords); }

//   public void accesAC(int accountNumber) {
//	      
//	   
//	   try {
//			String url = "jdbc:mysql://localhost/bank";
//			String user  ="root";
//			String pass = "BOOMboom@1234";
//			
//			
//				Connection conn = DriverManager.getConnection(url, user, pass);
//				Statement st = conn.createStatement();
//
//				
//				
//				String acess ="SELECT  ACno , fname,lname, initail,Tbal from SAc where ACno= '"+accountNumber+"' ";
////				st.execute(acess);
//				
//				PreparedStatement pstm = conn.prepareStatement(acess);
//				pstm.executeQuery();
//				
//				 ResultSet rs =  st.executeQuery(acess);
//				 
//				 
//				// Fetch each row from the result set
//				 int acno1=0;
//				 String fname="";
//				 String lname="";
//				 double init=0;
//				 double bal=0;
//				        while (rs.next()) {
//				            // Get the data from the row using the column index
//				           acno1 = rs.getInt(1);
//				          fname = rs.getString(2);
//				          lname = rs.getString(3);
//				          init = rs.getInt(4);
//				          bal = rs.getInt(5);  
//				        }
//				        Bank bank  = new  Bank();
//				        BankAccount newAccount = bank.createAccount(acno1,fname,lname, bal);
//				        newAccount.getAccountNumber();
//				conn.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	   
//   }
   
   
   
   
   
//}

//Connection conn = DriverManager.getConnection(url,username,password);
//String query = "INSERT into student (sid,sname,scourse) VALUES (?,?,?) ";
//PreparedStatement pstm = conn.prepareStatement(query);
//
//	   
//
//pstm.setInt(1, id);
//pstm.setString(2,name);
//pstm.setString(3, course);
//pstm.execute();
// 

//when I use this instead I am able to insert data except for the picture:
//	try{ String addrecords="insert into brothers(FirstName, MiddleName, LastName, BirthDate, BirthPlace, Nationality, "
//			+ "InstituteNumber, Status, Picture) values"
//			+ "('"+ fname +"', '" + mname +"', '" + lname +"', '" + dave +"', '" + place +"', '" +
//			isa +"', '" + InstNo +"', '" + statusq +"', '" + photo +"')"; 
	//wrapField(); st.executeUpdate(addrecords); }
