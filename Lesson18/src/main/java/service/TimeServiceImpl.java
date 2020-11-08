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
 * @author OS
 */
public class TimeServiceImpl implements TimeService{

    @Override
    public Period getPeriod(Date start, Date finish) {
        LocalDate lstart = toLocalDate(start);
        LocalDate lfinish = toLocalDate(finish);
        return Period.between(lstart, lfinish);
    }
    
    private LocalDate toLocalDate(java.util.Date uDate) {
        Objects.requireNonNull(uDate);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate.toLocalDate();
    }
    
}
