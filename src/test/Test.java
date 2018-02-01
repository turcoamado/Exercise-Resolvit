package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;
import org.tartarus.snowball.SnowballStemmer;
import org.tartarus.snowball.ext.englishStemmer;

import business.Result;

public class Test {
	
	//A blacklist of words that should be not included in the analysis
	private static List<String> blacklist = Arrays.asList( "a", "the", "and", "of", "in", "be", "also", "as");
	
	public static void main(String[] args) {
		Map<String, Result> results = new TreeMap<String, Result>();
		
		//The text of the paragraph that we have to analyse
		String text = "Take this paragraph of text and return an alphabetized list of ALL unique words.  A unique word is any form of a word often communicated with essentially the same meaning. For example, fish and fishes could be defined as a unique word by using their stem fish. For each unique word found in this entire paragraph, determine the how many times the word appears in total. Also, provide an analysis of what unique sentence index position or positions the word is found. The following words should not be included in your analysis or result set: \"a\", \"the\", \"and\", \"of\", \"in\", \"be\", \"also\" and \"as\".  Your final result MUST be displayed in a readable console output in the same format as the JSON sample object shown below.";
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(text);
		//Separate words by spaces
		scanner.useDelimiter("\\s+");
		SnowballStemmer stemmer = new englishStemmer();
		int sentenceNumber = 0;
		while(scanner.hasNext()){
			String unstemWord = scanner.next();
			boolean isEnd = false;
			//If the word ends with a "." means that is the end of the sentence
			if(unstemWord.endsWith("."))
				isEnd = true;
			unstemWord = clearWord(unstemWord);
			//I check if the word is in the blacklist
			if(!inBlackList(unstemWord)){
				stemmer.setCurrent(unstemWord);
				stemmer.stem();
				String word = stemmer.getCurrent();
				//If the result map does not has the word analyzed, I add the word, put the amount in 1 and the sentence position
				if(!results.containsKey(word)){
					Result result = new Result(word, sentenceNumber);
					results.put(word, result);
				}else{
					//If the result map already has the word analyzed, I increase the amount and set the sentence position
					results.get(word).addIndex(sentenceNumber);
				}
				//If the word is the end of a sentence, I go to the next one
				if(isEnd)
					sentenceNumber++;
			}
		}
		//I create an objectMapper and serialize the Result class for get the output in JSON format
		ObjectMapper objectMapper = new ObjectMapper();
		try{
			if(objectMapper.canSerialize(Result.class)){
				String output = objectMapper.writeValueAsString(new ArrayList<Result>(results.values()));
				System.out.println(output);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	//Method that indicates if a word is in the blacklist I had already defined
	private static boolean inBlackList(String unstemWord) {
		if(blacklist.contains(unstemWord))
			return true;
		return false;
	}

	//Method for delete " and , from the words
	private static String clearWord(String unstemWord) {
		//Transform to lower case because this library is key sensitive
		return unstemWord.replaceAll("\\\"", "").replace(".", "").replace(",", "").toLowerCase();
	}

}
