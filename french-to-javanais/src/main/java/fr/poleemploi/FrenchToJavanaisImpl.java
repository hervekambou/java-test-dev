package fr.poleemploi;



public class FrenchToJavanaisImpl implements FrenchToJavanais {
	private static final String AV = "av";
	private static final String VOYELLE = "aeiouy";
	private static final String CONSONNE = "bcdfghjklmnpqrstvwxz";
	private static final String EMPTY = "";
	private static final String SPACE = " ";
	private static final String DOUBLE_SPACE = "  ";
	
	public String transformFrenchToJavanais(String phrase) {
		StringBuilder sb = new StringBuilder();
		phrase =  phrase.toLowerCase();
		String [] mots = phrase.replaceAll(DOUBLE_SPACE, SPACE).split(SPACE);
		int idMot = 0;
		
		for (String mot : mots) {
			int i = 0;
			char letter = mot.charAt(0);
			if(isVoyelle(letter)){
				sb.append(AV).append(letter);
				i = 1;
			}
			
			while (i < mot.length()) {
				letter = mot.charAt(i);
				
				sb.append(letter);
				if(i != mot.length()-1 && isConsonne(letter) && isVoyelle(mot.charAt(i+1))){
					sb.append(AV);
				}
				
				i++;
			}
			
			addSpace(sb, mots, idMot);
			idMot++;
		}
		
		return sb.toString();
	}

	public String transformJavanaisToFrench(String phrase) {
		StringBuilder sb = new StringBuilder();
		phrase =  phrase.toLowerCase();
		String [] mots = phrase.replaceAll(DOUBLE_SPACE, SPACE).split(SPACE);
		int idMot = 0;
		
		for (String mot : mots) {
			String resultString = new String(mot);
			
			int index = resultString.indexOf(AV);
			
			if(index == 0 && index+2 < resultString.length() && isVoyelle(resultString.charAt(index+2))){
				resultString = resultString.replaceFirst(AV, EMPTY);
			}
			
			index = 0;
			while (index < resultString.length()) {
				int indexAV = resultString.indexOf(AV, index);
				
				if(indexAV > 0 && indexAV+2 < resultString.length() 
						&& isConsonne(resultString.charAt(indexAV-1)) && isVoyelle(resultString.charAt(indexAV+2)) ){
					resultString = resultString.replaceFirst(AV, EMPTY);
					index = indexAV+2;
				} else {
					index++;
				}
				
			}
			
			sb.append(resultString);
			addSpace(sb, mots, idMot);
			idMot++;
		}
		
		return sb.toString();
	}
	
	private boolean isVoyelle(char letter){
		
		return VOYELLE.contains(String.valueOf(letter));
	}
	
	private boolean isConsonne(char letter){
		
		return CONSONNE.contains(String.valueOf(letter));
	}
	
	private void addSpace(StringBuilder sb, String [] mots, int idMot){
		if(idMot < mots.length-1){
			sb.append(SPACE);
		}
	}
}
