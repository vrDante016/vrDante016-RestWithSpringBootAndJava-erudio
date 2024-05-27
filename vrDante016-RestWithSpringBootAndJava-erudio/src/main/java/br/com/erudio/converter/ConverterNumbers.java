package br.com.erudio.converter;

public class ConverterNumbers {

	
	public ConverterNumbers() {
		
	}
	
	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
			
		
		
	}
	public double convertNumber(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(number)) return Double.parseDouble(strNumber);
		return 0D;
}

}
