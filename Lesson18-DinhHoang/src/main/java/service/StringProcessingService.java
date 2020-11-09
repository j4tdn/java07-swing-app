package service;

public interface StringProcessingService {
	int countWords(String input);

	String countDuplicateWords(String input);

	String switchTo(String input);

	boolean isAlphabet(String input);
}