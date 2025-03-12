<%-- <%@include file="common/headerImport.jsp" %> --%>
<c:url scope="application" var="chooseYourCountry_action" value="https://account.apple.com/choose-country-region"/>
<a class="ac-gf-footer-locale-link choose" title="Choose" href="https://account.apple.com/choose-country-region?returnURL=http://localhost:8080/?locale=${flagshipLocale}">
  ${requestScope_apple_locale_siteCountryCode}
</a>