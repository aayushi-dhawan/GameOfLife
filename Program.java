public class Program
{
    public static void main(String[] args) {        
        System.out.println("This is the Game of Life");       
        GameOfLife objGol = new GameOfLife(25,25);
        // objGol.setLivingCell(0,15); 
        // objGol.setLivingCell(0,16);  
        // objGol.setLivingCell(0,17);  
        // objGol.setLivingCell(1,16); 
        
        objGol.setLivingCell(11,15);
        objGol.setLivingCell(12,16);
        objGol.setLivingCell(13,14);
        objGol.setLivingCell(13,15);
        objGol.setLivingCell(13,16);  

        // objGol.setLivingCell(23,15); 
        // objGol.setLivingCell(23,16);          
        // objGol.setLivingCell(24,16);  
        // objGol.setLivingCell(24,17);  
        
        for(int i = 1; i< 6; i++) {
            System.out.println("Gen" + i);  
            objGol.deriveNextGeneration();
        }

        // GameOfLifeWrapper objGolW = new GameOfLifeWrapper(25,25);
        // objGolW.setLivingCell(0,15); 
        // objGolW.setLivingCell(0,16);  
        // objGolW.setLivingCell(0,17);  
        // objGolW.setLivingCell(1,16); 

        // objGolW.setLivingCell(11,15);
        // objGolW.setLivingCell(12,16);
        // objGolW.setLivingCell(13,14);
        // objGolW.setLivingCell(13,15);
        // objGolW.setLivingCell(13,16); 

        // objGolW.setLivingCell(23,15); 
        // objGolW.setLivingCell(23,16);          
        // objGolW.setLivingCell(24,16);  
        // objGolW.setLivingCell(24,17);      
         
        // for(int i = 1; i< 6; i++) {
        //     System.out.println("Gen" + i);  
        //     objGolW.deriveNextGeneration();
        // }
    }    
}