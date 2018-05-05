package consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import calculator.wsdl.Multiply;
import calculator.wsdl.MultiplyResponse;

public class CalculatorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

	public MultiplyResponse multiply(int a, int b) {

		Multiply request = new Multiply();
		request.setIntA(a);
		request.setIntB(b);
		
		log.info("Multiplying " + a + " with " + b);

		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
						request,
						new SoapActionCallback("http://tempuri.org/Multiply"));

		return response;
	}
	

}