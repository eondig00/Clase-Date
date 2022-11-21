package es.unileon.prg1.date;

import java.time.MonthDay;

public class Date {
    //Variables
    private int day;
    private int month;
    private int year;
    
    // Excepción
    public void setDay(int day) throws DateException {
        if ( day < 1 || day > this.getMonthDays(month)) {
            throw new DateException("Día " + day + " del mes " + this.month + " no válido");
        }
        this.day = day;
    }

    public void setMonth (int month) throws DateException {
        if ( month < 1 || month > 12 || this.getMonthDays(month) < this.day) {
            throw new DateException("Mes " + month + " no válido");
        }
        this.month = month;
    }

    public void setYear (int year) throws DateException {
       if (year < 0) {
        throw new DateException("El año " + year + " no  es válido");
        }
        this.year = year;
    }
    
    //Gets
    int getYear() {
        return this.year;
    }

    int getMonth() {
        return this.month;
    }

    int getDay() {
        return this.day;
    }

    //Constructor
    public Date (int day, int month, int year) throws DateException {
        //this.month = month;
        this.setMonth(month);
        //this.day = day;
        this.setDay(day);
        //this.year = year;
        this.setYear(year);
    }
    //Constructor
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2017;
    } 
    
    public Date (Date today) {
        this.day = 1;
        this.month = 1;
        this.year = 2017;
    }
    
    public Date tomorrow() {
        Date tempTomorrow = new Date();
        if (this.day + 1 <= getMonthDays(this.month)){
            tempTomorrow.day = this.day + 1;
        }
        else {
            tempTomorrow.day = 1;
        }
        if (tempTomorrow.day == 1){
            if (this.month + 1 > 12){
                tempTomorrow.month = 1; 
                tempTomorrow.year = this.year + 1;   
            }
            else {
                tempTomorrow.month = this.month + 1;
                tempTomorrow.year = this.year;
            }
        }
        return tempTomorrow;
    }

    //Días hasta fin de mes
    public String getDaysLeftOfMonth() {
        StringBuffer fecha = new StringBuffer();
        for (int i = day + 1; i <= this.daysOfMonth(); i++) {
            fecha.append(i + "/" + this.month + "/" + this.year + " ");
        }
        return fecha.toString();
    }
    //Meses hasta fin de año
    private String getMonthNameWithItsNumber(int month){
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }
    public String getMonthsLeft() {
        StringBuilder temp = new StringBuilder();
        for (int i = month+1; i <= 12; i++) {
            System.out.println(getMonthNameWithItsNumber(i));
            temp.append(getMonthNameWithItsNumber(i) + " ");
        }
        return temp.toString();
    }
    //Meses con el mismo número de días
    public int getMonthSameNumberDays(int month){
        int monthSameDays = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                monthSameDays = 31;
                break;
            case 2:
                monthSameDays = 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                monthSameDays = 30;
                break;
        }
        return monthSameDays;
    }
    public String getMonthsSameDays(){
        StringBuilder sb = new StringBuilder();
            sb.append(getMonthNameWithItsNumber(this.month) + " ");
        for (int i = 1; i<= 12; i++) {
            if (daysOfMonth() == getMonthSameNumberDays(i) && this.month != i) {
                
                sb.append(getMonthNameWithItsNumber(i) + " ");
            }
        } return sb.toString();
    }
    //Saber si es mismo día/mes/año/fecha
    public boolean isSame(Date another) {
        return this.year == another.getYear() && this.month == another.getMonth() && this.day == another.getDay();
    }
    public boolean isSameDay(Date another) {
        return this.day == another.getDay();
    }
    public boolean isSameMonth(Date another) {
        return this.month == another.getMonth();
    }
    public boolean isSameYear(Date another) {
        return this.year == another.getYear();
    }

    // Nombre del mes por el número
    String getMonthName() {
        return getMonthNameWithItsNumber(this.month);
    }

    //Estación del año por meses
    String getSeasonName() {
        String season = "";
        switch (this.month) {
            case 12: //next
            case 1: //next
            case 2:
                season = "Winter";
                break;
            case 3: //next
            case 4: //next
            case 5:
                season = "Spring";
                break;
            case 6: //next
            case 7: //next
            case 8:
                season = "Summer";
                break;
            case 9: //next
            case 10: //next
            case 11:
                season = "Autumn";
                break;
        }
        return season;
    }

    public int daysOfMonth() {
        return getMonthDays(this.month);
    }

    // Número de días al mes
    public int getMonthDays(int month){
        int monthDays = 0;
        switch (month) {
            case 1: //next
            case 3: //next
            case 5: //next
            case 7: //next
            case 8: //next
            case 10: //next
            case 12:
                monthDays = 31;
                break;
            case 2:
                monthDays = 28;
                break;
            case 4: //next
            case 6: //next
            case 9: //next
            case 11: //next
                monthDays = 30;
                break;
        }
        return monthDays;
    }
    //For a date, count the number of days since the first day
    //of the year (do not consider leap years)
    public int daysPast() {
        int daysAdd = 0;
        for (int i = 1; i < this.month; i++) {
            daysAdd += getMonthDays(i);
        }
        
        return daysAdd + this.day - 1;
    }
    //Build a method that counts the number of attempts
    //needed to generate a random date equals to a given
    //date (only inside the same year)
    //While
    public int numRandomTriesEqualDate() {
        boolean randomDate = false;
        int attempts = 0;
        while(!randomDate){
            int random_day = (int)Math.floor(Math.random()*(31-1+1)+1);
            int random_month = (int)Math.floor(Math.random()*(12-1+1)+1);
            attempts++;
            if( random_day == this.day && random_month == this.month){
                randomDate = true;
            }
        }
        return attempts;
    }
    //Do-while
    public int randomDateSameDoWhile() {
        boolean randomDate2 = false;
        int attempts2 = 0;
        do{
            int random_day = (int)Math.floor(Math.random()*(31-1+1)+1);
            int random_month = (int)Math.floor(Math.random()*(12-1+1)+1);
            attempts2++;
            if( random_day == this.day && random_month == this.month) {
                randomDate2 = true;
            }
        } while(!randomDate2);
        return attempts2;
    }
    //Sacar día de la semana (01/01 -> lunes)
    public String dayOfWeek(int day){
        int diaSemana = 0;
        if (this.month == 1){
            diaSemana = this.day % 7;
        }
        else {
                diaSemana = (this.day + getMonthDays(this.month - 1)) % 7;
        }
        return getDayWeek(diaSemana);
    }
    public String getDayWeek(int dia) {
        String nameDayOfWeek = "";
        switch (dia) {
            case 0:
                nameDayOfWeek = "Sunday";
                break;
            case 1:
                nameDayOfWeek = "Monday";
                break;
            case 2:
                nameDayOfWeek = "Tuesday";
                break;
            case 3:
                nameDayOfWeek = "Wednesday";
                break;
            case 4:
                nameDayOfWeek = "Thursday";
                break;
            case 5:
                nameDayOfWeek = "Friday";
                break;
            case 6:
                nameDayOfWeek = "Saturday";
                break;
        }
        return nameDayOfWeek;
    }
    //Date en String
    public String toString() {
        //Date en números
        StringBuilder numberDate = new StringBuilder();
        numberDate.append(this.day);
        numberDate.append("/");
        numberDate.append(this.month);
        numberDate.append("/");
        numberDate.append(this.year);
        return numberDate.toString();
    }

}