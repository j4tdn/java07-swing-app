/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class ChangeColorImpl implements ChangeColor {

    @Override
    public String changeColor() {
        String color = "";
        Random rd = new Random();

        int key = rd.nextInt(7);
        switch (key) {

            case 1:
                color = "pink";
                break;
            case 2:
                color = "red";
                break;
            case 3:
                color = "blue";
                break;
            case 4:
                color = "black";
                break;
            case 5:
                color = "green";
                break;
            case 6:
                color = "yellow";
                break;
            case 7:
                color = "white";
                break;

        }
        return color;
    }

}
