package fr;

import fr.poleemploi.FrenchToJavanais;

public class FrenchToJavanaisImpl implements FrenchToJavanais {
	private static final String AV = "av";
	private static final String VOYELLE = "aeiouy";
	private static final String CONSONNE = "bcdfghjklmnpqrstvwxz";
	
	public String transformFrenchToJavanais(String phrase) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		char letter = phrase.charAt(0);
		if(isVoyelle(letter)){
			sb.append(AV).append(letter);
			i = 1;
		}
		
		while (i < phrase.length()) {
			letter = phrase.charAt(i);
			
			sb.append(letter);
			if(i != phrase.length()-1 && isConsonne(letter) && isVoyelle(phrase.charAt(i+1))){
				sb.append(AV);
			}
			
			i++;
		}
		
		return sb.toString();
	}

	public String transformJavanaisToFrench(String phrase) {
		StringBuilder sb = new StringBuilder();
		
		return phrase.replaceAll(AV, "");
	}
	
	private boolean isVoyelle(char letter){
		
		return VOYELLE.contains(String.valueOf(letter));
	}
	
	private boolean isConsonne(char letter){
		
		return CONSONNE.contains(String.valueOf(letter));
	}
}
