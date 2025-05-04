package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProductController;
import model.Cosmetic;
import model.Medicine;

public class Menu {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);

		ProductController products = new ProductController();

		while (true) {
			try {
				System.out.println("\n************************************************");
				System.out.println("                 🛒 MENU FARMÁCIA                ");
				System.out.println("************************************************");
				System.out.println(" 1️⃣  - Criar Produto");
				System.out.println(" 2️⃣  - Listar Todos os Produtos");
				System.out.println(" 3️⃣  - Listar Produtos por ID");
				System.out.println(" 4️⃣  - Atualizar Produto");
				System.out.println(" 5️⃣  - Deletar Produto");
				System.out.println(" 0️⃣  - Sair");
				System.out.println("************************************************");
				System.out.print("👉 Escolha uma opção: ");

				int option = read.nextInt();
				read.nextLine();

				if (option == 0) {
					about();
					read.close();
					System.exit(0);
				}

				switch (option) {
				case 1 -> {
					System.out.println("\nCriar Produto: \n");

					System.out.println("Digite o NOME do produto: ");
					String name = read.nextLine();

					System.out.println("Digite o TIPO do produto: (1 - Medicamento | 2 - Cosmético)");
					int type = read.nextInt();
					read.nextLine();

					System.out.println("Digite o PREÇO do produto: ");
					double price = read.nextFloat();
					read.nextLine();

					switch (type) {
					case 1 -> {
						System.out.println("Medicamento é GENÉRICO?: ");
						String generic = read.nextLine();

						products.createProduct(new Medicine(products.generateId(), name, price, generic));
					}
					case 2 -> {
						System.out.println("Digite a FRAGRÂNCIA do Cosmético: ");
						String fragrance = read.nextLine();

						products.createProduct(new Cosmetic(products.generateId(), name, price, fragrance));
					}
					default -> System.out.println("❌ Tipo inválido.");
					}

				}
				case 2 -> {
					products.listAllProducts();
				}
				case 3 -> {

					System.out.println("Digite o ID do produto que deseja procurar: ");
					int id = read.nextInt();

					products.listProductById(id);
				}
				case 4 -> {
					System.out.println("Digite o ID do produto que deseja atualizar: ");
					int id = read.nextInt();
					read.nextLine();

					if (products.existsById(id)) {
						System.out.println("Digite o novo NOME do produto: ");
						String newName = read.nextLine();

						System.out.println("Digite o novo TIPO do produto: (1 - Medicamento | 2 - Cosmético)");
						int newType = read.nextInt();
						read.nextLine();

						System.out.println("Digite o novo PREÇO do produto: ");
						double newPrice = read.nextFloat();
						read.nextLine();

						switch (newType) {
						case 1 -> {
							System.out.println("Medicamento é GENÉRICO?: ");
							String generic = read.nextLine();

							products.updateProduct(id, new Medicine(id, newName, newPrice, generic));
						}
						case 2 -> {
							System.out.println("Digite a FRAGRÂNCIA do Cosmético: ");
							String fragrance = read.nextLine();

							products.updateProduct(id, new Cosmetic(id, newName, newPrice, fragrance));
						}
						default -> System.out.println("❌ Tipo inválido.");
						}
					} else {
						System.out.println("❌ Produto com ID " + id + " não existe!");
					}

				}
				case 5 -> {
					System.out.println("Digite o ID do produto que deseja remover: ");
					int id = read.nextInt();
					read.nextLine();

					products.removeProduct(id);
				}
				default -> System.out.println("\n❌ Opção inválida. Tente novamente.");
				}
			} catch (InputMismatchException e) {
				System.out.println("❌ Entrada inválida! Por favor, digite um valor numérico correto.");
				read.nextLine();
			} catch (Exception e) {
				System.out.println("❌ Ocorreu um erro inesperado: " + e.getMessage());
				read.nextLine();
			}
		}

	}

	public static void about() {
		System.out.println("\n*********************************************************");
		System.out.println("👋 Saindo do sistema... Até logo!\n");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Bruno Godoy - brunogodoy29@hotmail.com");
		System.out.println("https://github.com/Brunogodoy2911");
		System.out.println("*********************************************************");
	}

}
