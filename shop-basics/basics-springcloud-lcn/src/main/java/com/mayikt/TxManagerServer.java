package com.mayikt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;

@SpringBootApplication
@EnableTransactionManagerServer
public class TxManagerServer {
	public static void main(String[] args) {
		SpringApplication.run(TxManagerServer.class, args);
	}

}
