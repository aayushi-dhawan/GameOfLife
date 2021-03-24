//Takes care of edges for example - first column left neigbours are last column and similar logic for rows
public class GameOfLifeWrapper { 

    private final static int DEAD_VAL = 0;
    private final static int LIVING_VAL = 1;    
    private final static int DEAD_STATE_CHANGE_VAL = 2;
    private final static int LIVING_STATE_CHANGE_VAL = -1;

    private final int[][] board;

    public GameOfLifeWrapper(int rowCount, int columnCount) {
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
                count = checkNeighboursCount(rowIndex,colIndex, rowCount, colCount);
                applyRuleForLivingCell(rowIndex, colIndex, count);
                applyRuleForDeadCell(rowIndex, colIndex, count);
            }
        }      
        applyStateChangedValues(rowCount, colCount);
        printBoard(board);
    }

    private int checkNeighboursCount(int rowIndex, int colIndex,int rowCount, int colCount)
    {
        int count = 0;
        int r = 0;
        int c = 0;
        for(int row=-1; row<2; row++)
        {
            for(int col=-1; col<2; col++)
            {
                r = (rowIndex + row + rowCount) % rowCount; 
                c = (colIndex + col + colCount) % colCount;
                
                if((r != rowIndex || c != colIndex) && (board[r][c] == LIVING_VAL || board[r][c] == LIVING_STATE_CHANGE_VAL)) {
                    count++; 
                }   
            }
        }
        return count;
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
