import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	public static int loadStateCensusCSV(String csvFilePath) throws CensusAnalyzerException {
		int count = 0;
		try {
			Iterator<CSVStateCensus> myIterator = getIteratorCSVStateCensus(csvFilePath);
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

	public static Iterator<CSVStateCensus> getIteratorCSVStateCensus(String csvFilePath) throws CensusAnalyzerException {
		Reader reader = null;
		CsvToBean<CSVStateCensus> csvToBean = null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
			String extension = FilenameUtils.getExtension(csvFilePath);
			if(!extension.equals("csv")) {
				throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, "Incorrect file type");
			}
			csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
	                    .withType(CSVStateCensus.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			Iterator<CSVStateCensus> myIterator = csvToBean.iterator();
			return myIterator;
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_HEADER, "Incorrect header");
		}
	}
	
	public static int loadStateCodeCSV(String csvFilePath) throws CensusAnalyzerException {
		int count = 0;
		try {
			Iterator<CSVStateCode> myIterator = getIteratorCSVStateCode(csvFilePath);
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

	public static Iterator<CSVStateCode> getIteratorCSVStateCode(String csvFilePath) throws CensusAnalyzerException {
		Reader reader = null;
		CsvToBean<CSVStateCode> csvToBean = null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
			String extension = FilenameUtils.getExtension(csvFilePath);
			if(!extension.equals("csv")) {
				throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, "Incorrect file type");
			}
			csvToBean = new CsvToBeanBuilder<CSVStateCode>(reader)
	                    .withType(CSVStateCode.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			Iterator<CSVStateCode> myIterator = csvToBean.iterator();
			return myIterator;
		}
		catch (NoSuchFileException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, "No File Exist ");
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_HEADER, "Incorrect header");
		}
	}
}
