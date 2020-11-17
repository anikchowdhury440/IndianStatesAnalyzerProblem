import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyzerTest {

	public static final String STATECENSUS_CSVFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
	public static final String STATECENSUS_WRONGFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaCensusData.csv";
	
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
}
