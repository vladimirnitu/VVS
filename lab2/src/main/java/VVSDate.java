package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VVSDate {

    private int day,month,year;

    public VVSDate(int day, int month, int year) throws WrongDateException {
        validate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private void validate( int d , int m , int y ) throws WrongDateException {
        if(m<1 || m > 12 || y <=0) {
            throw new WrongDateException ();
        }

        int maxDays = 28;
        Integer[] fullMonthsA = {1,3,5,7,8,10,12};
        if(y%400==0 || (y%4==0 && y%100!=0)) {
            if (m == 2) {
                maxDays = 29;
            }
        } else {
            if(m != 2) {
                maxDays = 30;
            }
            for(Integer i: fullMonthsA) {
                if (m == i) {
                    maxDays = 31;
                    break;
                }
            }
        }

        if (d<1 || d> maxDays) {

            throw new WrongDateException ();
        }


    }

    private int daysSinceZero() {
        int[] daySums = new int[]{0,31,59,90,120,151,181,212,243,273,304,334,365};
        int d = day + daySums[month-1] + (year*365) + year/4 - year/100 + year/400;
        if ((year%400==0 || (year%4==0 && year%100!=0)) && month<=2)
            d--;
        return d;
    }

    public int getDays( VVSDate other ) {
        return daysSinceZero() - other.daysSinceZero();
    }
}
