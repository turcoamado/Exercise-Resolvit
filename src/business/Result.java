package business;

import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@JsonDeserialize
public class Result {
	@JsonProperty("word")
	private String word;
	@JsonProperty("total-ocurrences")
	private int totalOcurrences;
	@JsonProperty("sentence-indexes")
	private Set<Integer>sentencesIndexes;
	
	public Result(String word, int sentencesNumber) {
		totalOcurrences = 1;
		this.sentencesIndexes = new HashSet<Integer>();
		sentencesIndexes.add(sentencesNumber);
		this.word = word;	
	}
	
	public void addIndex(int sentenceNumber){
		sentencesIndexes.add(sentenceNumber);
		totalOcurrences++;
		
	}
	
	
}
