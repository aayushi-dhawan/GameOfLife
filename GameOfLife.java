public class GameOfLife { 

    private final static int DEAD_VAL = 0;
    private final static int LIVING_VAL = 1;    
    private final static int DEAD_STATE_CHANGE_VAL = 2;
    private final static int LIVING_STATE_CHANGE_VAL = -1;

    private final int[][] board;

    public GameOfLife(int rowCount, int columnCount) {
        board = new int [rowCount][columnCount];        
    }

    public void setLivingCell(int row, int column) {
        board[row][column] = LIVING_VAL;
    }

    public void deriveNextGeneration() {
        int rowCount = board.length;        
        if(rowCount == 0)
        {
            System.out.print("Empty Board");
            return;
        }	
        int colCount = board[0].length;	
        int count = 0;
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++){
            for(int colIndex = 0; colIndex < colCount; colIndex++){
                count = checkNeighborsCount(rowIndex,colIndex, rowCount, colCount);
                applyRuleForLivingCell(rowIndex, colIndex, count);
                applyRuleForDeadCell(rowIndex, colIndex, count);
            }
        }      
        applyStateChangedValues(rowCount, colCount);
        printBoard(board);
    }

    private int checkNeighborsCount(int rowIndex, int colIndex,int rowCount, int colCount)
    {
        int count = 0;
        int r = 0;
        int c = 0;
        for(int row=-1; row<2; row++)
        {
            for(int col=-1; col<2; col++)
            {
                r = rowIndex + row;
                c = colIndex + col;
                if((r != rowIndex || c != colIndex) && (isValidCoordinate(r,c,rowCount, colCount) && (board[r][c] == LIVING_VAL || board[r][c] == LIVING_STATE_CHANGE_VAL))) {
                    count++; 
                }   
            }
        }
        return count;
    }

    private boolean isValidCoordinate(int row, int col, int rowCount, int colCount)
    {
        if(row < 0 || row >= rowCount || col < 0 || col >= colCount) {
            return false;       
        }
        return true;
    }
  
    private void applyRuleForLivingCell(int rowIndex,int colIndex,int count) {
         if(board[rowIndex][colIndex] == LIVING_VAL && (count < 2 || count > 3)){
            board[rowIndex][colIndex] = LIVING_STATE_CHANGE_VAL;
        }
    }

    private void applyRuleForDeadCell(int rowIndex,int colIndex,int count) {
         if(board[rowIndex][colIndex] == DEAD_VAL && count == 3){
            board[rowIndex][colIndex] = DEAD_STATE_CHANGE_VAL;
        }
    }

    private void applyStateChangedValues(int rowCount, int colCount)
    {          
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++){
            for(int colIndex = 0; colIndex < colCount; colIndex++){
                if(board[rowIndex][colIndex] == LIVING_STATE_CHANGE_VAL){
                    board[rowIndex][colIndex] = DEAD_VAL;
                }
                else if(board[rowIndex][colIndex] == DEAD_STATE_CHANGE_VAL){
                    board[rowIndex][colIndex] = LIVING_VAL;
                }
            }
        }
    }

    private void printBoard(int[][] board) {        
        int numRows = board.length;
        int numCols = board[0].length;
        for(int rowIndex = 0; rowIndex< numRows; rowIndex++) 
        {
            for(int colIndex = 0;colIndex < numCols; colIndex++) 
            {
                if(board[rowIndex][colIndex] == LIVING_VAL)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }    
}
