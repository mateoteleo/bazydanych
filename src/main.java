import java.sql.*;

public class main {
    public static void main(String args[]) {
    	
        try {   	
        	//tworzenie obiektu Connection, który jest niezbêdny do komunikacji z baz¹ SQL - kierujemy go do bazy/schema, dodatkowo z inf o kodowaniu znaków
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "mateusz", "teleg2");
            
            //tworzenie obiektu Statement, który musi zostaæ przekazany przez obiekt Connection do bazy, by wykonaæ zapytanie   
            Statement statement = con.createStatement();

        	//dodawanie obiektu query, który bêdzie treœci¹ zapytania do bazy
        	String query=("insert into test values (44)");
            
            //wywo³ywanie metody executeUpdate z parametrem query -> do wstawiania nowych danych do tabeli
			statement.executeUpdate(query);
			
			//tworzenie drugiego zapytania do bazy, tym razem wpisuj¹c jego treœæ bezposednio do parametru metody
			//obiekt ResultSet s³u¿y do oczytywania danych z bazy - do ustalenia szczegó³y
            ResultSet rs2 = statement.executeQuery("select * from test");
            while (rs2.next())
                System.out.println(rs2.getInt(1) + "  ");
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}