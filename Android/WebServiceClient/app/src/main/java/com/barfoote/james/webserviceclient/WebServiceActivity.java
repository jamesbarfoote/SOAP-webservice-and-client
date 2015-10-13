package com.barfoote.james.webserviceclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class WebServiceActivity extends AppCompatActivity {
    private String convertedAmount = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getConvertedAmount()
    {
        return convertedAmount;
    }

    public void connect(String currencyFrom, String currencyTo, String before, String after, double toConvert)
    {
        SoapObject request = new SoapObject("http://example/", "WebServiceInterface");
        //String currencyFrom, String currencyTo, String before, String after, double toConvert
        request.addProperty("currencyFrom", currencyFrom);
        request.addProperty("currencyTo", currencyTo);
        request.addProperty("before", before);
        request.addProperty("after", after);
        request.addProperty("toConvert", toConvert);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        PropertyInfo arg0 = new PropertyInfo();
//        arg0.setName("arg0");
//        arg0.setValue(VALUE1);
//        arg0.setType(VALUE1.class);
        request.addProperty(arg0);
        envelope.setOutputSoapObject(request);
        HttpTransportSE ht = new HttpTransportSE("http://10.140.57.114:8080/MyWebService/WebServiceInterface?wsdl");

        try {
            ht.call("http://example/"+"WebServiceInterface", envelope);
            SoapPrimitive response = (SoapPrimitive)
                    envelope.getResponse();
            convertedAmount = response.toString();
            // assign the response message to a pre-defined variable “responseMessage”
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
