package es.unileon.prg1.date;

public class Date {
    //Variables
    private int day;
    private int month;
    private int year;
    // Excepción
    public void setDay(int day) throws DateException {
        if ( day < 1 || day > this.getDaysUntilMonthEnds()) {
            throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");
        }
        this.day = day;
    }

    public void setMonth (int month) throws DateException {
        if ( month < 1 || month > 12) {
            throw new DateException("Date error: Month " + month + " not valid");
        }
        this.month = month;
    }

    public void setYear (int year) {
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
    //Días hasta fin de mes
    public int getDaysUntilMonthEnds() {
        for (int i = day; i <= this.getThisMonthDays(); i++) {
            System.out.println(i + "/" + month + "/" + year);
        }
        return this.getThisMonthDays() - day;
    }
    //Meses hasta fin de año
    private String getMonthNameWithItsNumber(int month){
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "enero";
                break;
            case 2:
                monthName = "febrero";
                break;
            case 3:
                monthName = "marzo";
                break;
            case 4:
                monthName = "abril";
                break;
            case 5:
                monthName = "mayo";
                break;
            case 6:
                monthName = "junio";
                break;
            case 7:
                monthName = "julio";
                break;
            case 8:
                monthName = "agosto";
                break;
            case 9:
                monthName = "septiembre";
                break;
            case 10:
                monthName = "octubre";
                break;
            case 11:
                monthName = "noviembre";
                break;
            case 12:
                monthName = "diciembre";
                break;
        }
        return monthName;
    }
    public void getMonthsUntilYearEnds() {
        for (int i = month; i <= 12; i++) {
            System.out.println("Queda el mes de " + getMonthNameWithItsNumber(i) + " hasta fin de año");
        }
    }
    //Meses con el mismo número de días
    public int getMonthSameDays(int month){
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
    public void getMonthsWithSameNumberOfDays(){
        System.out.println(getMonthNameWithItsNumber(month) + " tiene el mismo número de días que");
        for (int i = 1; i<= 12; i++) {
            if (getThisMonthDays() == getMonthSameDays(i) && this.month != i) {
                System.out.println(getMonthNameWithItsNumber(i));
            }
        }
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
    String getSeason() {
        String season = "";
        switch (this.month) {
            case 12: //next
            case 1: //next
            case 2:
                season = "invierno";
                break;
            case 3: //next
            case 4: //next
            case 5:
                season = "primavera";
                break;
            case 6: //next
            case 7: //next
            case 8:
                season = "verano";
                break;
            case 9: //next
            case 10: //next
            case 11:
                season = "otoño";
                break;
        }
        return season;
    }

    int getThisMonthDays() {
        return getMonthDays(this.month);
    }

    // Número de días al mes
    int getMonthDays(int month) {
        int monthDays = 0;
        switch (month) {
            case 1:
                monthDays = 31;
                break;
            case 2:
                monthDays = 28;
                break;
            case 3:
                monthDays = 31;
                break;
            case 4:
                monthDays = 30;
                break;
            case 5:
                monthDays = 31;
                break;
            case 6:
                monthDays = 30;
                break;
            case 7:
                monthDays = 31;
                break;
            case 8:
                monthDays = 31;
                break;
            case 9:
                monthDays = 30;
                break;
            case 10:
                monthDays = 31;
                break;
            case 11:
                monthDays = 30;
                break;
            case 12:
                monthDays = 31;
                break;
        }
        return monthDays;
    }
    //For a date, count the number of days since the first day
    //of the year (do not consider leap years)
    public int getDaysSinceStartOfYearToDate() {
        int daysAdd = 0;
        for (int i = 1; i < this.month; i++) {
            daysAdd += getMonthDays(i);
        }
        return daysAdd + this.day ;
    }
    //Build a method that counts the number of attempts
    //needed to generate a random date equals to a given
    //date (only inside the same year)
    //While
    public int randomDateSameWhile() {
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
    //Sacar día de la semana
        //Year code
        int y = year % 100;
        int yearCode = (int) (y+(y/4))%7;
        //Month code
        int monthCode = 0;
        int getMonthCode (int month) {
            switch (month) {
                case 1: //next
                case 10:
                    monthCode = 0;
                    break;
                case 2: //next
                case 3: //next
                case 11:
                    monthCode = 3;
                    break;
                case 4: //next
                case 7:
                    monthCode = 6;
                    break;
                case 5:
                    monthCode = 1;
                    break;
                case 6:
                    monthCode = 4;
                    break;
                case 8:
                    monthCode = 2;
                    break;
                case 9: //next
                case 12:
                    monthCode = 5;
                    break;
            }
            return monthCode;
        }
        //Code century - Gregorian Calendar
        public int getCenturyCode(int year) {
            int centuryCode = 0;
            if ((1700 >= year && year < 1800) || (2100 <= year && year < 2200)) {
                centuryCode = 4;
            }
            if ((1800  >= year && year < 1900) || (2200 <= year && year < 2300)) {
                centuryCode = 2;
            }
            if ((1900 >= year && year < 2000) || (2300 <= year && year < 2400)) {
                centuryCode = 0;
            }
            if (2000 >= year && year < 2100) {
                centuryCode = 6;
            }
            return centuryCode;
        }
        //Leap year - gregorian calendar
        public int getLeapYearCode(int year) {
            int leapYearCode = 0;
            if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)){
                leapYearCode = 1;
            }
            return leapYearCode;
        }
        //Calculating day

        public String getDayWeek() {
            int dayWeek = (yearCode + monthCode + getCenturyCode(year) + day - getLeapYearCode(year))%7;
            String nameDayOfWeek = "";
            switch (dayWeek) {
                case 0:
                    nameDayOfWeek = "domingo";
                    break;
                case 1:
                    nameDayOfWeek = "lunes";
                    break;
                case 2:
                    nameDayOfWeek = "martes";
                    break;
                case 3:
                    nameDayOfWeek = "miércoles";
                    break;
                case 4:
                    nameDayOfWeek = "jueves";
                    break;
                case 5:
                    nameDayOfWeek = "viernes";
                    break;
                case 6:
                    nameDayOfWeek = "sábado";
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

