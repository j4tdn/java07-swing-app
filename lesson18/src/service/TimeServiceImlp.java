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
 * @author Admin
 */
public class TimeServiceImlp implements TimeService{

    @Override
    public Period getPeriod(Date start, Date end) {
        Objects.requireNonNull(start, "Date Start cannot be null!");
        Objects.requireNonNull(end, "Date End cannot be null!");
        
        //convert util date to local date
        java.sql.Date sDate = new java.sql.Date(start.getTime());
        sDate.toLocalDate();
        LocalDate Lstart = toLocalDate(start);
        LocalDate Lend = toLocalDate(end);
        return Period.between(Lstart, Lend);
    }
    private LocalDate toLocalDate(java.util.Date uDate){
        Objects.requireNonNull(uDate);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate.toLocalDate();
    }
}
