package sample;

public class Dog extends Animal{

	private String name;

	public Dog(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Dog() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getVoice() {
	    return "woof woof";
	  }

    public void eat() {
    	System.out.println("Eat meat");
  }

    public void sleep() {
    	System.out.println("Sleeps");
  }

	@Override
	public String toString() {
		return "Dog [" + super.toString() + "name=" + name + "]";
	}
	
}
