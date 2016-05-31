package Morpheme;




import java.util.Random;

public class LoadBoard {
	
private final String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};	
private boolean[][] blankSpots;
private int squareDimensions;
private int[] frequency;

private String[][] setBoard(String[][] board){

	for (int q = 0; q < squareDimensions; q++){
		for (int w = 0; w < squareDimensions; w++){
			boolean torf = true;
			//if (blankSpots[q][w] == true){
			//	torf = false;
			//}
			board[q][w] = getLetter(torf);
		}
	}
	
	return board;
}

public String[][] getBoard(int squareDimensions, int[] frequency){
	
	this.squareDimensions = squareDimensions;
	this.frequency = frequency;
	
	String[][] board = new String[squareDimensions][squareDimensions];
	
	setBoard(board);
	
	return board;
}

private String getLetter(boolean torf){
	
	if (torf == true){
		int sum = getSumOfFrequencies();
		Random r = new Random();
		int randomNumber = r.nextInt(sum);
	
		for (int t = 0; t < 26; t++){
			if(randomNumber < frequency[t]){
				return alphabet[t];
			} else {
				randomNumber -= frequency[t];
			}
		}
	}
	
	return "*";
}

private int getSumOfFrequencies(){
	
	int sum = 0;
	for (int e = 0; e < 26; e++){
		sum = sum + frequency[e];
	}
	return sum;
}
	
}
