package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converter.ConverterNumbers;
import br.com.erudio.exception.MetodoMatematicoNaoSuportado;

@RestController
public class Calculadora{
	
	private final AtomicLong counter = new AtomicLong();
	ConverterNumbers converterNumbers = new ConverterNumbers();
	

	@RequestMapping(value = "/calculator/{numberOne}/{escolhaOmetodo}/{numberTwo}/", method=RequestMethod.GET)
	public Double calculator(
		@PathVariable(value = "numberOne") String numberOne,
		@PathVariable(value = "numberTwo") String numberTwoS,
		@PathVariable(value = "escolhaOmetodo") String escolhaOmetodo
		) throws Exception
	{
		if(!converterNumbers.isNumeric(numberOne)|| !converterNumbers.isNumeric(numberTwoS) )
		{
			throw new MetodoMatematicoNaoSuportado("O VALOR NÃO É NUMERICO");
		}
		try {
			if(escolhaOmetodo.equals("+")){ 
				return converterNumbers.convertNumber(numberOne) + converterNumbers.convertNumber(numberTwoS);		
			}else if(escolhaOmetodo.equals("-")) {
				return converterNumbers.convertNumber(numberOne) - converterNumbers.convertNumber(numberTwoS);		
			}
			else if("%".equals(escolhaOmetodo)) {
				return converterNumbers.convertNumber(numberOne) % converterNumbers.convertNumber(numberTwoS);
			}
			else if(escolhaOmetodo.equals("*")) {
				return converterNumbers.convertNumber(numberOne) * converterNumbers.convertNumber(numberTwoS);			
			}
			
		}
		catch (MetodoMatematicoNaoSuportado e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@RequestMapping(value = "/sqr/{number}", method=RequestMethod.GET)
	public Double SquareRoot(
			@PathVariable(value = "number") String number
			) {
		if(!converterNumbers.isNumeric(number)) {
			throw new MetodoMatematicoNaoSuportado("o valor não é numerico");
		}
		try {
			return Math.sqrt(converterNumbers.convertNumber(number));
		}
		catch (MetodoMatematicoNaoSuportado e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	

}
