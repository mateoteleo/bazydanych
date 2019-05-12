import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	
    
    Statement stmt;
    ResultSet rs;
    ResultSetMetaData md;
    int columns;
    Connection connection;
    
    Vector<Object> columnNames = new Vector<Object>();
    Vector<Object> data = new Vector<Object>();
    
    MyTableModel(){
    try
    {
        connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"mateusz", "teleg2");
        String sql = "Select * from books";
        stmt = connection.createStatement();
        rs = stmt.executeQuery( sql );
        md = rs.getMetaData();
        //  Read data from a table

       
        columns = md.getColumnCount();

        //  Get column names

    }
    catch(Exception e)
    {
        System.out.println( e );
    }

    for (int i = 1; i <= columns; i++)
    {
        columnNames.addElement( md.getColumnName(i) );
    }

    //  Get row data

    while (rs.next())
    {
        Vector<Object> row = new Vector<Object>(columns);

        for (int i = 1; i <= columns; i++)
        {
            row.addElement( rs.getObject(i) );
        }

        data.addElement( row );
    }

    rs.close();
    stmt.close();
    connection.close();
    }
public int getColumnCount() {
return columnNames.length;
}

public int getRowCount() {
return data.length;
}

public String getColumnName(int col) {
return columnNames[col];
}

public Object getValueAt(int row, int col) {
return data[row][col];
}

/*
* JTable uses this method to determine the default renderer/
* editor for each cell.  If we didn't implement this method,
* then the last column would contain text ("true"/"false"),
* rather than a check box.
*/
public Class getColumnClass(int c) {
return getValueAt(0, c).getClass();
}

/*
* Don't need to implement this method unless your table's
* editable.
*/
public boolean isCellEditable(int row, int col) {
//Note that the data/cell address is constant,
//no matter where the cell appears onscreen.
if (col < 2) {
return false;
} else {
return true;
}
}

/*
* Don't need to implement this method unless your table's
* data can change.
*/
public void setValueAt(Object value, int row, int col) {
if (DEBUG) {
System.out.println("Setting value at " + row + "," + col
       + " to " + value
       + " (an instance of "
       + value.getClass() + ")");
}

data[row][col] = value;
fireTableCellUpdated(row, col);

if (DEBUG) {
System.out.println("New value of data:");
printDebugData();
}
}

private void printDebugData() {
int numRows = getRowCount();
int numCols = getColumnCount();

for (int i=0; i < numRows; i++) {
System.out.print("    row " + i + ":");
for (int j=0; j < numCols; j++) {
System.out.print("  " + data[i][j]);
}
System.out.println();
}
System.out.println("--------------------------");
}
}

}
