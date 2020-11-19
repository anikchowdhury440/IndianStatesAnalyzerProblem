
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import CSVBuilderJar.CSVBuilderJar.*;

public class StateCensusAnalyzer {
	static List<CSVStateCensus> stateCensusList = null;
	static List<CSVStateCode> stateCodeList = null;
	
	public static int loadStateCensusCSV(String csvFilePath) throws CensusAnalyzerException {
		try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
			FileType.checkCSVType(csvFilePath);
			ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
			stateCensusList = csvBuilder.getCSVFileList(reader, CSVStateCensus.class);
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
			stateCodeList = csvBuilder.getCSVFileList(reader, CSVStateCode.class);
			return stateCodeList.size();
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
	
	public static String getSortByStateCensusData() throws CensusAnalyzerException {
		checkListEmpty();
		stateCensusList = stateCensusList.stream()
				.sorted((data1, data2) -> data1.getStateName().compareTo(data2.getStateName()))
				.collect(Collectors.toList());
		String sortedStateCensusJson = JSONOperation.getJson(stateCensusList);
		return sortedStateCensusJson;
	}
	
	public static String getSortByStateCode() throws CensusAnalyzerException {
		if(stateCodeList == null || stateCodeList.size() == 0) {
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA, "No Census Data ");
		}
		stateCodeList = stateCodeList.stream()
				.sorted((data1, data2) -> data1.getStateCode().compareTo(data2.getStateCode()))
				.collect(Collectors.toList());
		String sortedStateCodeJson = JSONOperation.getJson(stateCodeList);
		return sortedStateCodeJson;
	}
	
	public static String getSortByPopulationCensusData() throws CensusAnalyzerException {
		checkListEmpty();
		stateCensusList = stateCensusList.stream()
				.sorted((data1, data2) -> data2.getPopulation().compareTo(data1.getPopulation()))
				.collect(Collectors.toList());
		String sortedStateCensusJson = JSONOperation.getJson(stateCensusList);
		JSONOperation.writeToJsonFile(sortedStateCensusJson);
		return sortedStateCensusJson;
	}
	
	public static String getSortByPopulationDensityCensusData() throws CensusAnalyzerException {
		checkListEmpty();
		stateCensusList = stateCensusList.stream()
				.sorted((data1, data2) -> data2.getDensityPerSqKm().compareTo(data1.getDensityPerSqKm()))
				.collect(Collectors.toList());
		String sortedStateCensusJson = JSONOperation.getJson(stateCensusList);
		JSONOperation.writeToJsonFile(sortedStateCensusJson);
		return sortedStateCensusJson;
	}
	
	public static String getSortByStateAreaCensusData() throws CensusAnalyzerException {
		checkListEmpty();
		stateCensusList = stateCensusList.stream()
				.sorted((data1, data2) -> data2.getAreaInSqKm().compareTo(data1.getAreaInSqKm()))
				.collect(Collectors.toList());
		String sortedStateCensusJson = JSONOperation.getJson(stateCensusList);
		JSONOperation.writeToJsonFile(sortedStateCensusJson);
		return sortedStateCensusJson;
	}
	
	public static void checkListEmpty() throws CensusAnalyzerException {
		if(stateCensusList == null || stateCensusList.size() == 0) {
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_CENSUS_DATA, "No Census Data ");
		}
	}
	
}
