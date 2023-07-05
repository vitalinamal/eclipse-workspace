package sample;

public class Main {

	public static void main(String[] args) {

		Product laptop = new Product(12000, "Laptop Lenovo 1825", 1.5);
		Product monitor = new Product(125000, "Monitor Dell", 2.0);
		Product keyboard = new Product(150, "Keyboard Razer", 0.5);

		System.out.println(laptop);
		System.out.println(monitor);
		System.out.println(keyboard);

	}

}
