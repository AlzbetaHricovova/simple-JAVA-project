public class AirportException extends Exception
{
    public AirportException(final String message) {
        super(message);
    }
    
    public AirportException(final String message, final Throwable cause) {
        super(message, cause);
    }
}