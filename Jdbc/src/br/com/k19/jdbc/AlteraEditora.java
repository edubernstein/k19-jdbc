package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AlteraEditora {
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
			System.out.println("Digite o novo nome da editora: ");
			String nome = entrada.nextLine();
			System.out.println("Digite o novo email da editora: ");
			String email = entrada.nextLine();
			entrada.close();
			String sql = "update Editora set nome = ?, email = ? where id = ?";
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, nome);
			comando.setString(2, email);
			comando.setString(3, id);
			System.out.println("Executando comando...(" + sql + ")");
			comando.execute();
			System.out.println("Fechando conexão...");
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
