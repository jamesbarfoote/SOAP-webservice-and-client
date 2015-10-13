package example;
import javax.jws.WebService;
@WebService
public interface WebServiceInterface {
	//your own function signature goes here;
	public void print();
	
	public double convert(String currencyFrom, String currencryTo, String before, String after, double toConvert);
}