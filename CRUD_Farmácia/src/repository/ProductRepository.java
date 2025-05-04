package repository;

import model.Product;

public interface ProductRepository {

	public void createProduct(Product product);

	public void listAllProducts();

	public void listProductById(int id);

	public void updateProduct(int id, Product newProduct);

	public void removeProduct(int id);

}
