package com.demo.springdemo.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final Map<String, String[]> modifiableParameters;
    private Map<String, String[]> allParameters = null;
    public CustomHttpServletRequestWrapper(final HttpServletRequest request,
                                           final Map<String, String[]> additionalParams)
    {
        super(request);
        modifiableParameters = new TreeMap<String, String[]>();
        modifiableParameters.putAll(additionalParams);
    }

    @Override
    public String getParameter(final String name)
    {
        System.out.println("GetParameter Invoked");
        String[] strings = getParameterMap().get(name);
        if (strings != null)
        {
            return strings[0];
        }
        return null;
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        System.out.println("GetParameterMap Invoked");
        if (allParameters == null)
        {
            allParameters = new TreeMap<String, String[]>();
            allParameters.putAll(super.getParameterMap());
            allParameters.putAll(modifiableParameters);
        }
        return Collections.unmodifiableMap(allParameters);
    }

    @Override
    public Enumeration<String> getParameterNames()
    {
        System.out.println("GetParameterNames Invoked");
        return Collections.enumeration(getParameterMap().keySet());
    }

    @Override
    public String[] getParameterValues(final String name)
    {
        System.out.println("GetParameterValues Invoked");
        return getParameterMap().get(name);
    }
}
