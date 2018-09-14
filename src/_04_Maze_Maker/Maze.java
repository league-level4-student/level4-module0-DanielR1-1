package _04_Maze_Maker;

import java.awt.Graphics;

public class Maze {
	// 1. Create a 2D array of cells. Don't initialize it.
	Cell[][] CellArray;
	private int width;
	private int height;

	public Maze(int w, int h) {
		this.width = w;
		this.height = h;

		// 2. Initialize the cells using the width and height varibles
		CellArray = new Cell[width][height];
		// 3. Iterated through each cell and initialize it
		// using i and j as the location
		for (int i = 0; i < CellArray.length; i++) {
			for (int j = 0; j < CellArray[i].length; i++) {
				CellArray[i][j].setX(i);
				CellArray[i][j].setY(j);
			}
		}

	}

	// 4. This method iterates through the cells and draws them
	public void draw(Graphics g) {
		for (int i = 0; i < CellArray.length; i++) {
			for (int j = 0; j < CellArray[i].length; i++) {
				CellArray[i][j].draw(g);
			}
		}
	}

	// 4b. This method returns the selected cell.
	public Cell getCell(int x, int y) {
		for (int i = 0; i < CellArray.length; i++) {
			for (int j = 0; j < CellArray[i].length; i++) {
				if (CellArray[i][j].getX() == x && CellArray[i][j].getY() == y) {
					return CellArray[i][j];
				}
			}
		}
		return null;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
