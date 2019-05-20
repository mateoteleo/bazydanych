import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbEdit {

	String query;

	public ResultSet readData() {

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			String sql = "Select firstname, lastname, title, items, idbooks from books";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			return rs;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}

	}

	public void enterData(String firstname, String lastname, String title, int items, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();
			query = ("INSERT INTO " + table + " (firstname, lastname, title, items) VALUES ('" + firstname + "','"
					+ lastname + "','" + title + "'," + items + ")");
			statement.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void editData(String firstname, String lastname, String title, int id, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();
			query = ("UPDATE " + table + " SET firstname='" + firstname + "', lastname='" + lastname + "', title='"
					+ title + "' WHERE idbooks=" + id);
			statement.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void deleteData(int row, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();
			query = ("DELETE FROM " + table + " WHERE idbooks=" + row);
			statement.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}