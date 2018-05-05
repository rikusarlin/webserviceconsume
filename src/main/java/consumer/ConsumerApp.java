package consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import calculator.wsdl.MultiplyResponse;
import country.wsdl.CountryNameResponse;

@SpringBootApplication
public class ConsumerApp {

	private static final Logger log = LoggerFactory.getLogger(ConsumerApp.class);
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ConsumerApp.class);
		application.run(args);
	}

	@Bean
	CommandLineRunner lookup(CalculatorClient calculatorClient, CountryClient countryClient) {
		return args -> {
			int number1 = 0;
			int number2 = 0;
			String countryCode = "";
			
			if (args.length > 0) {
				try {
					number1 = Integer.parseInt(args[0]);
				} catch (NumberFormatException nfe) {
					log.error(args[0] + " is not an integer, using 0");
				}
			}
			if (args.length > 1) {
				try {
					number2 = Integer.parseInt(args[1]);
				} catch (NumberFormatException nfe) {
					log.error(args[1] + " is not an integer, using 0");
				}
			}
			if (args.length > 2) {
				countryCode = args[2];
			}


			MultiplyResponse multiplyResponse = calculatorClient.multiply(number1, number2);
			log.info(number1 + " times " + number2 + " equals " + multiplyResponse.getMultiplyResult());
			
			CountryNameResponse countryNameResponse = countryClient.getCountryName(countryCode);
			log.info("Country name for country code " + countryCode + " is " + countryNameResponse.getCountryNameResult());
			
		};
	}

}
