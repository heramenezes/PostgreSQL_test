//854730 - Laura Menezes Heráclito Alves //
package exercicio2;

public class User {
	private int ID;
	private int Idade;
	private String Nome;
	private String Comida;

	public User(){
		ID = -1;
		Idade = -1;
		Nome = null;
		Comida = null;
	}

	public User(int identi, int age, String name, String food){
		ID = identi;
		Idade = age;
		Nome = name;
		Comida = food;
	}

	public User(int identi, String name){
		ID = identi;
		Nome = name;
	}

	public int getID(){
		return ID;
	}

	public int getAge(){
		return Idade;
	}

	public String getName(){
		return Nome;
	}

	public String getFood(){
		return Comida;
	}

	protected void setName(String newName){
		Nome = newName;
	}

	public String toString(){
		return "User [ ID = " + ID + " Idade = " + Idade + " Nome = " + Nome + " Comida = " + Comida + " ]";
	}
}
