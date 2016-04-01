

import java.util.ArrayList;

import javax.swing.JFrame;

public class MazeFrame
{
	public static void main(String[] args) throws InterruptedException
	{
		int width = 125;
		int height = 125;
		JFrame frame = new JFrame();
		Maze maze = new Maze(width, height);
		ArrayList<Pair<Integer,Integer>> solution = new ArrayList<Pair<Integer,Integer>>();
		MazeComponent mc = new MazeComponent(maze, solution);
		frame.setSize(800,800);
		frame.setTitle("Maze");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mc);
		frame.setVisible(true);
		
		solution.add(new Pair<Integer,Integer>(0,0));
		Thread.sleep(1000);
		solveMaze(solution, mc, maze, 0,0,1);
		mc.repaint();
	}
	
	/** Solve Maze: recursively solve the maze
	 * 
	 * @param solution   : The array list solution is needed so that every recursive call,
	 *                     a new (or more) next position can be added or removed.
	 * @param mc         : This is the MazeComponent. We need that only for the purpose of
	 *                     animation. We need to call mc.repaint() every time a new position
	 *                     is added or removed. For example,
	 *                       :
	 *                     solution.add(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 *                     solution.remove(...);
	 *                     mc.repaint();
	 *                     Thread.sleep(sleepTime);
	 *                       :
	 * @param maze       : The maze data structure to be solved. 
	 * @return a boolean value to previous call to tell the previous call whether a solution is
	 *         found.
	 * @throws InterruptedException: We need this because of our Thread.sleep(50);
	 */
	public static boolean solveMaze(ArrayList<Pair<Integer,Integer>> solution, MazeComponent mc, Maze maze, int posX, int posY, int directionFrom) throws InterruptedException
	{
		//direction from 1 = north, 2 = west, 3 = south, 4 = east
		//these are the statements that move around
		
		
		boolean breaker = false;
		
		
		
		if(posX == (maze.getWidth()-1) && posY == (maze.getHeight()-1)){
			
		
			return true;
		}
		else{
			
			
		//if coming from the north
		if(directionFrom == 1){
			
			//try to go west
			if( posX != 0 && maze.isWestWall(posY,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY,posX-1));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX-1,posY,4);
				
				//backtrack
				if(breaker == false){
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
				
			}
			
			//try to go south
			if(posY != maze.getHeight()-1 && maze.isNorthWall(posY+1,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY+1,posX));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX,posY+1,1);
				
				//backtrack
				if(breaker == false){
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
				
			}
			
			//try to go east
			if(posX != maze.getWidth()-1 && maze.isWestWall(posY,posX+1) == false && breaker == false){
				solution.add(new Pair<Integer,Integer>(posY,posX+1));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX+1,posY,2);
				
				//backtrack
				if(breaker == false){
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
		
			}
			
		
						
			
		}
			
		
		
		
		//if coming from the west
if(directionFrom == 2){
			
if(posY != maze.getHeight()-1 && maze.isNorthWall(posY+1,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY+1,posX));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX,posY+1,1);
				
				//backtrack
				if(breaker == false){
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
				
				
			}

if(posX != maze.getWidth()-1 && maze.isWestWall(posY,posX+1) == false && breaker == false){
	solution.add(new Pair<Integer,Integer>(posY,posX+1));
	mc.repaint();
	Thread.sleep(10);
	
	breaker = solveMaze(solution,mc,maze,posX+1,posY,2);	
	
	//backtrack
	if(breaker == false){
	solution.remove(solution.size()-1);
	mc.repaint();
	Thread.sleep(10);
	}
	
}

			
	if(posY != 0 && maze.isNorthWall(posY,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY-1,posX));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX,posY-1,3);	
				
				if(breaker == false){
				//backtrack
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);}
				
			}
			



		
		
		
	
	
			
		
		}
		
		
		//for if coming from the south
		if(directionFrom == 3){
			
			if(posX != maze.getWidth()-1 && maze.isWestWall(posY,posX+1) == false && breaker == false){
				solution.add(new Pair<Integer,Integer>(posY,posX+1));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX+1,posY,2);
				
				if(breaker == false){
				//backtrack
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
				
			}
			
			
	if(posY != 0 && maze.isNorthWall(posY,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY-1,posX));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX,posY-1,3);	
				
				if(breaker == false){
				//backtrack
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
			}
			
	if(maze.isWestWall(posY,posX) == false && posX != 0 && breaker == false){
		
		solution.add(new Pair<Integer,Integer>(posY,posX-1));
		mc.repaint();
		Thread.sleep(10);
		
		breaker = solveMaze(solution,mc,maze,posX-1,posY,4);
		//backtrack
		if(breaker == false){
		solution.remove(solution.size()-1);
		mc.repaint();
		Thread.sleep(10);
		}
		
	}
			
		
			
	
		}
		
		
		
		//for if coming from the east
		if(directionFrom == 4){
			
			
	if(posY != 0 && maze.isNorthWall(posY,posX) == false && breaker == false){
				
				solution.add(new Pair<Integer,Integer>(posY-1,posX));
				mc.repaint();
				Thread.sleep(10);
				
				breaker = solveMaze(solution,mc,maze,posX,posY-1,3);	
				//backtrack
				if(breaker == false){
				solution.remove(solution.size()-1);
				mc.repaint();
				Thread.sleep(10);
				}
				
			}
	
	if(posX != 0 && maze.isWestWall(posY,posX) == false && breaker == false){
		
		solution.add(new Pair<Integer,Integer>(posY,posX-1));
		mc.repaint();
		Thread.sleep(10);
		
		breaker = solveMaze(solution,mc,maze,posX-1,posY,4);
		//backtrack
		if(breaker == false){
		solution.remove(solution.size()-1);
		mc.repaint();
		Thread.sleep(10);
		}
		
	}
			
		
		if(posY != maze.getHeight()-1 && maze.isNorthWall(posY+1,posX) == false && breaker == false){
			
			solution.add(new Pair<Integer,Integer>(posY+1,posX));
			mc.repaint();
			Thread.sleep(10);
			
			breaker = solveMaze(solution,mc,maze,posX,posY+1,1);
			//backtrack
			if(breaker == false){
			solution.remove(solution.size()-1);
			mc.repaint();
			Thread.sleep(10);
			
			}
		}
		
		
				
		
		}
		
		
		
		
	
		}
		
		
			
		if(breaker == false){
		return false;
		}
		else{
			return true;
		}
	}
}
