import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Assignment1 {

  public static Connection getConnection() {

    try {
      String url = "jdbc:mysql://localhost:3306/sqlandjava" +
                   "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                   "&useLegacyDatetimeCode=false&serverTimezone=UTC";
      String username = "user";
      String password = "password";

      Connection conn = DriverManager.getConnection(url,username,password);
      System.out.println("Connected to database!");
      return conn;

    } catch (Exception e) {
        System.out.println(e);
    }
    return null;
  }

  public static void main(String[] args) throws Exception {
    Connection conn = getConnection();
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM people");

    while (resultSet.next()) {
      System.out.println(resultSet.getString("person_id") + ": " +
              resultSet.getString("firstname") + " " +
              resultSet.getString("lastname"));
    }
  }

}