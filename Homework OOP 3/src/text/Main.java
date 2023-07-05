package text;

public class Main {

	public static void main(String[] args) {
		TextTransformer k = new TextTransformer ();
		
		System.out.println(k.transform("cat"));
		
		TextTransformer b = new UpDownTransformer();
		System.out.println(b.transform("parrot"));

	}

}
