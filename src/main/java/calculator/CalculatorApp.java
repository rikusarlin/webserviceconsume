package calculator;

import calculator.wsdl.MultiplyResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CalculatorApp {

	private static final Logger log = LoggerFactory.getLogger(CalculatorApp.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CalculatorApp.class, args);
	}

	@Bean
	CommandLineRunner lookup(CalculatorClient calculatorClient) {
		return args -> {
			int number1 = 0;
			int number2 = 0;

			if (args.length > 0) {
				number1 = Integer.parseInt(args[0]);
			}
			if (args.length > 1) {
				number2 = Integer.parseInt(args[1]);
			}
			
			MultiplyResponse response = calculatorClient.multiply(number1, number2);
			log.info(number1 + " times " + number2 + " equals " + response.getMultiplyResult());
		};
	}

}
