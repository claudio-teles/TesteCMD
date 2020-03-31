package teste_cmd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteCMD {

  public static void main(String[] args) {
    // Local no disco rígido onde está localizado o arquivo .jar a ser adicionado ao path ou classpath do projeto.
    // driver /home/claudio/Jars/drivers/SQLite3/sqlite-jdbc-3.30.1.jar
    connect();
    // CMD na mesma pasta one está o o metodo main
    // javac -d /home/claudio/workspaces/workspace-java/TesteCMD/bin -cp /home/claudio/Jars/drivers/SQLite3/sqlite-jdbc-3.30.1.jar: TesteCMD.java
    // CMD na mesma pasta onde está o diretório bin
    // java -cp /home/claudio/Jars/drivers/SQLite3/sqlite-jdbc-3.30.1.jar: teste_cmd.TesteCMD
    //System.out.println(System.getProperty("java.class.path"));
  }

  public static void connect() {
      Connection conn = null;
      try {
          // db parameters
          String url = "jdbc:sqlite:sqlite.db";
          // create a connection to the database
          conn = DriverManager.getConnection(url);

          System.out.println("Conexão estabelecida com sucesso!.");

      } catch (SQLException e) {
          System.out.println(e.getMessage());
      } finally {
          try {
              if (conn != null) {
                  conn.close();
              }
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
      }
  }

}
