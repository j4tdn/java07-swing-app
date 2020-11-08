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
 * @author DangHoang
 */
public class TimeSerViceImpl implements TimeService {

    @Override
    public Period getPeriod(Date start, Date end) {
        Objects.requireNonNull(start, "Date start cannot be null!");
        Objects.requireNonNull(end, "Date start cannot be null!");

//        convert util date to local date
        LocalDate lstart = toLocalDate(start);
        LocalDate lend = toLocalDate(end);

        return Period.between(lstart, lend);
    }

    private LocalDate toLocalDate(java.util.Date uDate) {
        Objects.requireNonNull(uDate);
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate.toLocalDate();
    }
}
