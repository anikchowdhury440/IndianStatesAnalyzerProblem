
public class CSVBuilderException extends Exception{
	
	public enum ExceptionType {
        UNABLE_TO_PARSE
    }
 
	public ExceptionType type;

	public CSVBuilderException(ExceptionType type, String message) {
		super(message);
		this.type = type;
	}
}
