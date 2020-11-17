import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder {
	
	public static <E> Iterator<E> getCsvFileIterator(Reader reader, Class<E> csvClass) 
														throws CensusAnalyzerException {
		try {
			CsvToBean<E> csvToBean = new CsvToBeanBuilder<E>(reader)
	                    .withType(csvClass)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			return csvToBean.iterator();
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_HEADER, "Incorrect header");
		}
	}

	public static void checkType(String csvFilePath) throws CensusAnalyzerException {
		String extension = FilenameUtils.getExtension(csvFilePath);
		if(!extension.equals("csv")) {
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, "Incorrect file type");
		}
	}
}
