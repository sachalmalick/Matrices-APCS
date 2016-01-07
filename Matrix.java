/*
Shantanu Jha
APCS1 pd5
HW54--Red vs Blue
2016-01-06
*/

/*====================================
  class Matrix -- models a square matrix

  TASK: Implement methods below.
        Categorize runtime of each. 
        Test in your main method.
  ====================================*/ 

public class Matrix {

    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;


    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
        matrix = new Object [2][2];
    }//O(1)


    //constructor intializes an a*a matrix
    public Matrix( int a ) {
        matrix = new Object[a][a];
    }//O(1)


    //return size of this matrix, where size is 1 dimension
    private int size() {
        return matrix.length;
    }//O(1)


    //return the item at the specified row & column   
    private Object get( int r, int c ) {
        return matrix[r][c];
    }//O(1)


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) {
        return matrix[r][c] == null;
    }//O(1)


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) {
        Object temp = matrix[r][c];
        matrix[r][c] = newVal;
        return temp;
    }//O(1)


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() {
        String s = "";
        for(int i = 0; i < size(); i++){
            for(int j = 0; j < size(); j++){
                s += get(i,j) + " ";
            }
            s.substring(0, s.length() - 1);
            s += "\n";
        }
        s.substring(0,s.length()-1);
        return s; 
    } //O(n^2)


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Matrix other ) {
        if(other.size() != this.size()) return false;
        for(int i = 0; i < this.size(); i++){
            for(int j = 0; j < this.size(); j++){
                if(!(this.get(i,j).equals(other.get(i,j)))) return false;
            }
        }
        return true;
    }//O(n^2)


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) {
        Object temp;
        for(int i = 0; i < size(); i++){
            temp = matrix[i][c1];
            matrix[i][c1] = matrix[i][c2];
            matrix[i][c2] = temp;
        }
    }//O(n)

    public void transpose(){
        for(int i =0; i < size(); i++){
            for(int j=0; j< size(); j++){
                swap(i,j,j,i);
            }
        }
    }

    public void swap(int r1, int r2, int c1, int c2){
        Object temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }

    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) {
        Object temp;
        for(int i = 0; i < size(); i++){
            temp = matrix[r1][i];
            matrix[r1][i] = matrix[r2][i];
            matrix[r2][i] = temp;
        }
    }//O(n)


    public boolean isFull() {
    	for (Object[] s: matrix) {
    		for (Object a: s) {
    			if (a == null){
    				return false;
    			}
    		}
    	}
    	return true;
    }

    public Object[] getRow( int r ) {
    	Object [] temp = new Object[matrix[r].length];
    	for (int i = 0; i < matrix[r].length;i++) {
    		temp[i] = matrix[r][i];
    	}
    	return temp;
    }
    public Object[] setRow( int r, Object[] newRow ) {
    	Object [] temp = new Object[matrix[r].length];
    	for (int i = 0; i < matrix[r].length;i++) {
    		temp[i] = matrix[r][i];
    	}
    	int len = 0;
    	if (newRow.length < matrix[r].length) {
    		len = newRow.length;
    	}
    	else {
    		len = matrix.length;
    	}
    	for (int a = 0; a < newRow.length;a++) {
    		matrix[r][a] = newRow[a];
    	}
    	return temp;
    	
    	
    }
    public Object[] setCol( int c, Object[] newCol ) {
    	Object [] temp = new Object[matrix.length];
    	for (int i = 0; i < matrix.length;i++) {
    		temp[i] = matrix[i][c];
    	}
    	int len = 0;
    	if (newCol.length < matrix.length) {
    		len = newCol.length;
    	}
    	else {
    		len = matrix.length;
    	}
    	for (int a = 0; a < len;a++) {
    		matrix[a][c] = newCol[a];
    	}
    	return temp;
    	
    }
	
	public Object[] getCol( int c ) {
		Object [] temp = new Object[matrix.length];
    	for (int i = 0; i < matrix.length;i++) {
    		temp[i] = matrix[i][c];
    	}
		return temp;
	}
    public boolean contains( Object o ) {
		for (Object [] s: matrix) {
			for (Object a: s) {
				if (a.equals(o)) {
					return true;
				}
			}
		}
		
		return false;
	}

    //main method for testing
    public static void main( String[] args ) {
    	Matrix s = new Matrix(4);
    	System.out.println(s);
    	
    	 for (int i = 0; i < s.matrix.length;i++) {
    		 for (int j = 0; j < s.matrix[i].length;j++) {
    			 s.matrix[i][j] = (Integer)(int)(Math.random()*5);
    		 }
    	 }
    	 
     	System.out.println(s);
     	s.set(0,0,0);
     	System.out.println(s);
     	
     	Matrix t = new Matrix(4);
     	for (int i = 0; i < t.matrix.length;i++) {
   		 for (int j = 0; j < t.matrix[i].length;j++) {
   			 t.matrix[i][j] = s.matrix[i][j];
   		 }
   	 }
     	
     System.out.println(t);
     System.out.println(s.equals(t));
     
     s.swapRows(0, 1);
     System.out.println(s);

     s.swapColumns(0, 1);

     System.out.println(s.isFull());
	 
	 

     //System.out.println(t.equals(s));

//TEST CASES FOR NEW METHODS
     
     Object[] hello = {1,2,3,4,5,6};
     s.setCol(0,hello);
     System.out.println(s);
	 System.out.println(s.getCol(0));
	 System.out.println(s.contains(0));
	 System.out.println(s.contains(100));
	 s.transpose();
	 System.out.println(s);

    }

}//end class Matrix
