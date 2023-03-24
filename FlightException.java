public class FlightException extends Exception
{
    public FlightException(final String message) {
        super(message);
    }
    
    public FlightException(final String message, final Throwable cause) {
        super(message, cause);
    }
}