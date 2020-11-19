import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

public class StateCensusAnalyzerTest {

	public static final String STATECENSUS_CSVFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.csv";
	public static final String STATECENSUS_WRONGFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaCensusData.csv";
	public static final String STATECENSUS_TEXTFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusData.txt";
	public static final String STATECENSUS_WRONGDELIMITER_FILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCensusDataWrongDelimiter.csv";
	public static final String STATECODE_CSVFILE  = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCode.csv";
	public static final String STATECODE_WRONGFILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\StateCode.csv";
	public static final String STATECODE_TEXTFILE  = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCode.txt";
	public static final String STATECODE_WRONGDELIMITER_FILE = "C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndiaStateCodeWrongDelimiter.csv";
	
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
	         Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, e.type);
	    }
	}
	
	@Test
	public void givenStateCensusCSVFile_WhenCorrectButHeaderIncorrect_ShouldReturnCensusAnalyserException() {
		try {
			StateCensusAnalyzer.loadStateCensusCSV(STATECODE_CSVFILE);
	    } 
		catch (CensusAnalyzerException e) {
			Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, e.type);
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
	
	@Test
	 public void givenStateCodeCSVFile_WhenCorrectButDelimiterIncorrect_ShouldReturnsCensusAnalyserException() {
		 try {
			 StateCensusAnalyzer.loadStateCodeCSV(STATECODE_WRONGDELIMITER_FILE);
		 } 
		 catch (CensusAnalyzerException e) {
		     Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, e.type);
		 }
	 }
	
	 @Test
	 public void givenStateCodeCSVFile_WhenCorrectButHeaderIncorrect_ShouldReturnCensusAnalyserException() {
		 try {
			 StateCensusAnalyzer.loadStateCodeCSV(STATECENSUS_CSVFILE);
		 } 
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, e.type);
		 }
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByState_ShouldReturnSortedResult() {
		 try {
			 StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_CSVFILE);
			 String sortedCensusData = StateCensusAnalyzer.getSortByStateCensusData();
			 CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
			 Assert.assertEquals("Andhra Pradesh", censusCSV[0].getStateName());
			 Assert.assertEquals("West Bengal", censusCSV[28].getStateName());
		 }
		 catch (CensusAnalyzerException e) {
			// TODO: handle exception
		}
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByStateName_IsNullorEmpty_ShouldThrowCensusAnalyzerException() {
		 try {
			 StateCensusAnalyzer.getSortByStateCensusData();
		 }
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA,e.type);
		}
	 }
	 
	 @Test
	 public void givenStateCodeData_WhenSortedByStateCode_ShouldReturnSortedResult() {
		 try {
			 StateCensusAnalyzer.loadStateCodeCSV(STATECODE_CSVFILE);
			 String sortedStateCodeData = StateCensusAnalyzer.getSortByStateCode();
			 CSVStateCode[] stateCodeCSV = new Gson().fromJson(sortedStateCodeData, CSVStateCode[].class);
			 Assert.assertEquals("Andhra Pradesh New", stateCodeCSV[0].getStateName());
			 Assert.assertEquals("West Bengal", stateCodeCSV[36].getStateName());
		 }
		 catch (CensusAnalyzerException e) {
			// TODO: handle exception
		}
	 }
	 
	 @Test
	 public void givenStateCodeData_IsNullorEmpty_ShouldThrowCensusAnalyzerException() {
		 try {
			 StateCensusAnalyzer.getSortByStateCode();
		 }
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA,e.type);
		}
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByPopulation_ShouldReturnSortedResult() {
		 try {
			 StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_CSVFILE);
			 String sortedCensusData = StateCensusAnalyzer.getSortByPopulationCensusData();
			 CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
			 Assert.assertEquals("Uttar Pradesh", censusCSV[0].getStateName());
			 Assert.assertEquals("Sikkim", censusCSV[28].getStateName());
		 }
		 catch (CensusAnalyzerException e) {
			// TODO: handle exception
		}
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByPopulation_IsNullorEmpty_ShouldThrowCensusAnalyzerException() {
		 try {
			 StateCensusAnalyzer.getSortByPopulationCensusData();
		 }
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA,e.type);
		}
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByPopulationDensity_ShouldReturnSortedResult() {
		 try {
			 StateCensusAnalyzer.loadStateCensusCSV(STATECENSUS_CSVFILE);
			 String sortedCensusData = StateCensusAnalyzer.getSortByPopulationDensityCensusData();
			 CSVStateCensus[] censusCSV = new Gson().fromJson(sortedCensusData, CSVStateCensus[].class);
			 Assert.assertEquals("Bihar", censusCSV[0].getStateName());
			 Assert.assertEquals("Arunachal Pradesh", censusCSV[28].getStateName());
		 }
		 catch (CensusAnalyzerException e) {
			// TODO: handle exception
		}
	 }
	 
	 @Test
	 public void givenStateCensusData_WhenSortedByPopulationDensity_IsNullorEmpty_ShouldThrowCensusAnalyzerException() {
		 try {
			 StateCensusAnalyzer.getSortByPopulationDensityCensusData();
		 }
		 catch (CensusAnalyzerException e) {
			 Assert.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA,e.type);
		}
	 }

}
