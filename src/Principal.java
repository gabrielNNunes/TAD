import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private static Cliente LerCliente() {
 String email=null;
 boolean emailValidado=true;
		
		Cliente cliente = new Cliente();

		System.out.println("Digite o nome:");
		System.out.println();
		System.out.print(">>");
		sc.nextLine();
		cliente.nome = sc.nextLine();

		System.out.println("Digite a idade:");
		System.out.println();
		System.out.print(">>");
		cliente.idade = sc.nextInt();

		System.out.println("Digite o cpf:");
		System.out.println();
		System.out.print(">>");
		sc.nextLine();
		cliente.cpf = sc.nextLine();

		System.out.println("Digite o telefone:");
		System.out.println();
		System.out.print(">>");
		cliente.telefone = sc.nextLine();

		System.out.println("Digite o email:");
		System.out.println();
		System.out.print(">>");
		
		while(emailValidado == true) {
		
		 email = sc.nextLine();
		 
		 emailValidado = validarEmail(email);
		 
		 if( emailValidado == false) {
			 
			cliente.email = email; 
		 }else {System.out.println("Email Inválido, Por favor digite o Email novamente!");}
		 }
		return cliente;
	}

	private static boolean validarEmail(String email) {
		
		
		char[] emailChar = email.toCharArray();
		
		for(int i=0;i < emailChar.length;i++){
			if(emailChar[i] == '@') {
				return false;	
				
			}			
		}
		return true;
	}

	private static void ImprimirMenu() {
		System.out.println("\n<<Menu>>\n");
		System.out.println("1- Inserir um novo Cliente");
		System.out.println("2- Mostrar informações de um Cliente");
		System.out.println("3- Modificar Cliente ja existente");
		System.out.println("4- Remover Cliente");
		System.out.println("5- Sair do Programa");
		System.out.println();
		System.out.print(">>");
	}

	private static void ImprimirUsuario(List<Cliente> clientes, int usuario, int todosClientes) {

		if (todosClientes == 1) {

			for (int i = 0; i < clientes.size(); i++) {

				System.out.println("Nome: " + clientes.get(i).nome);
				System.out.println("Idade: " + clientes.get(i).idade);
				System.out.println("Cpf: " + clientes.get(i).cpf);
				System.out.println("Telefone: " + clientes.get(i).telefone);
				System.out.println("Email: " + clientes.get(i).email);

			}

		} else {

			System.out.println("Nome: " + clientes.get(usuario).nome);
			System.out.println("Idade: " + clientes.get(usuario).idade);
			System.out.println("Cpf: " + clientes.get(usuario).cpf);
			System.out.println("Telefone: " + clientes.get(usuario).telefone);
			System.out.println("Email: " + clientes.get(usuario).email);

		}

	}

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Integer OpcaoMenu, whileInfinito = 0, usuario = 0, todosClientes = 0;

		System.out.println("<<Seja Bem Vindo ao Programa de Gerenciamento de Clientes!!>>");
		System.out.println("<<Selecione uma opção do menu>>");

		while (whileInfinito == 0) {

			ImprimirMenu();

			OpcaoMenu = sc.nextInt();

			switch (OpcaoMenu) {
			case 1:
				Cliente novoCliente = LerCliente();
				clientes.add(novoCliente);
				break;
			case 2:
				boolean verificador = true;

				while (verificador == true) {

					System.out.println("O que deseja imprimir?");
					System.out.println("1- Todos os clientes");
					System.out.println("2- Determidado cliente");
					System.out.println();
					System.out.print(">>");
					
					todosClientes = sc.nextInt();

					if (todosClientes == 1) {

						ImprimirUsuario(clientes, usuario, todosClientes);
						verificador = false;

					} else if (todosClientes == 2) {

						System.out.println("Digite o ID do usuário:");
						usuario = sc.nextInt();

						ImprimirUsuario(clientes, usuario, todosClientes);
						verificador = false;
					} else {
						System.out.println("Opção não Valida!");
					}

				}

				break;
			case 3:
				System.out.println("Função não implementada!!");
				break;
			case 4:
				System.out.println("Função não implementada!!");

				break;
			case 5:
				System.out.println();
				System.out.print("Programa Finalizado");
				whileInfinito = 1;
				sc.close();
				break;
			}
			if (OpcaoMenu < 1 || OpcaoMenu > 5) {
				System.out.println("Opção não Valida!");
			}
		}

		sc.close();
	}

}

class Cliente {
	String nome;
	Integer idade;
	String cpf;
	String telefone;
	String email;
}
