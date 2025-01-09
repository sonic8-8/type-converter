package com.chain.typeconverter.convert;

import com.chain.typeconverter.converter.IntegerToStringConverter;
import com.chain.typeconverter.converter.IpPortToStringConverter;
import com.chain.typeconverter.converter.StringToIntegerConverter;
import com.chain.typeconverter.converter.StringToIpPortConverter;
import com.chain.typeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    @DisplayName("String을 Integer로 타입 변환할 수 있다")
    @Test
    void stringToInteger() {
        // given
        StringToIntegerConverter converter = new StringToIntegerConverter();

        // when
        Integer result = converter.convert("10");

        // then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("Integer를 String으로 타입 변환할 수 있다")
    @Test
    void integerToString() {
        // given
        IntegerToStringConverter converter = new IntegerToStringConverter();

        // when
        String result = converter.convert(10);

        // then
        assertThat(result).isEqualTo("10");
    }

    @DisplayName("String을 IpPort로 타입 변환할 수 있다")
    @Test
    void stringToIpPort() {
        // given
        StringToIpPortConverter converter = new StringToIpPortConverter();

        // when
        IpPort result = converter.convert("127.0.0.1:8080");

        // then
        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }

    @DisplayName("IpPort를 String으로 타입 변환할 수 있다")
    @Test
    void IpPortToString() {
        // given
        IpPortToStringConverter converter = new IpPortToStringConverter();

        // when
        String result = converter.convert(new IpPort("127.0.0.1", 8080));

        // then
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }
}
