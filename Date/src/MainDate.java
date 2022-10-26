public class MainDate {
    public static void main(String[] args) {
        // Declaración de fechas
        Date hoy = new Date(25,10,2022);
        Date ayer = new Date(24,10,2022);
        // Usos
        hoy.isSameDay(ayer);
    }
}
