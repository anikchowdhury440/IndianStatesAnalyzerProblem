package CSVBuilderJar.CSVBuilderJar;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
	public Iterator<E> getCsvFileIterator(Reader reader, Class<E> csvClass) throws CSVBuilderException;
	public List<E> getCSVFileList(Reader reader, Class csvClass) throws CSVBuilderException;
}
