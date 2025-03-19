package com.demo.springdemo.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;

@Controller
public class IndexControllers {

    public static final String HEADERFEATURES_HEADERSUPPORTEDLOCALE = "headerFeatures_headerSupportedLocale";
    public static final String HEADERFEATURES_APPDISTURL = "headerFeatures_appDistUrl";
    public static final String HEADERFEATURES_GLOBALNAVURL = "headerFeatures_globalNavURL";
    public static final String REQUESTSCOPE_APPLE_LOCALE_SITECOUNTRYCODE = "requestScope_apple_locale_siteCountryCode";
    public static final String FOOTERFEATURES_HIDEPRIVACYPOLICY = "footerFeatures_hidePrivacyPolicy";
    public static final String FOOTERFEATURES_HIDETERMSOFSERVICE = "footerFeatures_hideTermsOfService";
    public static final String FOOTERFEATURES_HIDESALESANDREFUNDS = "footerFeatures_hideSalesAndRefunds";
    public static final String FOOTERFEATURES_HIDELEGAL = "footerFeatures_hideLegal";
    public static final String FOOTERFEATURES_HIDESITEMAP = "footerFeatures_hideSitemap";
    public static final String FOOTERFEATURES_HIDESTORE = "footerFeatures_hideStore";
    public static final String FOOTERFEATURES_HIDECHOOSECOUNTRY = "footerFeatures_hideChooseCountry";
    public static final String SOURCEAPPID = "sourceAppId";
    public static final String REQUESTSCOPE_APPLE_LOCALE_COUNTRY = "requestScope_apple_locale_country";

    private static final String PATH = "/error";
    @GetMapping("/")
    public String indexPage(
            @RequestParam(value = "language", required = false) String lanugage,
            @RequestParam(value = "locale", required = false) String locale,
            Model model, HttpServletRequest httpServletRequest) throws Exception {
        //http://localhost:8080/?locale=en_US&language=en_ES

        ServletContext context = httpServletRequest.getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/jspFragments/globalfooter/"+locale+"/footer.jsp");
        File file = new File(fullPath);
        System.out.println("FullPath..."+fullPath);
        if(!file.exists())
            locale = "en_US";

        System.out.println(locale);

        model.addAttribute(HEADERFEATURES_HEADERSUPPORTEDLOCALE,locale);;
        model.addAttribute(HEADERFEATURES_GLOBALNAVURL,"https://www.apple.com/");
        model.addAttribute(REQUESTSCOPE_APPLE_LOCALE_SITECOUNTRYCODE,"USA");
        model.addAttribute(REQUESTSCOPE_APPLE_LOCALE_COUNTRY,locale);
        return "index";
    }

    @GetMapping("/sample")
    public String samplePage(Model model) throws Exception {
        System.out.println("Index Page");
        model.addAttribute(HEADERFEATURES_HEADERSUPPORTEDLOCALE,"es_ES");
        model.addAttribute(HEADERFEATURES_GLOBALNAVURL,"https://www.apple.com/");
        model.addAttribute(REQUESTSCOPE_APPLE_LOCALE_SITECOUNTRYCODE,"Espana");
        model.addAttribute(REQUESTSCOPE_APPLE_LOCALE_COUNTRY,"Espana");
        return "sample";
    }

}
