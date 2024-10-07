package com.busDataManager;

import com.busDataManager.core.Generated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.modulith.Modulithic;

@Modulithic(
		systemName = "Bus Dataset Manager",
		sharedModules = {"com.busDataManager.core"},
		useFullyQualifiedModuleNames = true
)
@SpringBootApplication
@Generated

public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
