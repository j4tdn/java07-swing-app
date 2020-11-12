/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.Period;
import java.util.Date;

public interface TimeService {
    Period getPeriod(Date start, Date end);
}
