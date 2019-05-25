import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class DbEdit {

	String query;

	public ResultSet readData(String baseName) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			if (baseName == "books") {
				String sql = ("Select firstname, lastname, title, items, idbook from " + baseName);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);

				return rs;
			} else if (baseName == "readers") {
				String sql = ("Select firstname, lastname, idreaders from " + baseName);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				return rs;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}

	public ResultSet readData(String baseName, int idReader) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			String sql = ("SELECT books.firstname, books.lastname, books.title, rentals.date FROM books INNER JOIN rentals ON rentals.idbook = books.idbook WHERE rentals.idreader="
					+ idReader);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (NullPointerException e) {
			return null;
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

	public void enterData(String firstname, String lastname, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();
			query = ("INSERT INTO " + table + " (firstname, lastname) VALUES ('" + firstname + "','" + lastname + "')");
			statement.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void enterData(int idbook, int idreader, LocalDate date, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();

			query = ("INSERT INTO " + table + " (idbook, idreader, date) VALUES ('" + idbook + "','" + idreader + "','"
					+ date + "')");
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
					+ title + "' WHERE idbook=" + id);
			statement.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void editData(String firstname, String lastname, int id, String table) {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"mateusz", "teleg2");
			Statement statement = con.createStatement();
			query = ("UPDATE " + table + " SET firstname='" + firstname + "', lastname='" + lastname
					+ "' WHERE idreaders=" + id);
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

			if (table == "books") {
				query = ("DELETE FROM " + table + " WHERE idbook=" + row);
				statement.executeUpdate(query);
				con.close();
			} else if (table == "readers") {
				query = ("DELETE FROM " + table + " WHERE idreaders=" + row);
				statement.executeUpdate(query);
				con.close();
			}

		} catch (Exception e) {
			System.err.println(e);
		}

	}
}