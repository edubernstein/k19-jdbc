package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ApagaEditora {
	public static void main(String[] args) {
		// String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		// String usuario = "root";
		// String senha = "root";
		try {
			System.out.println("Abrindo conexão...");
			Connection conexao = ConnectionFactory.createConnection();// DriverManager.getConnection(stringDeConexao,
																		// usuario,
																		// senha);
			Scanner entrada = new Scanner(System.in);
			System.out.println("Digite o id da editora: ");
			String id = entrada.nextLine();
			entrada.close();
			String sql = "DELETE from Editora where id = ?";
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, id);
			System.out.println("Executando comando...(" + sql + ")");
			comando.execute();
			System.out.println("Fechando conexão...");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
