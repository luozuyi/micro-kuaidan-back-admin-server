package com.kuaidan.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class CustomDateConverterConfig implements Converter<String,Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(StringUtils.isBlank(source)){
            return null;
        }else if (source.length() == 10) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        try {
            return simpleDateFormat.parse(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
