package model;

public class Medicine extends Product {

	private String generic;

	public Medicine(int id, String name, double price, String generic) {
		super(id, name, 1, price);
		this.generic = generic;
	}

	public String getGeneric() {
		return generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
	}

	@Override
	public void view() {
		super.view();
		System.out.println("Genérico: " + generic);
	}
}
