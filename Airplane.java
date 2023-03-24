import java.util.Objects;

public class Airplane
{
    private final String key;
    private int maxInt;
    private final int number;
    private Airport airport;
    
    public Airplane() {
        this.maxInt = 0;
        ++this.maxInt;
        this.number = this.maxInt;
        StringBuilder builder = new StringBuilder("OK-");
        builder = builder.append(this.maxInt);
        this.key = builder.toString();
        this.airport = null;
    }
    
    public Airport getAirport() {
        return this.airport;
    }
    
    public void prepareFlight(final Airport destination) throws FlightException {
        this.airport = destination;
        if (destination == null || this.airport.equals(destination)) {
            throw new FlightException("destination is null or same");
        }
    }
    
    public void cancelFlight() {
        this.airport = null;
    }
    
    @Override
    public String toString() {
        if (this.airport == null) {
            return String.format("Airplane OK-%s", this.number);
        }
        return String.format("Airplane OK-%s flying to %s", this.number, this.airport);
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        final Airplane plane = (Airplane)obj;
        return this.key.equals(plane.key);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.key);
        hash = 17 * hash + this.number;
        hash = 17 * hash + Objects.hashCode(this.airport);
        return hash;
    }
}