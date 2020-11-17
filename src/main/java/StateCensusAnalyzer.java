import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	public static int loadStateCensusCSV(String csvFilePath) {
		int count = 0;
		Reader reader = null;
		CsvToBean<CSVStateCensus> csvToBean = null;
		try {
			reader = Files.newBufferedReader(Paths.get(csvFilePath));
			csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
	                    .withType(CSVStateCensus.class)
	                    .withIgnoreLeadingWhiteSpace(true)
	                    .build();
			Iterator<CSVStateCensus> myIterator = csvToBean.iterator();
			while(myIterator.hasNext()) {
				count++;
				myIterator.next();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
