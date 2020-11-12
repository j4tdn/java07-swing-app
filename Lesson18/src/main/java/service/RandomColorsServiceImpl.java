/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Color;

/**
 *
 * @author Trung
 */
public class RandomColorsServiceImpl implements RandomColorsService{
    
    @Override
	public Color getColor(int key) {

		switch (key) {
		case 0:
			return Color.RED;
		case 1:
			return Color.GREEN;
		case 2:
			return Color.PINK;
		case 3:
			return Color.YELLOW;
		case 4:
			return Color.BLUE;

		default:
			return Color.WHITE;
		}

	}

	@Override
	public String getColorName(int key) {
		switch (key) {
		case 0:
			return "RED";
		case 1:
			return "GREEN";
		case 2:
			return "PINK";
		case 3:
			return "YELLOW";
		case 4:
			return "BLUE";

		default:
			return "WHITE";
		}
	}
    
}
