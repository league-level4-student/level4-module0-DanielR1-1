package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		// 4. select a random cell to start
		int rw = new Random().nextInt(width);
		int rh = new Random().nextInt(height);

		Cell rCell = maze.CellArray[rw][rh];

		// 5. call selectNextPath method with the randomly selected cell
		selectNextPath(rCell);

		return maze;
	}

	// 6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. mark cell as visited
		currentCell.setBeenVisited(true);

		// B. check for unvisited neighbors using the cell
		ArrayList<Cell> unvisited = getUnvisitedNeighbors(currentCell);

		// C. if has unvisited neighbors,
		if (unvisited.size() > 0) {
			// C1. select one at random.
			int RC2I = new Random().nextInt(unvisited.size());
			Cell RCell2 = unvisited.get(RC2I);
			// C2. push it to the stack
			uncheckedCells.push(RCell2);
			// C3. remove the wall between the two cells
			removeWalls(currentCell, RCell2);
			// C4. make the new cell the current cell and mark it as visited
			currentCell = RCell2;
			currentCell.setBeenVisited(true);
		}

		// D. if all neighbors are visited
		else {

			// D1. if the stack is not empty
			if (uncheckedCells.size() > 0) {
				// D1a. pop a cell from the stack
				currentCell = uncheckedCells.pop();
				// D1b. make that the current cell
			}
		}

	}

	// 7. Complete the remove walls method.
	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getX() == c2.getX() && (c1.getY() - c2.getY()) == -1) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		if (c1.getX() == c2.getX() && (c1.getY() - c2.getY()) == 1) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
		if (c1.getY() == c2.getY() && (c1.getY() - c2.getY()) == -1) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		if (c1.getY() == c2.getY() && (c1.getY() - c2.getY()) == 1) {
			c1.setWestWall(false);
			c2.setEastWall(false);
		}
	}

	// 8. Complete the getUnvisitedNeighbors method
	// Any unvisited neighbor of the passed in cell gets added
	// to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		ArrayList<Cell> possible = new ArrayList<Cell>();
		ArrayList<Cell> definite = new ArrayList<Cell>();
		if (c.getY() > 0) {
			Cell n = maze.CellArray[c.getX()][c.getY() - 1];
			possible.add(n);
		}
		if (c.getX() < width - 1) {
			Cell e = maze.CellArray[c.getX() + 1][c.getY()];
			possible.add(e);
		}
		if (c.getY() < height - 1) {
			Cell s = maze.CellArray[c.getX()][c.getY() + 1];
			possible.add(s);
		}
		if (c.getX() > 0) {
			Cell w = maze.CellArray[c.getX() - 1][c.getY()];
			possible.add(w);
		}
		for (Cell x : possible) {
			if (x.hasBeenVisited() == false) {
				definite.add(x);
			}
		}
		return definite;
	}
}