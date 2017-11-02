package com.lysthuset.ourbudget.model.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeHelper {

    public int getYear(int offset){
        int year = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy")));

        return year + offset;
    }

    public String getMonth(int offset){
        int month = Integer.parseInt(
                LocalDate.now().format(
                        DateTimeFormatter.ofPattern("MM")
                )
        );

        month = month + offset % 12;

        switch (month){
            case 1:
                return "januar";
            case 2:
                return "februar";
            case 3:
                return "marts";
            case 4:
                return "april";
            case 5:
                return "maj";
            case 6:
                return "juni";
            case 7:
                return "juli";
            case 8:
                return "august";
            case 9:
                return "september";
            case 10:
                return "oktober";
            case 11:
                return "november";
            case 12:
                return "december";
            default:
                return "false";
        }

    }
}
