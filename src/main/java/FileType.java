import org.apache.commons.io.FilenameUtils;

public class FileType {
	
	public static void checkCSVType(String csvFilePath) throws CensusAnalyzerException {
		String extension = FilenameUtils.getExtension(csvFilePath);
		if(!extension.equals("csv")) {
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.INCORRECT_FILE_TYPE, "Incorrect file type");
		}
	}
}
