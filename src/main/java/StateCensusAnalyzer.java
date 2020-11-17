import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

public class StateCensusAnalyzer {

	public static int loadStateCensusCSV(String csvFilePath) throws CensusAnalyzerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			FileType.checkCSVType(csvFilePath);
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<CSVStateCensus> myIterator = csvBuilder.getCsvFileIterator(reader, CSVStateCensus.class);
			return getCountFromCSVIterator(myIterator);
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
	}
	
	public static int loadStateCodeCSV(String csvFilePath) throws CensusAnalyzerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			FileType.checkCSVType(csvFilePath);
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			Iterator<CSVStateCode> myIterator = csvBuilder.getCsvFileIterator(reader, CSVStateCode.class);
			return getCountFromCSVIterator(myIterator);
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
	}
	
	private static <E> int getCountFromCSVIterator(Iterator<E> myIterator) throws CensusAnalyzerException {
		int count = 0;
		try {
			while(myIterator.hasNext()) {
				count++;
				myIterator.next();
			}
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.DELIMITER_ISSUE, "Delimiter Incorrect");
		}
		return count;
	}
	
}
