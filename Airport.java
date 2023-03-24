import java.util.Objects;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Airport
{
    private String name;
    private final Set<Airplane> planes;
    
    public Airport(final String name) {
        this.planes = new HashSet<Airplane>();
        if (name == null) {
            throw new NullPointerException("name is  null");
        }
        this.name = name;
    }
    
    public Set getAirplanes() {
        return (Set)Collections.unmodifiableCollection((Collection<?>)this.planes);
    }
    
    public Airplane arrival(final Airplane airplane) throws AirportException {
        if (airplane == null || this.getAirplanes().contains(airplane) || !this.equals(airplane.getAirport())) {
            throw new AirportException("airplane is null, is in airport, not for this airport");
        }
        this.planes.add(airplane);
        airplane.cancelFlight();
        return airplane;
    }
    
    public Airplane departure(final Airplane airplane, final Airport destination) throws AirportException, FlightException {
        if (!destination.getAirplanes().contains(airplane)) {
            throw new AirportException("not airplane on airport");
        }
        airplane.prepareFlight(destination);
        return airplane;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        final Airport port = (Airport)obj;
        return this.name.equals(port.name);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.planes);
        return hash;
    }
}