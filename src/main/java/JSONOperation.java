import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONOperation {
	public static String getJson(List stateCensusList) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.setPrettyPrinting().create();
		return gson.toJson(stateCensusList);
	}
	
	public static void writeToJsonFile(String jsonString) throws CensusAnalyzerException {
		Path path = Paths.get("C:\\Users\\Anik Chowdhury\\Github\\IndianStateCensusAnalyzerProblem\\src\\main\\resources\\IndianStateCensus.json");
		try (FileWriter writer = new FileWriter(path.toFile())){
			writer.write(jsonString);
		}
		catch (IOException e) {
			e.printStackTrace();
			throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.SOME_OTHER_IO_EXCEPTION, "Some other IO Exception");
		}
	}
}
