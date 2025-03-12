<c:set var="appDistUrl" value="${headerFeatures_appDistUrl}" scope="request"/>
<c:set var="flagshipLocale" value="${headerFeatures_headerSupportedLocale}" scope="request"/>
<c:set var="globalNavUrl" value="${headerFeatures_globalNavURL}" scope="request"/>
<c:set var="choosecountryTitle" value="web_global_footer_choosecountry_title" scope="request"/>
<c:url var="chooseCountryUrl" value="https://account.apple.com/choose-country-region" scope="request"/>

<c:set var="hidePrivacyPolicy" scope="request">${footerFeatures_hidePrivacyPolicy}</c:set>
<c:set var="hideTermsOfService" scope="request">${footerFeatures_hideTermsOfService}</c:set>
<c:set var="hideSalesAndRefunds" scope="request">${footerFeatures_hideSalesAndRefunds}</c:set>
<c:set var="hideLegal" scope="request">${footerFeatures_hideLegal}</c:set>
<c:set var="hideSitemap" scope="request">${footerFeatures_hideSitemap}</c:set>
<c:set var="hideStore" scope="request">${footerFeatures_hideStore}</c:set>
<c:set var="hideChooseCountry" scope="request">${footerFeatures_hideChooseCountry}</c:set>

<c:set var="privacyPolicyTarget" scope="request"><spring:message code="${sourceAppId}.privacyPolicy" text=""/></c:set>
<c:set var="termsOfServiceTarget" scope="request"><spring:message code="${sourceAppId}.termsOfService" text=""/></c:set>
<c:set var="salesAndRefundsTarget"  scope="request"><spring:message code="${sourceAppId}.salesAndRefunds" text=""/></c:set>
<c:set var="legalTarget" scope="request"><spring:message code="${sourceAppId}.legal" text=""/></c:set>
<c:set var="sitemapTarget" scope="request"><spring:message code="${sourceAppId}.sitemap" text=""/></c:set>

<c:choose>
    <c:when test="${not empty requestScope_apple_locale_country}">
        <c:set var="flagCountryCode" value="${requestScope_apple_locale_country}" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="flagCountryCode" value="ES" scope="request"/>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${(flagCountryCode == 'RU') || (flagCountryCode == 'BY')}">
        <%@ include file="../jspFragments/legacyGlobalNavAndFooter.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="../jspFragments/globalNavAndFooter.jsp" %>
    </c:otherwise>
</c:choose>