import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyzerTest {

	public static final String STATECENSUS_CSVFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
	public static final String STATECENSUS_WRONGFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaCensusData.csv";
	public static final String STATECENSUS_TEXTFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.txt";
	public static final String STATECENSUS_WRONGDELIMITER_FILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusDataWrongDelimiter.csv";
	public static final String STATECODE_CSVFILE  = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCode.csv";
	public static final String STATECODE_WRONGFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\StateCode.csv";
	public static final String STATECODE_TEXTFILE  = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCode.txt";
	
	@Test
	public void givenStateCensusCSVFile_EnsuresNoOfRecordMatches_ShouldReturnTrue() {
		try {
			int count = StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_CSVFILE);
			Assert.assertEquals(29, count);
			System.out.println(count);
		} 
		catch (CensusAnalyzerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void givenStateCensusCsvFile_IfIncorrect_ShouldThrowCensusAnalyserException() {
        try {
            StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_WRONGFILE);
        } 
        catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }
	
	@Test
	public void givenStateCensusCSVFile_IfCorrectButTypeIncorrect_ShouldThrowCensusAnalyzerException() {
		try {
            StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_TEXTFILE);
        } 
        catch (CensusAnalyzerException e) {
            Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, e.type);
        }
	}
	
	@Test
	public void givenStateCensusCSVFile_WhenCorrectButDelimiterIncorrect_ShouldReturnsCensusAnalyserException() {
		try {
	         StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_WRONGDELIMITER_FILE);
	    } 
	    catch (CensusAnalyzerException e) {
	         Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.DELIMITER_ISSUE, e.type);
	    }
	}
	
	@Test
	public void givenStateCensusCSVFile_WhenCorrectButHeaderIncorrect_ShouldReturnCensusAnalyserException() {
		 try {
			 StateCensusAnalyzer.loadStateCensusCSV(STATECODE_CSVFILE);
	     } 
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_HEADER, e.type);
	     }
	}
	
	@Test
	public void givenStateCodeCSVFile_EnsuresNoOfRecordMatches_ShouldReturnTrue() {
		try {
			int count = StateCensusAnalyzer.loadStateCodeCSV(STATECODE_CSVFILE);
			Assert.assertEquals(37, count);
			System.out.println(count);
		} 
		catch (CensusAnalyzerException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	 public void givenStateCodeCsvFile_IfIncorrect_ShouldThrowCensusAnalyserException() {
		 try {
			 StateCensusAnalyzer.loadStateCodeCSV(STATECODE_WRONGFILE);
		 } 
	     catch (CensusAnalyzerException e) {
	         Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.type);
	     }
	 }
	
	@Test
	 public void givenStateCodeCSVFile_IfCorrectButTypeIncorrect_ShouldThrowCensusAnalyzerException() {
		 try {
			 StateCensusAnalyzer.loadStateCodeCSV(STATECODE_TEXTFILE);
		 } 
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, e.type);
		 }
	 }
}
