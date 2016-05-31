package Morpheme;




import java.util.ArrayList;
import java.util.Hashtable;

public class SolverList extends ArrayList<String> {

	private int minimumWordLength;
	private Hashtable<String, Integer> allWords;
	private Hashtable<String, Integer> allPotentialWords;
	private String[][] board;

	
	public SolverList(String[][] board, Hashtable<String, Integer> allWords, Hashtable<String, Integer> allPotentialWords, int minimumWordLength){
		
		this.minimumWordLength = minimumWordLength;
		this.allWords = allWords;
		this.allPotentialWords = allPotentialWords;
		this.board = board;

		solve();
	}
	
	private void solve(){
		
		int boardDimensions = board.length;
		boolean[][] booleanArray = new boolean[boardDimensions][boardDimensions];
		for(int q = 0; q < boardDimensions; q++){
			for(int w = 0; w < boardDimensions; w++){
				booleanArray[q][w] = true;
			}
		}
		
		String wordSoFar = "";
		for(int q = 0; q < boardDimensions; q++){
			for(int w = 0; w < boardDimensions; w++){
				if (board[q][w].equals("Q")){
				wordSoFar = board[q][w] + "U";
				booleanArray[q][w] = false;
				checkSurroundingLetter(wordSoFar, booleanArray, q, w);
				booleanArray[q][w] = true;
				} 

				wordSoFar = board[q][w];
				booleanArray[q][w] = false;
				checkSurroundingLetter(wordSoFar, booleanArray, q, w);
				booleanArray[q][w] = true;
			}
		}
		
	}
	
	private void checkSurroundingLetter(String wordSoFar, boolean[][] booleanArray, int q, int w){
		
		for(int e = q - 1; e <= q + 1; e++){
			for(int r = w - 1; r <= w + 1; r++){
				
				if((e >= 0) && (e < board.length) && (r >= 0) && (r < board.length) && !(e == q && r == w)){
										
					if (booleanArray[e][r] == true){
					
					if (board[e][r].equals("Q")){
						
						appendLetterAndEvaluate("QU", wordSoFar, booleanArray, e, r);
						
					} 
					
					appendLetterAndEvaluate(board[e][r] , wordSoFar, booleanArray, e, r);
					
					
					}
					
					
				}
				
			}
		}
		
	}
	
	
	public void appendLetterAndEvaluate(String appending, String wordSoFar, boolean[][] booleanArray, int e, int r){
		
		int numberToSubtract = appending.length();
		
		wordSoFar = wordSoFar + appending;
		
		if (allPotentialWords.containsKey(wordSoFar)){
			if (allWords.containsKey(wordSoFar) && wordSoFar.length() >= minimumWordLength && !(this.contains(wordSoFar))){
				this.add(wordSoFar);
			}
			
			booleanArray[e][r] = false;
			
			checkSurroundingLetter(wordSoFar, booleanArray, e, r);
			
			booleanArray[e][r] = true;
			
		}
		
		wordSoFar = wordSoFar.substring(0, wordSoFar.length() - numberToSubtract);

		
	}
}
