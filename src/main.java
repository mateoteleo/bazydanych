import java.sql.*;

public class main {
    public static void main(String args[]) {
    	
        try {   	
        	//tworzenie obiektu Connection, kt�ry jest niezb�dny do komunikacji z baz� SQL - kierujemy go do bazy/schema, dodatkowo z inf o kodowaniu znak�w
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "mateusz", "teleg2");
            
            //tworzenie obiektu Statement, kt�ry musi zosta� przekazany przez obiekt Connection do bazy, by wykona� zapytanie   
            Statement statement = con.createStatement();

        	//dodawanie obiektu query, kt�ry b�dzie tre�ci� zapytania do bazy
        	String query=("insert into test values (44)");
            
            //wywo�ywanie metody executeUpdate z parametrem query -> do wstawiania nowych danych do tabeli
			statement.executeUpdate(query);
			
			//tworzenie drugiego zapytania do bazy, tym razem wpisuj�c jego tre�� bezposednio do parametru metody
			//obiekt ResultSet s�u�y do oczytywania danych z bazy - do ustalenia szczeg�y
            ResultSet rs2 = statement.executeQuery("select * from test");
            while (rs2.next())
                System.out.println(rs2.getInt(1) + "  ");
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}