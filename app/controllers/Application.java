package controllers;

import models.User;
import java.lang.Long;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.*;
import play.mvc.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.*;



public class Application extends Controller {

    public static void index(String name, String age) {
        render(name, age);
    }

    public static void hello(String name, String age) {
        validation.required(name);
        validation.required(age);
        validation.min(age, 0);
        if (validation.hasErrors()) {
            params.flash(); // add http parameters to the flash scope
            // keep the errors for the next request

        }


        LocalDate birthdate = new LocalDate(age);




        LocalDate now = new LocalDate();
        Period period = new Period(birthdate, now, PeriodType.yearMonthDay() );
        int iAge = period.getYears();



        render(name, age, iAge);


    }
}



