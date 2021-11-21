import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class PizzaResults {
	
	public static void printResults() {
		//PizzaModel pizzaModel = new PizzaModel();
		List<int[]> pizzaSlices = PizzaModel.getPizzaSlices();
		int slices = PizzaModel.getPizzaSliceCount();
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("PizzaSlices.txt");
		} catch (IOException e) {
			//  catch block
			e.printStackTrace();
		}
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println (slices);
		int j = 0;
		while (pizzaSlices.size() > j) {
			int[] slice = pizzaSlices.get(j);
			//printWriter.println(Arrays.toString(slice));
			for (int i = 0; i < slice.length; i++) {
				printWriter.print(slice[i]);
				printWriter.print(" ");
				}
			printWriter.print("\n");
			j++;
		}
		printWriter.close();
		
		
	}
}
