package com.viewnext.siraku;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SirakuConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
