//854730 - Laura Menezes Heráclito Alves // 

package exercicio2;

import java.sql.*;
import java.math.*;
import java.security.*;

public class DAO 
{
	protected Connection conexao;
	
	// meu construtor
	public DAO() 
	{
		conexao = null;
	}
	
	// fazendo a conexao com a dao
	public boolean conectar() 
	{	
		// meus parametros da coneccao
		String driverName = "org.postgresql.Driver";                    
		String serverName = "localhost";
		String mydatabase = "teste";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "laura";
		String password = "Lau@1003";
		
		boolean status = false; 	

		try 
		{
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} 
		catch (ClassNotFoundException e) 
		{ 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} 
		catch (SQLException e) 
		{
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}
		return status;
	}

	public boolean close() 
	{
		boolean status = false;
		
		try 
		{
			conexao.close();
			status = true;
		} 
		catch (SQLException e) 
		{
			System.err.println(e.getMessage());
		}
		return status;
	}
}

