package com.school.config;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.school.logging.ExceptionWriter;
import com.school.view.StageManager;

import javafx.stage.Stage;

@Configuration
public class AppJavaConfig {
	@Lazy
	@Autowired
	SpringFXMLLoader springFXMLLoader;

	/**
	 * Useful when dumping stack trace to a string for logging.
	 * 
	 * @return ExceptionWriter contains logging utility methods
	 */
	@Bean
	@Scope("prototype")
	public ExceptionWriter exceptionWriter() {
		return new ExceptionWriter(new StringWriter());
	}

	@Bean
	public ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("Bundle");
	}

	@Bean
	@Lazy(value = true) // Stage only created after Spring context bootstap
	public StageManager stageManager(Stage stage) throws IOException {
		return new StageManager(springFXMLLoader, stage);
	}

}
