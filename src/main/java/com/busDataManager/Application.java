package com.busDataManager;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(
		systemName = "Bus Dataset Manager",
		sharedModules = {"com.busDataManager.core"},
		useFullyQualifiedModuleNames = true
)
@SpringBootApplication(scanBasePackages = {"controller","service","model","repository"})
@Generated
public class Application {

	@Value("bus-data-manager")

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
