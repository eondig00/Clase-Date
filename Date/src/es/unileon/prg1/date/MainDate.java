package es.unileon.prg1.date;

public class MainDate {
    public static void main(String[] args) {
        // Excepciones
        try {
            // Declaración de fechas
            Date hoy = new Date(25, 10, 2022);
            Date ayer = new Date(24, 10, 2022);
            // Usos
            hoy.isSame(ayer);
            // Prints
            System.out.println(hoy.toString());
            System.out.println(ayer.toString());
            // Meses hasta fin de año
            hoy.getMonthsUntilYearEnds();
            // Meses de hoy
            System.out.println(hoy.getMonthName());
            // Meses con el mismo número de días
            hoy.getMonthsWithSameNumberOfDays();
            // Días desde el principio
            System.out.println(hoy.getDaysSinceStartOfYearToDate());
            // Attempts
            System.out.println(hoy.randomDateSameWhile());
            System.out.println(hoy.randomDateSameDoWhile());
            // Day of week
            System.out.println(hoy.getDayWeek());

        }
        catch (DateException e) {
            System.out.println(e.getMessage());
        }
    }
}
