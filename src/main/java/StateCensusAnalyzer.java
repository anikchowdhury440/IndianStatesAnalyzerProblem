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
			Iterator<CSVStateCensus> myIterator = getCsvFileIterator(csvFilePath, CSVStateCensus.class);
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
	
	public static int loadStateCodeCSV(String csvFilePath) throws CensusAnalyzerException {
		int count = 0;
		try {
			Iterator<CSVStateCode> myIterator = getCsvFileIterator(csvFilePath, CSVStateCode.class);
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
	
	private static <E> Iterator<E> getCsvFileIterator(String csvFilePath, Class<E> csvClass) throws CensusAnalyzerException {
		Reader reader = null;
		CsvToBean<E> csvToBean = null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
			String extension = FilenameUtils.getExtension(csvFilePath);
			if(!extension.equals("csv")) {
				throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, "Incorrect file type");
			}
			csvToBean = new CsvToBeanBuilder<E>(reader)
	                    .withType(csvClass)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			Iterator<E> myIterator = csvToBean.iterator();
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
