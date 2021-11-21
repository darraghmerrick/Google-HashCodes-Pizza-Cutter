import java.io.IOException;

public class Main {
	 
	
	public static void main (String [] args) throws IOException {
		String file = "./in/big.in";
		
		PizzaMapper pizzaMapper =  new PizzaMapper();

		pizzaMapper.PizzaScan(file);
		pizzaMapper.debug();
		pizzaMapper.pizzaSlicer();
		//PizzaCutter pizzaCutter = new PizzaCutter();
		//pizzaCutter.pizzaSlicer();
		
		
		PizzaResults.printResults();
	}

}
