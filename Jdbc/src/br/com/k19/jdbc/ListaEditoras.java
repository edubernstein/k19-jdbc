package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListaEditoras {
	public static void main(String[] args) {
		// String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		// String usuario = "root";
		// String senha = "root";
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();// DriverManager.getConnection(stringDeConexao,
																		// usuario,
																		// senha);
			String sql = "SELECT * FROM Editora;";
			PreparedStatement comando = conexao.prepareStatement(sql);
			System.out.println("Executando comando...");
			ResultSet resultado = comando.executeQuery();
			System.out.println(" Resultados encontrados: \n ");
			while (resultado.next()) {
				System.out.printf("%d : %s - %s \n", resultado.getInt("id"), resultado.getString("nome"), resultado.getString("email"));
			}
			System.out.println("\nFechando conexão...");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
