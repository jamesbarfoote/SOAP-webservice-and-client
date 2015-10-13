package main;

import javax.jws.WebService;

@WebService(
		endpointInterface = "main.WebServiceInterface",
		portName = "webservicePort",
		serviceName = "WebServiceInterface")

public class WebServiceImpl implements WebServiceInterface 
{
	@Override
	public void print() 
	{
		// TODO Auto-generated method stub
		// your own function implementation goes here
		System.out.print("Hello, WebService!");
	}
}