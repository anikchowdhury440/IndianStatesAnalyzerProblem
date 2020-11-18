import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import CSVBuilderJar.CSVBuilderJar.*;

public class StateCensusAnalyzer {
	
	public static int loadStateCensusCSV(String csvFilePath) throws CensusAnalyzerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			FileType.checkCSVType(csvFilePath);
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<CSVStateCensus> stateCensusList = csvBuilder.getCSVFileList(reader, CSVStateCensus.class);
			return stateCensusList.size();
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
		catch (CSVBuilderException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.UNABLE_TO_PARSE, "Unable to parse");
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, "Incorrect Data");
		}
	}
	
	public static int loadStateCodeCSV(String csvFilePath) throws CensusAnalyzerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			FileType.checkCSVType(csvFilePath);
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			List<CSVStateCode> stateCensusList = csvBuilder.getCSVFileList(reader, CSVStateCensus.class);
			return stateCensusList.size();
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
		catch (CSVBuilderException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.UNABLE_TO_PARSE, "Unable to parse");
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_DATA, "Incorrect Data");
		}
	}
	
	
}
