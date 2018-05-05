import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL_DB {
    public void InserirDados(String nome, String email, String username, String password  ) {
        Connection conn = ConexaoMySQL.getConexaoMySQL();
        Statement statement = null;
        if(ConexaoMySQL.statusConection() && conn != null) {
            try {
                String sql = "INSERT INTO Registro (`id`, `nome`, `email`, `username`, `password`)"+ "VALUES (NULL, '" + nome + "', '+ " + email + "', '" + username + "', '" + password + "');";
                statement = conn.createStatement();
                statement.execute(sql);
                System.out.println("Dados inseridos com sucesso!");
                ConexaoMySQL.FecharConexao();

            } catch(SQLException se) {
                se.printStackTrace();
                System.out.println("Problema ao inserir os dados!");
                ConexaoMySQL.FecharConexao();
            }
        }
    }
}
