package es.unileon.prg1.date;

public class Date {
    //Variables
    private int day;
    private int month;
    private int year;

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
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Constructor
    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2017;
    }
    //Returns the string version of date

    //Días hasta fin de mes
    public void getDaysUntilMonthEnds() {
        for (int i = day; i <= this.getMonthDays(); i++) {
            System.out.println(i + "/" + month + "/" + year);
        }
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
            if (getMonthDays() == getMonthSameDays(i) && this.month != i) {
                System.out.println(getMonthNameWithItsNumber(i));
            }
        }
    }
    //string version of date

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

    // Número de días al mes
    int getMonthDays() {
        int monthDays = 0;
        switch (this.month) {
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
        // Meses hasta fin de año

    }

    //toString
    public String toString() {
        //Date en números
        StringBuilder numberDate = new StringBuilder();
        numberDate.append(this.day);
        numberDate.append("/");
        numberDate.append(this.month);
        numberDate.append("/");
        numberDate.append(this.year);
        return numberDate.toString();
        //Date en letra
        //

    }
}