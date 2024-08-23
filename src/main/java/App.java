//854730 - Laura Menezes Heráclito Alves // 
package exercicio2;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		UserDAO UDA = new UserDAO();
		DAO dao = new DAO();
		dao.conectar();
		int choice = 0;

		do{
			System.out.println("[1] - Insert\n[2] - Get\n[3] - Update\n[4] - Delete\n[0] - Sair");
			System.out.print("\nInsira sua opcao: ");
			choice = sc.nextInt();
			
			switch(choice){
				case 1: insert(UDA); break;
				case 0: break;
				default: System.out.println("Deu erro"); break;
			}

		} while(choice!=0);
		sc.close();
		dao.close();
		UDA.finalize();
	}

	public static void insert(UserDAO UDAO){
		Scanner s = new Scanner(System.in);
		System.out.print("Forneca os valores para ID: ");
		int i = s.nextInt();
		System.out.print("Forneca o valor da idade; ");
		int a = s.nextInt();
		System.out.print("Insira o nome; ");
		String no = s.next();
		System.out.print("Insira a comida: ");
		String co = s.next();
		User novo = new User(i, a, no, co);
		if(UDAO.insertUser(novo)) System.out.println("Usuario inserido com sucesso");
		else System.out.println("Deu erro");
	}
}
