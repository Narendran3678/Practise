package com.resourcebundle;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		resourceBundlerTest2();
	}

	public static void resourceBundlerTest1() {
		// Resource file must be in format
		// [FileName_LanguageCode_CountryCode.properties] under src folder
		// default locale
		Locale locale = Locale.getDefault();
		System.out.println(locale.getLanguage() + "-" + locale.getCountry());

		// Changed Locale
		Locale.setDefault(new Locale("en", "US"));
		Locale locale1 = Locale.getDefault();
		System.out.println(locale1.getLanguage() + "-" + locale1.getCountry());

		ResourceBundle bundle = ResourceBundle.getBundle("app-data");
		String message = bundle.getString("greeting-message");
		System.out.println(message);

		// different locale
		ResourceBundle bundle2 = ResourceBundle.getBundle("app-data", Locale.GERMANY);
		String message2 = bundle2.getString("greeting-message");
		System.out.println(message2);
	}
	public static void resourceBundlerTest2() {
		Locale defaultLocale = Locale.getDefault();
		System.out.println("Default Locale..."+defaultLocale);
		
		Locale locale = new Locale("en","US");
		ResourceBundle bundle = ResourceBundle.getBundle("RB",locale);
		Enumeration<String> keys = bundle.getKeys();
		System.out.println(bundle.getBaseBundleName());
		while(keys.hasMoreElements())
		{
			String keyStrs=keys.nextElement();
			System.out.println(keyStrs+"="+bundle.getString(keyStrs));
		}
	}
}
