package text;

public class InverseTransformer extends TextTransformer {
	
	public String transform(String text) {
		 char[] s = text.toCharArray();
		 String revers = "";
		  for (int i = s.length - 1; i >= 0; i--) {
			  revers += s[i];
		  }
		  
		  return revers.toString();
	}

}
