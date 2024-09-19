
package Conexao;

import java.sql.SQLException;
import java.util.*;


public class comandos {
    public static void main(String[]args) throws SQLException{
        
        OperacoesDB comandos = new OperacoesDB();
        Scanner sc = new Scanner(System.in);
        
        System.out .println("Digite seu nome: ");
        String nome = sc.next();
        System.out .println("digite o email:");
        String email = sc.next();
        
        comandos.insert(nome, email);
        
        //comandos.select();
        //comandos.delete(1);
        //comandos.update("deu booooooaaaaaaaa","2");
        
    }
}
