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


    //main method for testing
    public static void main( String[] args ) {

    }

}//end class Matrix
