import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	String[] columnNames = { "Imiê", "Nazwisko", "Tytu³", "Egzemplarze", "ID" };

	ResultSet rs;
	ResultSetMetaData md;

	public MyTableModel() {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData();
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getRowCount() {
		int a = 0;
		try {
			rs.last();
			a = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public void updateTable() {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData();
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
