package edu.jsu.mcis;

import javafx.scene.shape.TriangleMesh;

/* start here */
public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3; /* ask about final modifier*/ 
    
    /* Mark (represents X, O, or an empty square) */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) { /* this Mark is a constructor*/
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE BELOW*/ 
      
        grid = new Mark[width][width];
        
        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE BELLOW*/ 

        for (int i = 0; i < width; i++) {  
            for (int j = 0; j< width; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }    
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */ //we have to use the two methods below to do this
        
        /* INSERT YOUR CODE HERE BELOW*/
        
        /*if(isValidSquare(row, col) && !isSquareMarked(row, col)){
            if(xTurn){
                grid[row][col] = Mark.X;
            } else {
                grid[row][col] = Mark.O;
            }
            xTurn = !xTurn;
            return true;
        }*/
        
        if(isValidSquare(row, col) && !isSquareMarked(row, col) && xTurn) { 
            grid[row][col] = Mark.X;
            xTurn = !xTurn;
            return true;
       } else if(isValidSquare(row, col) && !isSquareMarked(row, col) && !xTurn){
            grid[row][col] = Mark.O;
            xTurn = !xTurn;
            return true;     
       }

    return false;
        //return false; /* remove this line! */
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE BELOW*/

        if(0 <= row && row < width && 0 <= col && col < width) {
           return true;
        }
        
       
        return false; /* remove this line! */
        
    } 
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE BELOW*/
        
            if(grid[row][col] == Mark.EMPTY) {
                return false; 
             }else {
                return true; 
             }
        //return false; /* remove this line! */
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */

        /* INSERT YOUR CODE HERE */
       return grid[row][col];

       //return null; /* remove this line! */
            
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */

        if(isMarkWin(Mark.X) == true){
            return Result.X;
        }

        if(isMarkWin(Mark.O) == true){
            return Result.O;
        }

        if(isTie() == true){
            return Result.TIE;
        }

        if(isMarkWin(Mark.X) != true && isMarkWin(Mark.O) != true && isTie() != true ){
            return Result.NONE;
        } 
        
        return Result.NONE;

        //return null; /* remove this line! */

    }
	
    private boolean isMarkWin(Mark mark) { //boolean is the return type
        
        /* Check the squares of the board to see if the specified mark is the
           winner */

           //for loop to check horizontally 
           // for loop check vertically 
           //for loop check diagonally
           //have a count that 
        
        /* INSERT YOUR CODE HERE */

       
       int counter = 0;

        //check row

         for (int i = 0; i < width; i++) {  
            for (int j = 0; j< width; j++) {
                if(grid[i][j] == mark){
                counter++;}
            }
            if (counter == width){
                return true;
            } else {
                counter = 0;}
        }    

        //check col

        for (int i = 0; i < width; i++) {  
            for (int j = 0; j< width; j++) {
                if(grid[j][i] == mark){
                counter++;}
            }
            if (counter == width){
                return true;
            } else {
                counter = 0;}
        }   

        //check diag top left
        
        for (int i = 0; i < width; i++) {
            if (grid[i][i] == mark) {
                counter++;
            }
        }
        if (counter == width) {
            return true;
        } else {
            counter =0;
        }


        //check diag bottom left
        
         for (int i = 0; i < width; i++) {  
                if(grid[i][width-i-1] == mark){
                    counter ++;
                    }
            }
            if(counter == width){
                return true;
            }

        return false; /* remove this line! */
    }
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        
        for(int i = 0; i < width; i++){
            for (int j = 0; j< width; j++) {
                if(grid[i][j] == Mark.EMPTY) {
                    
                    return false;
                } 
            }
        }
        return true;
                
        //return false; /* remove this line! */
    }
    

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}