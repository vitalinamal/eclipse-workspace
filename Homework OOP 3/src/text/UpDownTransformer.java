package text;

public class UpDownTransformer extends TextTransformer {

	public String transform(String text) {
		String output = "";
		
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			if (i % 2 == 0) {
				output += Character.toUpperCase(letter);
			} else {
				output += Character.toLowerCase(letter);
			}
		}
		return output;
	}

}
