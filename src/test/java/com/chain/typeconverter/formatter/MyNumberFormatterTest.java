package com.chain.typeconverter.formatter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @DisplayName("MyNumberFormatter의 parse()는 한국의 쉼표 표기형 문자를 숫자로 변환할 수 있다")
    @Test
    void parse() throws ParseException {

        // given when
        Number result = formatter.parse("1,000", Locale.KOREA);

        // then
        assertThat(result).isEqualTo(1000L);
    }

    @DisplayName("MyNumberFormatter의 print()는 숫자를 한국의 쉼표 표기형 문자로 변환할 수 있다")
    @Test
    void print() {
        // given when
        String result = formatter.print(1000, Locale.KOREA);

        // then
        assertThat(result).isEqualTo("1,000");
    }

}