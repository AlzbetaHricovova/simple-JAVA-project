public class Demo
{
    public static void main(final String[] args) throws AirportException, FlightException {
        final Airplane a1 = new Airplane();
        final Airport prg = new Airport("PRG");
        final Airport vie = new Airport("VIE");
        a1.prepareFlight(prg);
        try {
            System.out.print("Arrival of null airplane: ");
            prg.arrival(null);
            System.out.println("ERROR");
        }
        catch (AirportException ex) {
            System.out.println("OK");
        }
        try {
            System.out.print("Arrival of a stray airplane: ");
            final Airplane plane = new Airplane();
            plane.prepareFlight(new Airport("JFK"));
            prg.arrival(plane);
            System.out.println("ERROR");
        }
        catch (AirportException ex) {
            System.out.println("OK");
        }
        try {
            System.out.print("Arrival of correct airplane: ");
            prg.arrival(a1);
            System.out.println("OK");
        }
        catch (AirportException ex) {
            System.out.println("ERROR: " + ex);
        }
        try {
            System.out.print("Arrival of already landed airplane: ");
            prg.arrival(a1);
            System.out.println("ERROR");
        }
        catch (AirportException ex) {
            System.out.println("OK");
        }
        try {
            System.out.print("Departure of null airplane: ");
            prg.departure(null, vie);
            System.out.println("ERROR");
        }
        catch (AirportException ex) {
            System.out.println("OK");
        }
        try {
            System.out.print("Departure of unknown airplane: ");
            final Airplane plane = new Airplane();
            prg.departure(plane, vie);
            System.out.println("ERROR");
        }
        catch (AirportException ex) {
            System.out.println("OK");
        }
        System.out.println("More flights...");
        Airplane a2 = new Airplane();
        Airplane a3 = new Airplane();
        Airplane a4 = new Airplane();
        a2.prepareFlight(prg);
        a3.prepareFlight(vie);
        a4.prepareFlight(vie);
        a2 = prg.arrival(a2);
        a3 = vie.arrival(a3);
        a4 = vie.arrival(a4);
        a4 = vie.departure(a4, prg);
        System.out.println("Airplanes in PRG: " + prg.getAirplanes());
        System.out.println("Airplanes in VIE: " + vie.getAirplanes());
        System.out.println("Airplane in the air: " + a4);
    }
}