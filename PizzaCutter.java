

public class PizzaCutter {
	char[] tempSlice;
	int sliceCount =0;
	int a=0; //Start row of pizza slice
	int b=0; //Start column of pizza slice
	int c=0; //End row of pizza slice
	int d=0; //End column of pizza slice
	int cellCount = 0;
	
	
	public void pizzaSlicer() {
		PizzaModel pizzaModel = new PizzaModel();
		char[][] pizzaMatrix = pizzaModel.getPizzaMatrix();
		int rows = pizzaModel.getRows();
		int maxCells = pizzaModel.getMaxCellsPerSlice();
		int columns = pizzaModel.getColumns();
		int fullSlice = pizzaModel.getMaxCellsPerSlice();
		int halfSlice = pizzaModel.getMaxCellsPerSlice()/2;
		int j =0;
		tempSlice = new char[maxCells];
		
		while ( j <= columns) {
			
			for ( int i =0; i < rows; i++) {
				
				char ingredient = pizzaMatrix[i][j];
				tempSlice[cellCount] = ingredient;
				if (cellCount == 0){
					a=i; b=j;}
				if (cellCount == (halfSlice|fullSlice)){
				boolean result = sliceChecker(tempSlice);
			
				if (result==true) {
				sliceCount++;
				pizzaModel.setPizzaSliceCount(sliceCount);
			    c=i; d=j;
			 
			
			    cellCount=0;
				}
				if (result==false)  {	
				cellCount++;
				}
			}
			}
			j++;
			cellCount++;
		}
	
	}

	private boolean sliceChecker(char[] tempSlice) {
		String slice = new String(tempSlice);
		if (slice.contains("T") && slice.contains("M")) {
		    return true;
		    
		}
		else {
		return false;
		
		}
		}
	}
	
