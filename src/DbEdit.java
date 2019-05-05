import java.sql.*;



public class DbEdit {
	
String query;

	public void enterData (String author, String title, int items) {
	try {   	
      	//tworzenie obiektu Connection, który jest niezbêdny do komunikacji z baz¹ SQL - kierujemy go do bazy/schema, dodatkowo z inf o kodowaniu znaków
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "mateusz", "teleg2");
          
          //tworzenie obiektu Statement, który musi zostaæ przekazany przez obiekt Connection do bazy, by wykonaæ zapytanie   
          Statement statement = con.createStatement();

          //tworzenie w³aœciwego zapytania sql
          //INSERT INTO Heroes (id, name, siblings) VALUES (2, 'Ron Weasley', 6);  
        query=("INSERT INTO books (author, title, items) VALUES ('" + author + "','" + title + "',"+ items +")");
          
          //wywo³ywanie metody executeUpdate z parametrem query -> do wstawiania nowych danych do tabeli
			statement.executeUpdate(query);
			
			//tworzenie drugiego zapytania do bazy, tym razem wpisuj¹c jego treœæ bezposednio do parametru metody
			//obiekt ResultSet s³u¿y do oczytywania danych z bazy - do ustalenia szczegó³y
         /* ResultSet rs2 = statement.executeQuery("select * from test");
          while (rs2.next())
              System.out.println(rs2.getInt(1) + "  ");*/
          con.close();
      } catch (Exception e) {
          System.err.println(e);
      }
      
    }
}