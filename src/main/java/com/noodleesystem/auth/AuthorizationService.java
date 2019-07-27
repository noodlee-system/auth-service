package com.noodleesystem.auth;

import static serilogj.sinks.coloredconsole.ColoredConsoleSinkConfigurator.*;
import static serilogj.sinks.seq.SeqSinkConfigurator.*;

import serilogj.Log;
import serilogj.LoggerConfiguration;
import serilogj.core.LoggingLevelSwitch;
import serilogj.events.LogEventLevel;
import serilogj.sinks.seq.SeqSink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.noodleesystem.auth.model.User;

@SpringBootApplication
public class AuthorizationService {
	public static void main(String[] args) {
		Log.setLogger(new LoggerConfiguration()
			.writeTo(coloredConsole())
			.writeTo(seq("http://noodlee_seq:5341"))
			.createLogger());

		SpringApplication.run(AuthorizationService.class, args);

		Log.information("{serviceName} is running...", "Authentication Service");
	}
}
