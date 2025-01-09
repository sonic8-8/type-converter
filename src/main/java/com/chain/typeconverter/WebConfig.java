package com.chain.typeconverter;

import com.chain.typeconverter.converter.IntegerToStringConverter;
import com.chain.typeconverter.converter.IpPortToStringConverter;
import com.chain.typeconverter.converter.StringToIntegerConverter;
import com.chain.typeconverter.converter.StringToIpPortConverter;
import com.chain.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        registry.addFormatter(new MyNumberFormatter());
    }
}
