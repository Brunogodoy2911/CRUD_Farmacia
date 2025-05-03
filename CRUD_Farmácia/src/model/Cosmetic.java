package model;

public class Cosmetic extends Product {

	private String fragrance;

	public String getFragrance() {
		return fragrance;
	}

	public void setFragrance(String fragrance) {
		this.fragrance = fragrance;
	}

	@Override
	public void view() {
		System.out.println("Fragrância: " + fragrance);
	}

}
