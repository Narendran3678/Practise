<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		More ways to shop: <a href="https://www.apple.com/ae/retail/" data-analytics-title="find an apple store">Find an Apple Store</a> or <a href="https://locate.apple.com/ae/en/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>other retailer</a> near you. <span class="nowrap">Or call 8000 444 0396.</span>
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">Copyright © <%= java.time.Year.now()  %> Apple Inc. All rights reserved.
		</div>
		<div class="ac-gf-footer-legal-links">
			<c:if test="${empty hidePrivacyPolicy || not hidePrivacyPolicy}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty privacyPolicyTarget}"><c:out value="${privacyPolicyTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ae/privacy/privacy-policy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">Privacy Policy</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ae/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Sales and Refunds</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ae/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Legal</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ae/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Site Map</a>
</c:if>
		</div>
	</div>
</section>
