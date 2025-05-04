package controller;

import java.util.ArrayList;

import model.Product;
import repository.ProductRepository;

public class ProductController implements ProductRepository {

	private ArrayList<Product> products = new ArrayList<Product>();

	int idAutomatic = 0;

	@Override
	public void createProduct(Product product) {
		product.setId(idAutomatic);
		products.add(product);

		System.out.println("\n✅ Produto criado com sucesso!");
	}

	@Override
	public void listAllProducts() {
		if (products.isEmpty()) {
			System.out.println("\n❌ Não há produtos cadastrados no momento. Adicione novos produtos para começar.");
		} else {
			System.out.println("\n📋 Lista de todos os Produtos:");
			for (Product prod : products) {
				prod.view();
			}
		}

	}

	@Override
	public void listProductById(int id) {
		System.out.printf("\n📋 Lista de todos os Produtos com ID %d: \n", id);
		for (Product prod : products) {
			if (prod.getId() == id) {
				prod.view();
			}
		}
	}

	@Override
	public void updateProduct(int id, Product newProduct) {
		boolean found = false;

		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getId() == id) {
				newProduct.setId(id);
				products.set(i, newProduct);
				System.out.println("\n✅ Produto atualizado com sucesso!");
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("\n❌ Produto com ID " + id + " não encontrado.");
		}
	}

	@Override
	public void removeProduct(int id) {

		boolean removed = products.removeIf(prod -> prod.getId() == id);

		if (removed) {
			System.out.println("\n🗑️ Produto removido com sucesso!");
		} else {
			System.out.println("\n❌ Produto com ID " + id + " não encontrado.");
		}
	}

	public int generateId() {
		return ++idAutomatic;
	}

	public boolean existsById(int id) {
		for (Product prod : products) {
			if (prod.getId() == id) {
				return true;
			}
		}
		return false;

	}
}
