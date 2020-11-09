package service;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConvertServiceImpl implements ConvertService {

	@Override
	public String getResult(String input) {
		String[] numbers = input.split(",");
		return Arrays.stream(numbers).filter(num -> Arrays.stream(numbers).filter(n -> (n.equals(num))).count() == 1)
				.map(s -> String.valueOf(s)).collect(Collectors.joining(","));
	}

	@Override
	public boolean syntaxCheck(String input) {
		String[] numbers = input.split(",");
		for (String number : numbers) {
			if (!number.trim().matches("[0-9]+")) {
				return false;
			}
		}
		return true;
	}
}