package sample;

public class Cat extends Animal {

	private String name;

	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Cat() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getVoice() {
	    return "meow meow";
	  }

    public void eat() {
    	System.out.println("Eat fish");
  }

    public void sleep() {
    	System.out.println("Sleeps");
  }

	@Override
	public String toString() {
		return "Cat [" + super.toString() + "name=" + name + "]";
	}
	
	
	
}
