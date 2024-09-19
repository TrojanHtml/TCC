package Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacoesDB {

    public void Select() {
        String sql = "SELECT * FROM usuario";
        try (
                //estabeleça a coneção do banco de dados
                Connection conn = ConexaoDB.getConexao();
                //prepara os o comando sql a ser executado
                PreparedStatement stmt = conn.prepareStatement(sql);
                //rs recebe a execução da query
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                //processa resultados 
                String nomef = rs.getString("nome");
                String email = rs.getString("email");

                System.out.println("deu boa " + nomef + " o email é: "+email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(String nome, String email) {
        String sql = "INSERT INTO usuario (nome,email) VALUES (?,?)";
        try (Connection conn = ConexaoDB.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int iddeletado) {
        String sql = "delete from usuário where id = ?";
        try (Connection conn = ConexaoDB.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, iddeletado);
            int rowAffected = stmt.executeUpdate();
            System.out.println(rowAffected + " linhsa deletados.");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void update(String nome, int idupdate) throws SQLException {
        String sqlUpdate = "UPDATE usuario SET nome = ? WHERE id = ?";
        try (
                Connection conn = ConexaoDB.getConexao();
                PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
            pstmtUpdate.setString(1, nome);
            pstmtUpdate.setInt(1, idupdate);//id do resgistro a ser atualizado
            int rowsAffected = pstmtUpdate.executeUpdate();
            System.out.println(rowsAffected + " linhas atualizadas");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//metodos para dlete e update seguem a logica similar ao insert
}
