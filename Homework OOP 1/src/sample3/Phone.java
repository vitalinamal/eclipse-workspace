package sample3;

import java.util.Optional;

public class Phone {

	private String phoneNumber;
	private boolean isOnline;

	public Phone() {
		super();
	}

	public Phone(String phoneNumber, boolean isOnline) {
		this.phoneNumber = phoneNumber;
		this.isOnline = isOnline;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isOnline() {
		return isOnline;
	}

	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	public void registerPhoneOnNetwork(Network network) {
		network.addNumberToRegistry(this);
	}

	public void outcomingCall(String phoneNumber, Network network) {
		if (!network.getRegisteredNumbers().contains(this)) {
			System.out.println("Your phone is not registered on the network!");
			return;
		}

		Optional<Phone> wantedNumber = network.getRegisteredNumbers().stream()
				.filter(phone -> phone.getPhoneNumber().equals(phoneNumber)).findFirst();

		if (wantedNumber.isEmpty()) {
			System.out.println("Number who you are calling is not registered on network!");
			return;
		}

		if (wantedNumber.get().isOnline) {
			wantedNumber.get().incomingCall(this);
		} else {
			System.out.println("Wanted number is not online!");
		}

	}

	public void incomingCall(Phone phone) {
		System.out.println("Incoming call from " + phone.phoneNumber);
	}

	@Override
	public String toString() {
		return "Phone [phoneNumber=" + phoneNumber + ", isOnline=" + isOnline + "]";
	}

	
}
