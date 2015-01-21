package parts;

import java.sql.Connection;

public class MySQLConnect{

	public static void main(String[] args) {

		String userPass="";
		
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/lms?useUnicode=true&amp;characterEncoding=utf-8";
		//String url = "jdbc:oracle:thin:@scrny1qadb03.int.kaplan.com:1521:score";
		//tring url = "jdbc:mysql://scrny3qa3app01.int.kaplan.com:3306/lms_qa3";

		String driver = "com.mysql.jdbc.Driver";
		//String driver = "oracle.jdbc.driver.OracleDriver";

		//String userName = "lms";
		//String userName = "root";
		String userName = "score";

		//String password = "lms050508";
		String password = "score";
		//String password = "hercule";
		//String password = "12345";

		/*try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to the database");

			PreparedStatement stmt = conn.prepareStatement("Select encrypted_password from users where username=?");
			stmt.setString(1, args[0]);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				userPass = rs.getString(1);
			}
			System.out.println("User: "+args[0]);
			System.out.println("Encrypted Password = "+(userPass));
			System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("YLpyZdAW2kmUVjbk8vKvbn2m+6mL3AeL"));
			
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("YLpyZdAW2kmUVjbk8vKvbn2m+6mL3AeL"));
	}
}