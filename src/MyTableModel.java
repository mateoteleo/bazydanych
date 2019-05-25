import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	String[] columnNames = new String[5];

	ResultSet rs;
	ResultSetMetaData md;

	public MyTableModel(String baseName) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName);
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (baseName == "books") {
			columnNames[0] = "Imiê";
			columnNames[1] = "Nazwisko";
			columnNames[2] = "Tytu³";
			columnNames[3] = "Egzemplarze";
			columnNames[4] = "ID";
		} else if (baseName == "readers") {
			columnNames[0] = "Imiê";
			columnNames[1] = "Nazwisko";
			columnNames[2] = "ID";
		}
		
		}


	public MyTableModel(String baseName, int idReader) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName, idReader);
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			columnNames[0] = "Imiê";
			columnNames[1] = "Nazwisko";
			columnNames[2] = "Tytu³";
			columnNames[3] = "Data wypo¿yczenia";
			columnNames[4] = "ID";
	}
	
	public int getRowCount() {
		int a = 0;
		try {
			rs.last();
			a = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	};

	public int getColumnCount() {
		try {
			return md.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String getColumnName(int a) {
		return columnNames[a];
	};

	public Object getValueAt(int row, int column) {
		try {
			rs.absolute(row + 1);
			return rs.getObject(column + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	};

	public void updateTable(String baseName) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName);
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTable(String baseName, int idReader) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName, idReader);
	
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			System.out.print("dupa");
		}
	}
}
