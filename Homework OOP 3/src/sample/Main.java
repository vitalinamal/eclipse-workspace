package sample;

public class Main {

	public static void main(String[] args) {
		Cat cat = new Cat("Milk", "white", 2, "Cheeks");
		System.out.println(cat);
		
		Veterinarian veterinarian = new Veterinarian("Vitalina");
		veterinarian.setName("Igor");
		veterinarian.treatment(cat);
	}

}
