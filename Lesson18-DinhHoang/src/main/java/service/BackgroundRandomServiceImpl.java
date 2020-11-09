package service;

import java.awt.Color;
import java.util.Random;

public class BackgroundRandomServiceImpl implements BackgroundRandomService {

	@Override
	public int getIndex(int colorNumber) {
		return new Random().nextInt(colorNumber);
	}

	@Override
	public Color getBackgroundColor(int color) {
		switch (color) {
		case 0:
			return Color.RED;
		case 1:
			return Color.GREEN;
		case 2:
			return Color.BLUE;
		case 3:
			return Color.YELLOW;
		case 4:
			return Color.PINK;
		default:
			return Color.WHITE;
		}
	}

	@Override
	public String getBackgroundColorName(int color) {
		switch (color) {
		case 0:
			return "RED";
		case 1:
			return "GREEN";
		case 2:
			return "BLUE";
		case 3:
			return "YELLOW";
		case 4:
			return "PINK";
		default:
			return "WHITE";
		}
	}
}