package sample3;

public class Main {

	public static void main(String[] args) {
		Network vodafone = new Network("Vodafone");

		Phone phone1 = new Phone("+385995020894", true);
		Phone phone2 = new Phone("+385992024321", false);

		phone1.outcomingCall("+385992024321", vodafone);
		phone1.registerPhoneOnNetwork(vodafone);
		phone1.outcomingCall("+385992024321", vodafone);
		phone2.registerPhoneOnNetwork(vodafone);
		phone1.outcomingCall("+385992024321", vodafone);
		phone2.setOnline(true);
		phone1.outcomingCall("+385992024321", vodafone);

	}

}
