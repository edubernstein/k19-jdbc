package br.com.k19.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AlteraLivro {
	public static void main(String[] args) {
		// String stringDeConexao = "jdbc:mysql://localhost:3306/livraria";
		// String usuario = "root";
		// String senha = "root";
		System.out.println("Abrindo conexão...");
		try (Connection conexao = ConnectionFactory.createConnection();// DriverManager.getConnection(stringDeConexao,
																		// usuario,
																		// senha);
				Scanner entrada = new Scanner(System.in)) {
			System.out.println("Digite o id do livro: ");
			String id = entrada.nextLine();
			System.out.println("Digite o novo título do livro: ");
			String titulo = entrada.nextLine();
			System.out.println("Digite o novo preco do livro: ");
			String preco = entrada.nextLine();
			System.out.println("Digite o novo ID da editora do livro: ");
			String editoraId = entrada.nextLine();
			entrada.close();
			String sql = "update Livro set titulo = ?, preco = ?, editora_id = ? where id = ?";
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, titulo);
			comando.setString(2, preco);
			comando.setString(3, editoraId);
			comando.setString(4, id);
			System.out.println("Executando comando...(" + sql + ")");
			comando.execute();
			System.out.println("Fechando conexão...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
