package service;

import java.awt.Color;

public interface BackgroundRandomService {
	int getIndex(int colorNumber);

	Color getBackgroundColor(int color);

	String getBackgroundColorName(int color);
}