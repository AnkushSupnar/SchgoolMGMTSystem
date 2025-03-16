package com.school;

import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.school.data.service.LoginService;
import com.school.view.FxmlView;
import com.school.view.StageManager;

import javafx.application.Application;
import javafx.stage.Stage;

@SpringBootApplication
public class SchoolManagementSystemApplication extends Application {

	private ConfigurableApplicationContext springContext;
	protected StageManager stageManager;
	LoginService loginService;

	public static void main(String[] args) {
		// SpringApplication.run(SchoolManagementSystemApplication.class, args);
		Application.launch(args);
	}

	@Override
	public void init() throws IOException {
		springContext = bootstrapSpringApplicationContext();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stageManager = springContext.getBean(StageManager.class, stage);
		loginService = springContext.getBean(LoginService.class);
		displayInitialScene();
	}

	@Override
	public void stop() {
		springContext.close();
	}

	protected void displayInitialScene() {
		/*if(loginService.getAllUserNames().isEmpty()){
			stageManager.switchScene(FxmlView.CREATE);
		}else {
			stageManager.switchScene(FxmlView.LOGIN);
		}*/
		//stageManager.switchScene(FxmlView.LOGIN);
		stageManager.switchScene(FxmlView.LOGIN);
		//stageManager.switchScene(FxmlView.CREATE);
		//stageManager.switchScene(FxmlView.BILLING);
		//stageManager.switchScene(FxmlView.CUSTOMER);
		//stageManager.switchScene(FxmlView.EMPLOYEE);
		//stageManager.switchScene(FxmlView.HOME);
		//stageManager.switchScene(FxmlView.PURCHASEINVOICE);
		//stageManager.switchScene(FxmlView.ITEMSTOCK);
		//stageManager.switchScene(FxmlView.SALEREPORT);
		//stageManager.switchScene(FxmlView.ITEM);
	}
	private ConfigurableApplicationContext bootstrapSpringApplicationContext() {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SchoolManagementSystemApplication.class);
		String[] args = getParameters().getRaw().stream().toArray(String[]::new);
		builder.headless(false); //needed for TestFX integration testing or eles will get a java.awt.HeadlessException during tests
		return builder.run(args);
	}

}
