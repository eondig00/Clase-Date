
class Date{
    //Variables
    private int day;
    private int month;
    private int year;

    //Gets
    int getYear(){
        return this.year;
    }
    int getMonth(){
        return this.month;
    }
    int getDay(){
        return this.day;
    }

    //Constructor
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    //Días hasta fin de mes
    void getDatesUntilMonthEnd(){
        for(int i = day; i <= this.getMonthDays(); i++){
            System.out.println(i + "/" + month + "/" + year);
        }
    }

    //Saber si es mismo día
    public boolean isSameDay(Date another){
        return this.year == another.getYear() && this.month == another.getMonth() && this.day == another.getDay();
    }
    // Nombre del mes por el número
    String getMonthName(){
        String monthName = "";
        switch (this.month) {
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
    //Estacion del año por meses
    String getSeason(){
        String season = "";
        switch(this.month) {
        case 12: //next
        case 1: //next
        case 2:
            season = "invierno";
            break;
        }
        return season;
    }
    // Número de días al mes
    int getMonthDays(){
        int monthDays = 0;
        switch (this.month){
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
}
