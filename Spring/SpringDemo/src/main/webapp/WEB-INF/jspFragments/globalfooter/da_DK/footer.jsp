<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		Flere måder at shoppe på: <a href="https://locate.apple.com/dk/da/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>Find en forhandler</a> i nærheden. <span class="nowrap">Eller ring 80 24 08 35.</span>
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">Copyright © <%= java.time.Year.now()  %> Apple Inc. Alle rettigheder forbeholdes.
		</div>
		<div class="ac-gf-footer-legal-links">
			<c:if test="${empty hidePrivacyPolicy || not hidePrivacyPolicy}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty privacyPolicyTarget}"><c:out value="${privacyPolicyTarget}"/></c:when>
<c:otherwise>https://www.apple.com/dk/legal/privacy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">Anonymitetspolitik</a>
</c:if>
			<a class="ac-gf-footer-legal-link" href="https://www.apple.com/legal/privacy/dk/cookies/" data-analytics-title="use of cookies">Brug af cookies</a>
			<c:if test="${empty hideTermsOfService || not hideTermsOfService}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty termsOfServiceTarget}"><c:out value="${termsOfServiceTarget}"/></c:when>
<c:otherwise>https://www.apple.com/dk/legal/terms/site.html</c:otherwise></c:choose>" data-analytics-title="terms of use">Betingelser for brug</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/dk/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Salg og refundering</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/dk/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Juridisk tekst</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/dk/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Oversigt</a>
</c:if>
		</div>
	</div>
</section>
