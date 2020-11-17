import java.io.Reader;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVBuilder<E> implements ICSVBuilder {
	
	public Iterator<E> getCsvFileIterator(Reader reader, Class csvClass) 
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
}
