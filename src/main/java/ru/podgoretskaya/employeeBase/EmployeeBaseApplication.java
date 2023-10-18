package ru.podgoretskaya.employeeBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.podgoretskaya.employeeBase.client.AccountingClient;

@SpringBootApplication
@EnableFeignClients(clients = AccountingClient.class)
public class EmployeeBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeBaseApplication.class, args);
	}

}
