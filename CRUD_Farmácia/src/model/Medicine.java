package model;

public class Medicine extends Product {

	private String generic;

	public String getGeneric() {
		return generic;
	}

	public void setGeneric(String generic) {
		this.generic = generic;
	}

	@Override
	public void view() {
		System.out.println("Genérico: " + generic);
	}
}
