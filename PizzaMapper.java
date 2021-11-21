
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*Google Hash Code 2018 Sample Problem
  Pizza Cutter by Darragh Merrick, Ireland - February 2018
  The class PizzaMapper.class reads the Pizza target data and sets size of the pizza and slice parameters;
  - Number of Rows
  - Number of Columns
  - Minimum of each ingredient per slice
  - Maximum cells per slice (A cell is one ingedient 'T' or 'M')
  The first line of the file lists this variables
  Then the file is scanned and each value saved in a matrix for Pizza slicing
*/
public class PizzaMapper {
    public PizzaModel pizzaModel = new PizzaModel();
    
	//Initialize all Pizza parameters;
	private int rows = 0;
	private int columns = 0;
	private int ingredientsPerSlice = 0;
	private int maxCellsPerSlice = 0;
	public char[][] pizzaMatrix;

	public PizzaMapper() {
		// TODO Auto-generated constructor stub
	}

	public void PizzaScan(String filename) throws IOException {
		pizzaModel.setPizzaData(filename);
		FileWriter fileWriter = new FileWriter("PizzaSlices.txt");
	    
		
		try {
			File file = new File( pizzaModel.getPizzaData());
			
			try (Scanner scanner = new Scanner(file)) {
				this.rows = scanner.nextInt();
				pizzaModel.setRows(rows); 
				this.columns = scanner.nextInt();
				pizzaModel.setColumns(columns); 
				this.ingredientsPerSlice = scanner.nextInt();
				pizzaModel.setIngredientsPerSlice(ingredientsPerSlice); 
				this.maxCellsPerSlice = scanner.nextInt();
				pizzaModel.setMaxCellsPerSlice(maxCellsPerSlice); 
				//Set the size of the matrix to the column & row size specified in the file
				this.pizzaMatrix = new char[pizzaModel.getRows()][pizzaModel.getColumns()];
				
                // The program will scan cells down rows (Top to Bottom)
				// Then move to next column (left to Right) and repeat until there are no more columns
				PrintWriter printWriter = new PrintWriter(fileWriter);
				// i = columns (horizontal)
				// j = rows (vertical)
				//Co-ordinates = (i,j)
				int i = 0;
				while ( scanner.hasNext() && i < pizzaModel.getRows()) {
					String str = scanner.next();
					
					for ( int j =0; j < pizzaModel.getColumns(); j++) {
						char ingredient = str.charAt(j);
						//this.currentCell[i][j] = ingredient;
						pizzaMatrix[i][j] = ingredient;
						printWriter.println ("The cell "+i+j +" is a "+ pizzaMatrix[i][j]);
					}
					i++;
				}
				pizzaModel.setPizzaMatrix(pizzaMatrix);
				printWriter.println ("The entire pizzaMatrix: "+ pizzaModel.getPizzaMatrix());
				printWriter.close();
			}
		} catch(Exception e) {}
	}

	public void debug() {
		System.out.println("Number of Rows: " + pizzaModel.getRows());
		System.out.println("Number of Columns: " +  pizzaModel.getColumns());
		System.out.println("Minimum number of Ingredients per slice: " +  pizzaModel.getMinIngredients());
		System.out.println("Maximum Cells per slice: " +  pizzaModel.getMaxCellsPerSlice());
	}

	public void pizzaSlicer() {
		char[] tempSlice;
		int sliceCount =0;
		int a=0; //Start row of pizza slice
		int b=0; //Start column of pizza slice
		int c=0; //End row of pizza slice
		int d=0; //End column of pizza slice
		int intTempSlice = 0;
		int cellCount = 1;
		
		
		char[][] pizzaMatrix = pizzaModel.getPizzaMatrix();
		int rows = pizzaModel.getRows();
		int maxCells = pizzaModel.getMaxCellsPerSlice();
		int columns = pizzaModel.getColumns();
		int fullSlice = pizzaModel.getMaxCellsPerSlice();
		int halfSlice = pizzaModel.getMaxCellsPerSlice()/2;
		int j =0;
		tempSlice = new char[maxCells];
		boolean result = false;
		
		while (j < columns )  {
		for ( int i =0; i < rows; i++) {
				result=false;
				if (intTempSlice == maxCells){
					cellCount=1;
				    intTempSlice=0;
				    tempSlice = new char[maxCells];
					
				}
				char ingredient = pizzaMatrix[i][j];
				tempSlice[intTempSlice] = ingredient;
				if (intTempSlice == 0){
					a=i; b=j;}
				if (cellCount == halfSlice || cellCount== fullSlice){
			   result = sliceChecker(tempSlice, j);
			
				if (result==true) {
				sliceCount++;
				pizzaModel.setPizzaSliceCount(sliceCount);
			    c=i; d=j;
			    int[] pizzaSlice = {a,b,c,d};
			    pizzaModel.setPizzaSlices(pizzaSlice);
			  
			   cellCount=1;
			    intTempSlice=0;
			    tempSlice = new char[maxCells];
				}
				
				}
				
				if (result == false){
					intTempSlice++;
			        cellCount++;
				}
		 }
		j++;}
		}
	
	

	public boolean sliceChecker(char[] tempSlice, int j) {
		String slice = new String(tempSlice);
		int lastRow = (pizzaModel.getColumns()-2);
		if (slice.contains("T") && slice.contains("M") && j!=lastRow) {
		    return true;
		    
		}
		else {
		return false;
		
		
		}
		}
	
}
