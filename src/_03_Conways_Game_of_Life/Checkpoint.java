package _03_Conways_Game_of_Life;

import java.util.Random;

public class Checkpoint {
public static void main(String[] args) {
	int[][] d = new int[5][5];
	for (int i = 0; i < d.length; i++) {
		for (int j = 0; j < d[i].length; j++) {
			d[i][j]=new Random().nextInt(100);
		}
	}
	for (int i = 0; i < d.length; i++) {
		for (int j = 0; j < d[i].length; j++) {
			System.out.print(d[i][j]+" ");
		}
		System.out.println();
	}
}
}
