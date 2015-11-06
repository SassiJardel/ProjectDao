/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.modelo.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class PessoaDaoDerby implements Dao{

    Statement stmt;
    
    //quando eu construir um objeto dessa classe, vou conectar no banco.
    public PessoaDaoDerby(){
        String username = "theRoot";
        String password = "123";
        String url = "jdbc:derby://localhost:1527/BancoG";
        
        //depois disso, posso mandar conectar
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        }catch(SQLException se){
            System.out.println("Mensagem: " + se.getMessage());
    }
    }
    
    
    
    @Override
    public void adicionar(Pessoa p) {
        String instrucao = "INSERT INTO PESSOA (NOME, SOBRENOME, IDADE, CODIGO) VALUES ("
        + "'" +  p.getNome() + "', " + "'" + p.getSobrenome() + "', " + p.getIdade() + ", " +p.getCodigo() + ")";
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se){
            System.out.println("Mensagem: " + se.getMessage());
        }
    }

    @Override
    public void remover(Pessoa p) {
        String instrucao = "DELETE FROM PESSOA WHERE CODIGO = " + "" + p.getCodigo() + "";
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se){
            System.out.println("Mensagem: " + se.getMessage());
        }
    }
    @Override
        public void remover(int id) {
        String instrucao = "DELETE FROM PESSOA WHERE CODIGO = " + "" + id + "";
        System.out.println(instrucao);
        try{
            stmt.executeUpdate(instrucao);
        }catch (SQLException se){
            System.out.println("Mensagem: " + se.getMessage());
        }
    }
    
   

    @Override
    public void listarTudo() {
        String instrucao = "SELECT * FROM PESSOA";
        
        try{
            
            //um select traz resultados que precisam ser armazenados.
            //vou executar e armazenar o resultado.
            
            ResultSet rs = stmt.executeQuery(instrucao);
            
            while (rs.next()){
                System.out.println("Nome: " + rs.getString("NOME") + " Sobrenome: " + rs.getString("SOBRENOME") + " Idade: " + rs.getString("IDADE") +
                       " Codigo: " + rs.getString("CODIGO") );
            }
            
        }catch(SQLException se){
            System.out.println("Mensagem: " + se.getMessage());
        }
        
    }
    
    
    
}
