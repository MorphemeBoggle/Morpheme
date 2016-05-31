package Morpheme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class DictionaryInit {
	
	private String dictionaryUsed;
	private int largestWordLength = 52;
	
	public ArrayList<String> addDictionary(String fileName, boolean canWeUsePersonalizedWordList){
		
		dictionaryUsed = fileName.substring(0, 3);
		
		ArrayList<String> dict = new ArrayList<String>();
		
		File dictionaryFile = new File(fileName);
		
		addWordsToArray(dictionaryFile, dict, canWeUsePersonalizedWordList);
		
		return dict;
	}
	
	private void addWordsToArray(File dictionaryFile, ArrayList<String> dict, boolean canWeUsePersonalizedWordList){
		
		if(dictionaryUsed.equals("TWL") && canWeUsePersonalizedWordList == true){
			addPersonalWords(dict);
		}
		
		
		File file = new File(dictionaryFile.getPath());
		String h = file.getAbsolutePath();
		
		FileReader fileReader;
		BufferedReader bufferedReader = null;
			
			try {
				fileReader = new FileReader(h);
				bufferedReader = new BufferedReader(fileReader);
				
				String line = "";
				while ((line = bufferedReader.readLine()) != null){
					dict.add(line);
					line = "";
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Object addPersonalWords(Object array){
					
		File file = new File("PersonalWords.txt");
		String h = file.getAbsolutePath();
		
		FileReader fileReader;
		BufferedReader bufferedReader = null;
			
			try {
				fileReader = new FileReader(h);
				bufferedReader = new BufferedReader(fileReader);
				
				String line = "";
				while ((line = bufferedReader.readLine()) != null){
					if (array instanceof ArrayList<?>){
						((ArrayList<String>) array).add(line);
					} else if (array instanceof Hashtable<?, ?>){
						((Hashtable<String, Integer>) array).put(line, 1);
					}
					line = "";
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
								
				return array;
		
	}
	
	
	public Hashtable<String, Integer> vghn67(String path, Hashtable<String, Integer> list){
	
		File file = new File(path);
		String h = file.getAbsolutePath();

FileReader fileReader;
BufferedReader bufferedReader = null;
	
	try {
		fileReader = new FileReader(h);
		bufferedReader = new BufferedReader(fileReader);
		
		String line = "";
		while ((line = bufferedReader.readLine()) != null){
			list.put(line, 1);
			line = "";
		}
		bufferedReader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
				
				
				return list;
		
	}
		
	public Hashtable<String, Integer> dictArrayListToHashTable(ArrayList<String> array){
		Hashtable<String, Integer> dictionaryHashtable = new Hashtable<String, Integer>();
		for (int c = 0; c < array.size(); c++){
			dictionaryHashtable.put(array.get(c), 1);
		}
		
		return dictionaryHashtable;
	}
	
	public Hashtable<String, Integer> potentialWordArrayListToHashTable(ArrayList<String> array){
		Hashtable<String, Integer> potentialWordHashtable = new Hashtable<String, Integer>();
		for (int c = 0; c < array.size(); c++){
			String word = array.get(c);
			for (int x = 1; x < word.length() + 1; x++){
				String potentialWord = word.substring(0, x);
				if (!potentialWordHashtable.containsKey(potentialWord)){
					potentialWordHashtable.put(potentialWord, 1);
				}
			}
		}
		
		return potentialWordHashtable;
	}
	
	public ArrayList<ArrayList<String>> letterLengthGrouping(ArrayList<String> array){
		ArrayList<ArrayList<String>> orderedListByLength = new ArrayList<ArrayList<String>>();
		
		for (int q = 0; q < largestWordLength; q++){
			orderedListByLength.add(new ArrayList<String>());
		}
		
		for (int index = 0; index < array.size(); index++){
			orderedListByLength.get(array.get(index).length() - 1).add(array.get(index));
		}
		
		return orderedListByLength;
	}
	
	public ArrayList<String> definitions(){
		
		ArrayList<String> definitions = new ArrayList<String>();
		
		
		File file = new File("Definitions.txt");
		String h = file.getAbsolutePath();
		
		FileReader fileReader;
		BufferedReader bufferedReader = null;
			
			try {
				fileReader = new FileReader(h);
				bufferedReader = new BufferedReader(fileReader);
				
				String line = "";
				while ((line = bufferedReader.readLine()) != null){
					definitions.add(line);
					line = "";
				}
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return definitions;
		}
		
	private String getDefOf(String word){
		int numberOfLinesInDefinitions = 0;
		try {
			numberOfLinesInDefinitions = MorphemeServer.countLines("Definitions.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line;
		String line2;
		String stringOfChar = "";
		String wordSoFar = "";
		String restOfLineSoFar = "";
		String restOfLine = "";
		String individualCharactersAfterRestOfLine = "";
		String restOfLineAfterLessThan = "";
		String stringOfChar2 = "";
		String wordSoFar2 = "";
		String restOfLine2 = "";

			for (int w = 0; w < numberOfLinesInDefinitions; w++){
				line = MorphemeServer.definitions.get(w);
				stringOfChar = "";
				wordSoFar = "";
				restOfLineSoFar = "";
				restOfLine = "";
				boolean exitTheWhile = false;
				for (int u = 1; u < line.length() + 1; u++) {

					stringOfChar = line.substring(u - 1, u);
					if (stringOfChar.equals(" ")) {
						if (wordSoFar.equals(word)) {
							for (int v = 0; v <= line.length() - u; v++) {
								if (v == 0) {
									restOfLineSoFar = line.substring(u,
											v + u);
									restOfLine = restOfLine
											+ restOfLineSoFar;
								} else {
									restOfLineSoFar = line.substring(v
											+ u - 1, v + u);
									restOfLine = restOfLine
											+ restOfLineSoFar;
								}
							}
							
							restOfLine2 = word + " - " + restOfLine;
							
							if (restOfLine.substring(0, 1).equals("<")) {
								restOfLine2 = "";
								for (int h = 2; h <= restOfLine
										.length(); h++) {

									individualCharactersAfterRestOfLine = restOfLine
											.substring(h - 1, h);
									if (individualCharactersAfterRestOfLine
											.equals("=")) {
										restOfLineAfterLessThan = restOfLineAfterLessThan
												.toUpperCase();
										break;
									}
									restOfLineAfterLessThan = restOfLineAfterLessThan
											+ individualCharactersAfterRestOfLine;
								}

								// start of some-what onetime recursion

								for (int q = 0; q < numberOfLinesInDefinitions; q++){
									line2 = MorphemeServer.definitions.get(w);
									stringOfChar2 = "";
									wordSoFar2 = "";
									restOfLine2 = "";
									boolean exitTheWhile2 = false;
									for (int x = 1; x < line2.length() + 1; x++) {

										stringOfChar2 = line2
												.substring(x - 1, x);
										if (stringOfChar2.equals(" ")) {
											if (wordSoFar2
													.equals(restOfLineAfterLessThan)) {

												restOfLine2 = word + " - " + line2;

												exitTheWhile2 = true;
												break;
											}
										}
										wordSoFar2 = wordSoFar2
												+ stringOfChar2;

									}

									if (exitTheWhile2 == true) {
										break;
									}
								}
								// end of some-what onetime recursion

							}
							exitTheWhile = true;
							break;
						}
					}
				
					wordSoFar = wordSoFar + stringOfChar;

					if (!word.startsWith(wordSoFar)) {

						break;
					}
					

					if (exitTheWhile == true) {
						break;
					}

				}
			if (exitTheWhile == true) {
				break;
				}
			}
		
		String h = "";
		
		if (restOfLine2.length() > 0) {
			h = restOfLine2 + "\n";
		}
		
		return h;
	
	}
	
	}
