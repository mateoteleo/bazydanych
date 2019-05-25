import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

public class MyListModel extends DefaultListModel {

	ResultSet rs;
	ResultSetMetaData md;

	public MyListModel(String baseName) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName);
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getElementAt(int row) {
		try {
			int columnNumber = 1;
			rs.absolute(row + 1);
			return rs.getObject(columnNumber);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getReaderId(int row) {
		int readerID;
		try {
			rs.absolute(row+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int columnNumber = 3;
		try {
			return (int) rs.getObject(columnNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
		
	}
	
	@Override
	public int getSize() {
		int a = 0;

		try {
			rs.last();
			a = rs.getRow();
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
	}

	public void update(String baseName) {
		DbEdit dbEdit = new DbEdit();
		rs = dbEdit.readData(baseName);
		try {
			md = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
