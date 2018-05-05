// Importando as classes para iniciar o banco de dados
import java.sql.*;

public class ConexaoMySQL {
    public static boolean status = true;


    // Inicializando o Construtor

    public ConexaoMySQL() {

    }

    // Método para conexão

    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;          //atributo do tipo Connection


        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            // Configurando a nossa conexão com um banco de dados//
            String serverName = "localhost";                      //caminho do servidor do DB - localhost ou ip do servidor
            String mydatabase ="Nome do Banco de Dados";                                  //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "Usuario do Banco de Dados";                              //nome de um usuário de seu BD
            String password = "Senha do Banco de Dados!!";                         //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);

            // Verificação de conexão
            if (connection != null) {
                status = true;
                System.out.println("Conectado com sucesso!");
            } else {
                status = false;
                System.out.println("Não foi possível realizar a conexão");
            }

            return connection;

        } catch (ClassNotFoundException e) {  // O Driver não encontrado
            System.out.println("O driver especificado nao foi encontrado.");
            return null;

        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possível conectar ao Banco de Dados.");
            return null;
        }

    }

    // Método que retorna o status da conexão

    public static boolean statusConection() {
        return status;

    }

    //Método que fecha a conexão

    public static boolean FecharConexao() {

        try {
            ConexaoMySQL.getConexaoMySQL().close();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }



    //Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySQL.getConexaoMySQL();
    }
}