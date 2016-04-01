

import java.util.Random;
// No other import statement is allowed

public class Maze
{
	Container[][] plane;
        int fullWidth;
        int fullHeight;
        int random;
	
	/**
	 * Constructor
	 * @param aWidth th
         * e number of chambers in each row
	 * @param aHeight the number of chamber in each column
	 */
	public Maze(int aWidth, int aHeight)
	{
            //variables given required values
                fullWidth = aWidth;
                fullHeight = aHeight;
                Random rand = new Random();
                
               
                
		plane = new Container[fullHeight][fullWidth];
                
                //Filling the maze with Pair objects
                for(int x = 0; x < fullHeight; x++){
                    for(int y = 0; y < fullWidth; y++){
                        Container c = new Container(x,y);
                        plane[x][y] = c;
                    
                    }
                }
                
                //draw maze
                generateMaze(fullWidth,fullHeight,0,0);
                
                
                
                
	}

	/**
	 * getWidth
	 * @return the width of this maze
	 */
	public int getWidth()
	{
		return fullWidth;
	}
	
	/**
	 * getHeight
	 * @return the height of this maze
	 */
	public int getHeight()
	{
		return fullHeight;
	}
	
	/**
	 * isNorthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a north wall. Otherwise, return false
	 */
	public boolean isNorthWall(int row, int column)
	{
		if(row == 0){
                    return true;
                }
                
                if(plane[row][column].getNorthWall() == true){
                    return true;
                }
                
                return false;
	}
	
	/**
	 * isEastWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain an east wall. Otherwise, return false
	 */
	public boolean isEastWall(int row, int column)
	{
		if(column == fullWidth-1){
                    return true;
                }
                
                 if(plane[row][column+1].getWestWall() == true){
                    return true;
                }
                
                return false;
	}
	
	/**
	 * isSouthWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a south wall. Otherwise, return false
	 */
	public boolean isSouthWall(int row, int column)
	{
		if(row == fullHeight-1){
                    return true;
                }
                
                if(plane[row+1][column].getNorthWall() == true){
                    return true;
                }
                return false;
	}
	
	/**
	 * isWestWall
	 * @param row the row identifier of a chamber
	 * @param column the column identifier of a chamber
	 * @return true if the chamber at row row and column column
	 * contain a west wall. Otherwise, return false
	 */
	public boolean isWestWall(int row, int column)
	{
		if(column == 0){
                    return true;
                }
                
                if(plane[row][column].getWestWall() == true){
                    return true;
                }
                return false;
	}
        
        
        
        
        
        
        
        
        
        
        
        
        //maze generation starts here
        
        
        
