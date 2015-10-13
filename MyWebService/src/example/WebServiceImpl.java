package example;
import javax.jws.WebService;
@WebService(
		endpointInterface = "example.WebServiceInterface",
		portName = "webservicePort",
		serviceName = "WebServiceInterface")

public class WebServiceImpl implements WebServiceInterface {
	double ans = 0.0;
	double amount= 0.0;
	String currencyFrom = "";
	String currencyTo = "";
	@Override
	public void print() {
		// TODO Auto-generated method stub
		// your own function implementation goes here
		System.out.print(amount + " " + currencyFrom + " to " + currencyTo + " is " + ans);
	}

	@Override
	public double convert(String currencyFrom, String currencyTo, String before, String after, double toConvert) {
		double b =  Double.parseDouble(before);
		double a =  Double.parseDouble(after);
		this.amount = toConvert;
		this.currencyFrom = currencyFrom;
		this.currencyTo = currencyTo;
		double ans = (toConvert * b) / a;
		this.ans = ans;
		return ans;
	}
}