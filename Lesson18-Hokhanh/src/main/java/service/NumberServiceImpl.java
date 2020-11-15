/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khanh
 */
public class NumberServiceImpl implements NumberService{

    @Override
    public String getOnlyOneNumbers(String numbers) {
        String result ="";
        
        String[] numberStrings = numbers.trim().split(",");
        List<Integer> numberList = new ArrayList<>();
        List<String> string = new ArrayList<>();
        for(String s:numberStrings){
            numberList.add(Integer.parseInt(s));
        }
        for(int i = 0;i<numberList.size();i++){
            if(!contain(numberList, i,numberList.get(i))){
                string.add(numberList.get(i)+"");
            }
        }
        result = String.join(",", string);
        return result;
    }
    
    private boolean contain(List<Integer> list,int index,int num){
        for(int i=0;i<list.size();i++){
            if(i!=index && num==list.get(i)){
                return true;
            }
        }
        return false;
    }
    
}