        //draw maze lines
        public void generateMaze(int maxX,int maxY ,int minX,int minY){
           
            int ChamberWidth = maxX-minX;
            int ChamberHeight = maxY-minY;
        
        
           
        if(ChamberWidth > 1 && ChamberHeight > 1){
            //declare variables
            int locationX = 0;
            int locationY = 0;
            boolean breaker = false;
            
           
            
            
            //make sure values do not equal zero 
            while(breaker == false){
            locationX = (int)(Math.random()*(maxX));
            locationY = (int)(Math.random()*(maxY));
            
            if(locationX > minX && locationY > minY){
                breaker = true;
            }
             
            }
            
         
            
            
            
            
            //generate 3 random numbers between 1 and 4
            //this is to decide which ones get holes in the wall
            //do loops are to prevent repeats
             int firstWall = (int) (Math.random()*4);
             int secondWall;
             int thirdWall;
             
             do{
             secondWall = (int) (Math.random()*4);
             }
             while(secondWall == firstWall);
             
             do{
             thirdWall = (int) (Math.random()*4);
             }while(thirdWall == firstWall || thirdWall == secondWall);
             
             ;
   
       //wall 1 code 
            
            
            //testing location values
            
            
            //creating temporary variables 
            int tempX = locationX;
            int tempY = locationY;
            
            
            
            
           
            
            //generate value for removal
            int randHole0;
               do{
                    randHole0 = (int)(Math.random()*(maxX));
                }while(randHole0 < tempX);
               
            //if wall not to remove set value to negative1
                if(firstWall == 0 || secondWall == 0 || thirdWall == 0){
                    //do nothing
                }
                else{
                    randHole0 = -1;
                }
            
            
            //draw first wall with hole if randnum is selected
            while(tempX < maxX){
                
                if(tempX != randHole0){
                plane[locationY][tempX].setNorthWall(true);
                }
                
                tempX++;
            }
         
            //end wall 1 code
            
            
            
            
            
            
       //wall 2 code
            
            //reset variables
            tempX = minX;
            tempY = locationY;
            
            //generate value for removal
            int randHole1;
               do{
                    randHole1 = (int)(Math.random()*(maxX));
                    
                }while(randHole1 > locationX-1 || randHole1 < minX);
           
            
                //if wall not to remove set value to negative1
                if(firstWall == 1 || secondWall == 1 || thirdWall == 1){
                    //do nothing
                }
                else{
                    randHole1 = -1;
                }
            
            
            //draw second wall with hole if randnum is selected
            while(tempX < locationX){
                
                if(tempX != randHole1){
                plane[locationY][tempX].setNorthWall(true);
                }
                tempX++;
            }
       
            //end wall 2 code
            
             
             
             
             
      //wall 3 code
        
            //reset variables 
            tempX = locationX;
            
            tempY = minY;
            
            
            //generate value for removal
            int randHole2;
               do{
                    randHole2 = (int)(Math.random()*(maxY));
                }while(randHole2 > locationY-1 || randHole2 < minY);
               
                //if wall not to remove set value to negative1
                if(firstWall == 2 || secondWall == 2 || thirdWall == 2){
                    //do nothing
                }
                else{
                    randHole2 = -1;
                }
                    
            // draw third wall with hole if randnum is selected
            while(tempY < locationY){
                  
                if(tempY != randHole2){
                plane[tempY][locationX].setWestWall(true);
                }
                
                tempY++;
            }
            
        //end wall 3 code 
             
         //Wall 4 code
            
            //reset variables
            tempX = locationX;
            tempY = locationY;
            
            //generate value for removal
            int randHole3;
               do{
                    randHole3 = (int)(Math.random()*(maxY));
                    
                }while(randHole3 < tempY);
               
               
            
                //if wall not to remove set value to negative1
                if(firstWall == 3 || secondWall == 3 || thirdWall == 3){
                    //do nothing
                }
                else{
                    randHole3 = -1;
                }
            
              
            // draw fourth wall with hole if randnum is selected
              while(tempY < maxY){
                
                if(tempY != randHole3){
                plane[tempY][locationX].setWestWall(true);
                }
               
              
                
                tempY++;
            }
              
       //end wall 4 code       
        
         
         
          //4 recursive steps
          
          
        
    generateMaze(locationX,locationY,minX,minY); 
    generateMaze(maxX,locationY,locationX,minY);  
    generateMaze(locationX,maxY,minX,locationY);
    generateMaze(maxX,maxY,locationX,locationY);
          
          }
          
          
          }
             
       
        
        
        
        
        
        
        
        
        
        
        
        
   public class Container<T1,T2>{
          private T1 first;
	private T2 second;
        private boolean north = false, south = false, east = false, west = false;
	
	public Container(T1 aFirst, T2 aSecond)
	{
		first = aFirst;
		second = aSecond;
	}
	
	/* Gets the first element of this pair.
	 * @return the first element of this pair.
	 */
	public T1 fst()
	{
		return first;
	}
	
	/* Gets the second element of this pair.
	 * @return the second element of this pair.
	 */
	public T2 snd()
	{
		return second;
	}
	
	/* Generates a string representing this pair. Note that
	 * the String representing the pair (x,y) is "(x,y)". There
	 * is no whitespace unless x or y or both contain whitespace
	 * themselves.
	 * @return a string representing this pair.
	 */
          @Override
	public String toString()
	{
		return "(" + first + "," + second + ")";
	}
        
        //methods to set and get north, south, east and west walls
        public boolean getWestWall(){
            return west;
        }
         public boolean getEastWall(){
            return east;
        }
         public boolean getNorthWall(){
            return north;
        }
          public boolean getSouthWall(){
            return south;
        }
          
        public void setNorthWall(boolean b){
            north = b;
        }
        public void setSouthWall(boolean b){
            south = b;
        }
          public void setEastWall(boolean b){
              east = b;
        }
         public void setWestWall(boolean b){
             west = b;
        }
        
      
      }       
             
             
       
}
