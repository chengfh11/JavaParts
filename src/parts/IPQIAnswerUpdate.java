package parts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;

public class IPQIAnswerUpdate
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		int charactersToTrim = 107;
		String DATE_FORMAT = "yyyyMMddyyyymmhh";
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String timestamp = dateFormat.format(new Date());

		String path = "C:\\development\\";
		String output = timestamp + "AnswerUpdate.sql";

		long start = System.currentTimeMillis();

		try
		{
			// Get the object of DataInputStream
			List<String> images;

			FileWriter writer = new FileWriter(path + output);
			BufferedWriter out = new BufferedWriter(writer);

			out.write("-- $Id: $" + "\n\n");
			out.write("SET NAMES 'UTF8';" + "\n\n");
			out.write("SET SESSION SQL_MODE = 'ANSI';" + "\n\n");
			out.write("-- Begin" + "\n\n");

			ImageIcon image = null;
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/qbox_qa2?useUnicode=true&amp;characterEncoding=utf-8";
			String driver = "com.mysql.jdbc.Driver";
			String userName = "root";
			String password = "12345";

			try
			{
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println("Connected to the database");

				String answerQuery = "select id, substr(display_text,locate('\"',display_text, instr(display_text,'id='))+1, locate('\"',display_text,locate('\"',display_text, instr(display_text,'id='))+1)-locate('\"',display_text, instr(display_text,'id='))-1) as guid "
						+ "from answer where display_text like '<img%'and id not in (1,10295,10296, 11583, 11584, 11774, 11776);";

				PreparedStatement stmt = conn.prepareStatement(answerQuery);
				ResultSet rs = stmt.executeQuery();

				String answerUpdateQuery = "";
				while (rs.next())
				{
					answerUpdateQuery = "UPDATE \"answer\" SET \"display_text\" = NULL, \"image_id\" = (SELECT \"id\" FROM \"image\" WHERE \"guid\" = '" + rs.getString("guid") + "') WHERE id = "
							+ rs.getInt("id") + ";";
					out.write(answerUpdateQuery + "\n");
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}

			out.close();
			conn.close();
			System.out.println("Disconnected from database");
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + ((end - start) / 1000) + " seconds");

	}
}
