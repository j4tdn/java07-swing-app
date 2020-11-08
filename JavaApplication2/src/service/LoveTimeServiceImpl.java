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
 * @author khanh
 */
public class LoveTimeServiceImpl implements LoveTimeService{

    @Override
    public Period getPeriod(Date start, Date end) {
        Objects.requireNonNull(start,"date start can not be null");
        Objects.requireNonNull(end,"date end can not be null");
        LocalDate lStart = toLocalDate(start);
        LocalDate lEnd = toLocalDate(end);
        return Period.between(lStart, lEnd);
    }
    private LocalDate toLocalDate(Date uDate){
        Objects.requireNonNull(uDate);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate.toLocalDate();
    }
    
}
