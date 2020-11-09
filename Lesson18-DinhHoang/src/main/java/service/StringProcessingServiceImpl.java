package service;

import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import utils.VNWithoutAccents;

public class StringProcessingServiceImpl implements StringProcessingService {

	@Override
	public int countWords(String input) {
		return input.split("[ ]+").length;
	}

	@Override
	public String countDuplicateWords(String input) {
		Map<String, Long> map = Pattern.compile("[ ]+").splitAsStream(input)
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		String result = "";
		for (Entry<String, Long> entry : map.entrySet()) {
			result += entry.getKey() + " : " + entry.getValue() + " lần.\n";
		}
		return result;
	}

	@Override
	public String switchTo(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			if (!" ".equals(String.valueOf(input.charAt(i)))) {
				result += VNWithoutAccents.changeTo(String.valueOf(input.charAt(i)));
			} else {
				result += " ";
			}
		}
		return result;
	}

	@Override
	public boolean isAlphabet(String input) {
		String str = "0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~}";
		for (int i = 0; i < input.length(); i++) {
			if (!" ".equals(String.valueOf(input.charAt(i))) && str.contains(String.valueOf(input.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
}