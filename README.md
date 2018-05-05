# webserviceconsume
Simple Spring Boot app to consume and aggregate several web services. The idea is just to learn how to configure handling of several generated JAXB interfaces in a Spring Boot app.

Technologies used:
- Spring Boot
- Spring WS
- JAXB

The following services are used:

[Simple calculator service](http://www.dneonline.com/calculator.asmx?wsdl)

[Simple country info service](http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL)

Usage via command line: 
```
java -jar target\webserviceconsumer-0.1.0.jar 12 13 FI
...
2018-05-05 19:07:06.537  INFO 4548 --- [           main] consumer.CalculatorClient                : Multiplying 12 with 13
2018-05-05 19:07:07.031  INFO 4548 --- [           main] consumer.ConsumerApp                     : 12 times 13 equals 156
2018-05-05 19:07:07.031  INFO 4548 --- [           main] consumer.CountryClient                   : Getting country name for code FI
2018-05-05 19:07:07.172  INFO 4548 --- [           main] consumer.ConsumerApp                     : Country name for country code FI is Finland
...
```

