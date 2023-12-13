package com.directory.utils;
import com.directory.entity.Roles;
import com.google.gson.Gson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//@Component
public class EmployeeRoleConverter implements Converter<String,Roles> {
    @Override
    public Roles convert(String source) {
        System.out.println("SourceData..." + source);
        return new Gson().fromJson(source, Roles.class);

    }
}

