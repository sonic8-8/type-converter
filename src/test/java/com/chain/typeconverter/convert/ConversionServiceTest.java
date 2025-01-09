package com.chain.typeconverter.convert;

import com.chain.typeconverter.converter.IntegerToStringConverter;
import com.chain.typeconverter.converter.IpPortToStringConverter;
import com.chain.typeconverter.converter.StringToIntegerConverter;
import com.chain.typeconverter.converter.StringToIpPortConverter;
import com.chain.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {

    @DisplayName("컨버전 서비스에 타입 컨버터를 등록해 사용할 수 있다")
    @Test
    void conversionService() {
        // given
        DefaultConversionService conversionService = new DefaultConversionService();

        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        IpPort ipPort = new IpPort("127.0.0.1", 8080);

        // when then
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);

        assertThat(conversionService.convert(ipPort, String.class)).isEqualTo("127.0.0.1:8080");
        assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(ipPort);

    }
}
