
public class CensusAnalyzerException extends Exception{
	enum CensusExceptionType{
        NO_SUCH_FILE, SOME_OTHER_IO_EXCEPTION, INCORRECT_FILE_TYPE, INCORRECT_DATA, UNABLE_TO_PARSE;
    }
    CensusExceptionType type;

    public CensusAnalyzerException() {
    }

    public CensusAnalyzerException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
