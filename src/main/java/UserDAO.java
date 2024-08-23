//854730 - Laura Menezes heráclito Alves //
package exercicio2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO 
{	
	// meu construtor
	public UserDAO () 
	{
		super();
		conectar();
	}

	// terminando a conexao com a dao
	public void finalize () 
	{
		close();
	}
	
	// add um usuario
	public boolean insertUser (User user)
	{
		boolean status = false;
		try
		{
			Statement st = conexao.createStatement();
			String sql = ("INSERT INTO tablete (ID, Idade, Nome, Comida)" 
							+ " VALUES ("+ user.getID() + ", " 
									     + user.getAge() + ", '"
									     + user.getName() + "', '"
									     + user.getFood() + "');");
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		}
		catch(SQLException u)
		{
			throw new RuntimeException(u);
		}
		return (status);
	}
	
	// retornando o usuario
	public User get (int ID) 
	{
		User User = null;
		
		try 
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM tablete WHERE id=" + ID;
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
	        if(rs.next())
	        {            
	        	User = new User(rs.getInt("ID"), rs.getInt("Idade"), rs.getString("Nome"), rs.getString("Comida"));
	        }
	        st.close();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return User;
	}
	
	// listinhas
	public List<User> get() 
	{
		return get("");
	}
	
	public List<User> getOrderByID() 
	{
		return get("ID");
	}
	
	public List<User> getOrderByLogin() 
	{
		return get("Idade");
	}
	
	public List<User> getOrderByAge() 
	{
		return get("Nome");		
	}
	
	private List<User> get(String orderBy) 
	{	
		List<User> Users = new ArrayList<User>();
		
		try 
		{
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM tablete" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
	        while(rs.next()) 
	        {	            	
	        	User u = new User(rs.getInt("ID"), rs.getInt("Idade"), rs.getString("Nome"), rs.getString("Comida"));
	            Users.add(u);
	        }
	        st.close();
		} 
		catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		return Users;
	}
	
	// atualizando um user
	public boolean update (User User) 
	{
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			String sql = "UPDATE tablete SET Nome = '" 
							+ User.getName() + "', Idade  = '"  
							+ User.getAge() + "', Comida = '" 
							+ User.getFood() + "'" + " WHERE ID = " 
							+ User.getID();
			
			System.out.println(sql);
			st.executeUpdate(sql);
			
			st.close();
			status = true;
		} 
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	// dando delete em um user
	public boolean delete (int ID) 
	{
		boolean status = false;
		try 
		{  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM tablete WHERE ID = " + ID;
			
			System.out.println(sql);
			st.executeUpdate(sql);
			
			st.close();
			status = true;
		} 
		catch (SQLException u) 
		{  
			throw new RuntimeException(u);
		}
		return status;
	}
}

