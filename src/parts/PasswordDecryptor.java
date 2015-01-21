package parts;
import java.sql.Connection;

public class PasswordDecryptor{

	public static void main(String[] args) {

		String userPass="";
		
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		//String url = "jdbc:mysql://localhost:3306/lms?useUnicode=true&amp;characterEncoding=utf-8";
		//String url = "jdbc:oracle:thin:@scrny1qadb03.int.kaplan.com:1521:score";
		//String url = "jdbc:mysql://scrny3qa3app01.int.kaplan.com:3306/lms_qa3";
		String url = "jdbc:mysql://scrch1prddb01.int.kaplan.com:3306/lms2";
		
		//boolean promoCodeAccepted = (Boolean) null;
		String driver = "com.mysql.jdbc.Driver";
		//String driver = "oracle.jdbc.driver.OracleDriver";

		//String userName = "lms";
		String userName = "lms-ro";
		//String userName = "root";
		//String userName = "score";

		//String password = "lms050508";
		//String password = "score";
		//String password = "hercule";
		String password = "chandler";
		//String password = "12345";

		/*try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to the database");
			
			String query = "SELECT distinct cm.email_address, u.encrypted_password, u.id, ssp.enrollment_id, u.enterprise_id, u.first_name, u.last_name, ssp.product_id " +
					"FROM users u, student_service_profile ssp, users_contact_method ucm, contact_method cm, user_institutions ui LEFT JOIN user_sessions us " +
					"ON us.user_id = ui.user_id " +
					"WHERE us.id IS NULL " +
					"AND u.id = ui.user_id " +
					"AND ssp.student_id = u.id " +
					"AND ucm.user_id = u.id " +
					"AND ucm.contact_method_id = cm.id " +
					"AND cm.method_type = 'EMAIL' " +
					"AND u.user_type = 'STUDENT' " +
					"AND ui.institution_id = 585 ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String email = rs.getString(1);
				String encryptedPassword = rs.getString(2);
				String decryptedPassword = PasswordDecrypter.decryptPassword(encryptedPassword);
				System.out.println(email+","+decryptedPassword);
				
			}
			//System.out.println("User: "+args[0]);
			//System.out.println("Encrypted Password = "+(userPass));
			//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("YLpyZdAW2kmUVjbk8vKvbn2m+6mL3AeL"));			
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
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("'6HPAuwKVN+8x2LiECaBQYtH5/36HVDV0'"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("'6ti8gujZwYEuCcGe/sXFVA=='"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("'nqYBH+yiTzKWt8n6oSv49PY9OWnUDOIR'"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("'rV5e8jBa70pHsoGStN7UfwiaXkzzNLDF'"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("'b1nSYV8tZCRXuqQXrvst+ze4TKxG03u5'"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("''YLpyZdAW2kmUVjbk8vKvbn2m+6mL3AeL'"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("V1KztYaEMbZgj6iQtjipF6qowl1UOdqc"));
		//System.out.println("Student1: "+PasswordDecrypter.encryptPassword("Student1"));
		//System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("XdmwXCIC0oXd2qG6g8PypQ=="));
		System.out.println("Decrypted Password = "+PasswordDecrypter.decryptPassword("YLpyZdAW2kmUVjbk8vKvbn2m+6mL3AeL"));
		
	}
}