package parts;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class MysqlToXls
{

	private Connection connection = null;

	public MysqlToXls(String database, String user, String password) throws ClassNotFoundException, SQLException
	{

		// Create MySQL database connection
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/" + database;
		connection = DriverManager.getConnection(url, user, password);
	}

	public void generateXls(String tablename, String filename) throws SQLException, FileNotFoundException, IOException
	{

		// Create new Excel workbook and sheet
		HSSFWorkbook xlsWorkbook = new HSSFWorkbook();
		HSSFSheet xlsSheet = xlsWorkbook.createSheet();
		short rowIndex = 0;

		// Execute SQL query
		PreparedStatement stmt = connection.prepareStatement("select * from " + tablename);
		ResultSet rs = stmt.executeQuery();

		// Get the list of column names and store them as the first
		// row of the spreadsheet.
		ResultSetMetaData colInfo = rs.getMetaData();
		List<String> colNames = new ArrayList<String>();
		HSSFRow titleRow = xlsSheet.createRow(rowIndex++);

		for (int i = 1; i <= colInfo.getColumnCount(); i++)
		{
			colNames.add(colInfo.getColumnName(i));
			titleRow.createCell((short) (i - 1)).setCellValue(new HSSFRichTextString(colInfo.getColumnName(i)));
			xlsSheet.setColumnWidth((short) (i - 1), (short) 4000);
		}

		// Save all the data from the database table rows
		while (rs.next())
		{
			HSSFRow dataRow = xlsSheet.createRow(rowIndex++);
			short colIndex = 0;
			for (String colName : colNames)
			{
				dataRow.createCell(colIndex++).setCellValue(new HSSFRichTextString(rs.getString(colName)));
			}
		}

		// Write to disk
		xlsWorkbook.write(new FileOutputStream(filename));
	}

	// Close database connection
	public void close() throws SQLException
	{
		connection.close();
	}

	public static void main(String[] args)
	{
		try
		{
			MysqlToXls mysqlToXls = new MysqlToXls("test", "root", "123456");
			mysqlToXls.generateXls("person", "person.xls");
			mysqlToXls.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
//    /**
//     * This method is use for the export all the student record to excel using apache poi
//     * @param dealId
//     * @throws IOException
//     */
//    public void exportStudentList(Long dealId) throws IOException
//	{
//    	//Service call to return all the student for the institution
//		List<DealInstitutionUser> user = dealInstitutionUserService.findAllDealInstitutionUserByUserType(dealId, UserType.STUDENT);
//
//		//Excel sheet setup to do the save as
//		final FacesContext fc = getFacesContext();
//		final HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
//		String fileName = PresentationConstants.STUDENT_LIST_FILENAME;
//		response.setContentType(PresentationConstants.CONTENT_TYPE);
//		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
//		ServletOutputStream out = response.getOutputStream();
//
//		// create Excel file using Apache POI & name the excel name
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFSheet sheet = workbook.createSheet(fileName);
//
//		// Put all the header name into to an array
//		ArrayList<String> headerColumns = new ArrayList<String>();
//		headerColumns.add(PresentationConstants.STATUS);
//		headerColumns.add(PresentationConstants.FIRST_NAME);
//		headerColumns.add(PresentationConstants.LAST_NAME);
//		headerColumns.add(PresentationConstants.USERNAME);
//		headerColumns.add(PresentationConstants.PASSWORD);
//		headerColumns.add(PresentationConstants.SCHOOL);
//		headerColumns.add(PresentationConstants.CLASS);
//
//		// Create the first row
//		HSSFRow headerRow = sheet.createRow(0);
//		// populate column headings
//		HSSFCell cellData;
//		for (int i = 0; i < headerColumns.size(); i++)
//		{
//			cellData = headerRow.createCell(i);
//			cellData.setCellValue(headerColumns.get(i));
//			sheet.setColumnWidth(i, ROSTER_DEFAULT_COLUMN_WIDTH);
//		}
//		// freeze the header row
//		sheet.createFreezePane(0, 1, 0, 1);
//		
//		// Populated the acutal student data
//		HSSFCell userData;
//		HSSFRow dataRow;
//		for (int x = 1; x < user.size(); x++)
//		{
//			dataRow = sheet.createRow(x);
//
//			userData = dataRow.createCell(0);
//			userData.setCellValue(AccountStatus.getStringValue(user.get(x).getUser().getStatus()));
//			userData = dataRow.createCell(1);
//			userData.setCellValue(user.get(x).getUser().getFirstName());
//			userData = dataRow.createCell(2);
//			userData.setCellValue(user.get(x).getUser().getLastName());
//			userData = dataRow.createCell(3);
//			userData.setCellValue(user.get(x).getUser().getUserName());
//			userData = dataRow.createCell(4);
//			userData.setCellValue(user.get(x).getUser().getPassword());
//			userData = dataRow.createCell(5);
//			userData.setCellValue(user.get(x).getDealInstitution().getParentInstitution().getInstitutionName());
//			userData = dataRow.createCell(6);
//			userData.setCellValue(user.get(x).getDealInstitution().getInstitution().getInstitutionName());
//		}
//
//		// write the workbook and perform cleanup
//		workbook.write(out);
//		out.flush();
//		out.close();
//		fc.responseComplete();
//	}	
}