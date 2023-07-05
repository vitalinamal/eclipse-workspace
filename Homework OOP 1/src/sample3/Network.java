package sample3;

import java.util.ArrayList;
import java.util.List;

public class Network {

	private final String name;

	private List<Phone> registeredNumbers;

	public Network(String name) {
		super();
		this.name = name;
		this.registeredNumbers = new ArrayList<>();
	}

	public List<Phone> getRegisteredNumbers() {
		return registeredNumbers;
	}

	public void addNumberToRegistry(Phone numberToRegistry) {
		if (this.registeredNumbers.stream().filter(pn -> pn.getPhoneNumber().equals(numberToRegistry.getPhoneNumber()))
				.findAny().isPresent()) {
			System.out.println("Phone with this number is already registred! " + numberToRegistry);
		}
		this.registeredNumbers.add(numberToRegistry);
		System.out.println("Number " + numberToRegistry + " was added to registry!");
	}

	public String getName() {
		return name;
	}

}
