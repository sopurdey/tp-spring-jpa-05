package fr.diginamic.tpspringjpa05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class TpSpringJpa05Application {

	public static void main(String[] args) {
		SpringApplication.run(TpSpringJpa05Application.class, args);
	}

	/**
	 * Configuration pour charger les messages intenationaux :
	 * messages.properties
	 * 
	 * @return messageSource
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}