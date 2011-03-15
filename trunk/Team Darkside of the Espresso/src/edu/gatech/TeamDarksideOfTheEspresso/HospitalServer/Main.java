/**
 * Hospital Server Application Entry Point
 * 
 * @author	Fraser P. Newton
 * @date	March 4, 2011
 */

package edu.gatech.TeamDarksideOfTheEspresso.HospitalServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main
{
	static String url = "jdbc:sqlite:DB/Data.db";
	static int count = 0;
	static Connection con = null;
	public static void main(String[] args) {
		Connection con = getOracleJDBCConnection();
		PersonDetails person1 = new PersonDetails("hemanth", 10, "Male");
		PersonDetails person2 = new PersonDetails("bob", 12, "Male");
		PersonDetails person3 = new PersonDetails("Richa", 10, "Female");
		PreparedStatement ps;
		try {
			Statement st = con.createStatement();
			st.executeUpdate("DROP TABLE IF EXISTS SerialTest;");
			st.executeUpdate("CREATE TABLE SerialTest(a, b);");
			
			ps = con
					.prepareStatement("INSERT INTO SerialTest VALUES (?, ?)");
			write(person1, ps);
			ps.execute();
			write(person2, ps);
			ps.execute();
			write(person3, ps);
			ps.execute();
			ps.close();
			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM SerialTest");
			while (rs.next()) {
				Object obj = read(rs, "a");
				PersonDetails p = (PersonDetails) obj;
				System.out.println(p.getName() + "\t" + p.getAge() + "\t"
						+ p.getSex());
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void write(Object obj, PreparedStatement ps)
			throws SQLException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(baos);
		oout.writeObject(obj);
		oout.close();
		ps.setBytes(1, baos.toByteArray());
		ps.setInt(2, ++count);
	}
	public static Object read(ResultSet rs, String column)
			throws SQLException, IOException, ClassNotFoundException {
		byte[] buf = rs.getBytes(column);
		if (buf != null) {
			ObjectInputStream objectIn = new ObjectInputStream(
					new ByteArrayInputStream(buf));
			return objectIn.readObject();
		}
		return null;
	}
	public static Connection getOracleJDBCConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {
			con = DriverManager.getConnection("jdbc:sqlite:DB/Data.db");
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
	}
	/**
	 * Hospital Server application entry point
	 * 
	 * @param args Application arguments
	 */
//	public static void main(String[] args)
//	{
//        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//        UserInfo info = null;
//        User usr;
//		
//		try
//		{
//			info = new UserInfo("Fraser Purcell Newton", "1214 Woodridge Drive\nAtlanta, GA\n30339", "(678) 468-0074", "999-99-9999", "fnewton3@gatech.edu", formatter.parse("10/25/1990"));
//			usr = new Patient("fnewton3", "hashash", GenderType.Male, info, null);
//			
//	        Database db = new Database();
//	        db.InitializeDB();
//	        db.CreateNewDatabase();
//	        db.InsertObject(info);
//	        
//	        UserInfo ret = db.getUser(0);
//	        System.out.println(ret.getEmailAddress());
//	        
//	        db.CloseDbConnection();
//		}
//		catch (ParseException e)
//		{
//			SystemLog.LogMessage(e.getMessage(), Level.SEVERE);
//		}
//	}
}
