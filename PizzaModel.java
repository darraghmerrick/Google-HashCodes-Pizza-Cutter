import java.util.ArrayList;
import java.util.List;

/* Google Hash Code 2018 Sample Problem
   Pizza Cutter by Darragh Merrick, Ireland - February 2018
   The class PizzaModel.class creates data objects which can be referenced from any class
 */

public class PizzaModel {
	
	public String pizzaData;
	public int columns;
	public int rows;
	public int ingredientsPerSlice;
	public int maxCellsPerSlice;
	public static int sliceCount;
	public char[][] pizzaMatrix;
	public static List<int []> pizzaSlices = new ArrayList<int []>();

	
	
	//Getter & setter for the entire Pizza
	public void setPizzaData(String pizzaData) {
		this.pizzaData = pizzaData;	}

	public String getPizzaData() {
		return pizzaData; }
	
	// Getter and setter for columns
	public void setColumns(int columns) {
		this.columns = columns; }

	public int getColumns() {
		return columns;}
	
	// Getter and setter for rows
	public void setRows(int rows) {
	this.rows = rows;}

	public int getRows() {
		return rows;}
	
	// Getter and setter for minumum ingredients per slice
	public void setIngredientsPerSlice(int ingredientsPerSlice) {
		this.ingredientsPerSlice = ingredientsPerSlice;	}

	public int getMinIngredients() {
		return ingredientsPerSlice;}
	
	// Getter and setter for maximum cells per slice
	public void setMaxCellsPerSlice(int maxCellsPerSlice) {
		this.maxCellsPerSlice = maxCellsPerSlice;}

	public int getMaxCellsPerSlice() {
		return maxCellsPerSlice;}

	// Getter and setter for pizza Matrix
	public void setPizzaMatrix(char[][] pizzaMatrix) {
		this.pizzaMatrix= pizzaMatrix;}
	
	public char[][] getPizzaMatrix() {
		return pizzaMatrix;}
	
	// Getter and setter for pizza slice storage
		public void setPizzaSlices(int[] pizzaSlice) {
			PizzaModel.pizzaSlices.add(pizzaSlice);}
		
		public static List<int []> getPizzaSlices() {
			return pizzaSlices;}
		
		// Getter and setter for number of slices cut
		public void setPizzaSliceCount(int sliceCount) {
			PizzaModel.sliceCount = sliceCount;}
		
		public static int getPizzaSliceCount() {
			return sliceCount;}
	
}
