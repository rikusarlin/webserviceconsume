package consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import country.wsdl.CountryName;
import country.wsdl.CountryNameResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public CountryNameResponse getCountryName(String countryCode) {

		CountryName request = new CountryName();
		request.setSCountryISOCode(countryCode);
		
		log.info("Getting country name for code " + countryCode);

		CountryNameResponse response = (CountryNameResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso",
						request,
						new SoapActionCallback("CountryName"));

		return response;
	}
	

}