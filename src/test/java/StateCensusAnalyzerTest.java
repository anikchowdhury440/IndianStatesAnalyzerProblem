import org.junit.Assert;
import org.junit.Test;

public class StateCensusAnalyzerTest {

	public static final String STATECENSUS_CSVFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void givenStateCensusCSVFile_EnsuresNoOfRecordMatches_ShouldReturnTrue() {
		try {
			int count = StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_CSVFILE);
			Assert.assertEquals(29, count);
			System.out.println(count);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
