package consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("calculator.wsdl");
		return marshaller;
	}

	@Bean
	public Jaxb2Marshaller countryMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("country.wsdl");
		return marshaller;
	}

	@Bean
	public CalculatorClient calculatorClient(Jaxb2Marshaller marshaller) {
		CalculatorClient client = new CalculatorClient();
		client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean
	public CountryClient countryClient(Jaxb2Marshaller countryMarshaller) {
		CountryClient client = new CountryClient();
		client.setDefaultUri("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");
		client.setMarshaller(countryMarshaller);
		client.setUnmarshaller(countryMarshaller);
		return client;
	}


}