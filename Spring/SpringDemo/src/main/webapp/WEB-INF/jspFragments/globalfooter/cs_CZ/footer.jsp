<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		Další možnosti nákupu: <a href="https://locate.apple.com/cz/cs/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>Najdi si prodejce</a> poblíž. <span class="nowrap">Nebo volej 800 701 391.</span>
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">Copyright ©  <%= java.time.Year.now()  %> Apple Inc. Všechna práva vyhrazena.
		</div>
		<div class="ac-gf-footer-legal-links">
			<a class="ac-gf-footer-legal-link" href="https://www.apple.com/legal/privacy/cz/" data-analytics-title="privacy policy">Zásady ochrany soukromí</a>
			<a class="ac-gf-footer-legal-link" href="https://www.apple.com/legal/privacy/cz/cookies/" data-analytics-title="use of cookies">Používání cookies</a>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/legal/</c:otherwise></c:choose>" data-analytics-title="terms of use">Podmínky použití</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/cz/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Prodej a refundace</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/cz/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Mapa webu</a>
</c:if>
		</div>
	</div>
</section>
