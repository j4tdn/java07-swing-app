/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class TimeServiceImpl implements TimeService{

    @Override
    public Period getPeriod(Date start, Date end) {
       Objects.requireNonNull(start, "Date start can not null !!!");
       Objects.requireNonNull(end, "Date end can not null !!!");
       
       
       //convert util date to localdate
       
       
        LocalDate lStart = toLocalDate(start);
        LocalDate sEnd = toLocalDate(end);
        return Period.between(lStart, sEnd);
       
    }
    private LocalDate toLocalDate (java.util.Date nDate){
        Objects.requireNonNull(nDate);
        java.sql.Date sDate = new java.sql.Date(nDate.getTime());
        return sDate.toLocalDate();
        
    }
    
    
}

