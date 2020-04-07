package br.com.geektechnology.chamadostecnicosinternet.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConf {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
