package model;

public class Cosmetic extends Product {

	private String fragrance;

	public Cosmetic(int id, String name, double price, String fragrance) {
		super(id, name, 2, price);
		this.fragrance = fragrance;
	}

	public String getFragrance() {
		return fragrance;
	}

	public void setFragrance(String fragrance) {
		this.fragrance = fragrance;
	}

	@Override
	public void view() {
		super.view();
		System.out.println("Fragrância: " + fragrance);
	}

}
