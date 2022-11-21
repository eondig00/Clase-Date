package es.unileon.prg1.date;

public class MainDate {
    public static void main(String[] args) {
        // Excepciones
        try {
            // Declaración de fechas
            Date today = new Date(1, 1, 2017);
            Date ayer = new Date(31, 1, 2016);
            // Usos
            today.isSame(ayer);
            // Prints
            System.out.println(today.toString());
            System.out.println(ayer.toString());
            // Meses hasta fin de año
            today.getMonthsLeft();
            // Meses hasta fin de año
            // Meses de hoy
            System.out.println(today.getMonthName());
            // Meses con el mismo número de días
            today.getMonthsSameDays();
            // Días desde el principio
            System.out.println(today.daysPast());
            // Attempts
            System.out.println(today.numRandomTriesEqualDate());
            System.out.println(today.randomDateSameDoWhile());
            // Day of week

        }
        catch (DateException e) {
            System.out.println(e.getMessage());
        }
    }
}
