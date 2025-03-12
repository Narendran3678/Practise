<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		Encore plus de façons de <span class="nowrap">magasiner :</span> <a href="https://www.apple.com/ca/fr/retail/" data-analytics-title="find an apple store">Trouvez un <span class="nowrap">Apple Store</span></a> ou un <a href="https://locate.apple.com/ca/fr/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>revendeur</a> à proximité. <span class="nowrap">Ou appelez au 1 800 MY-APPLE.</span>
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">© <%= java.time.Year.now()  %> Apple Inc. Tous droits réservés.
		</div>
		<div class="ac-gf-footer-legal-links">
			<c:if test="${empty hidePrivacyPolicy || not hidePrivacyPolicy}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty privacyPolicyTarget}"><c:out value="${privacyPolicyTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ca/fr/legal/privacy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">Politique de confidentialité</a>
</c:if>
			<a class="ac-gf-footer-legal-link" href="https://www.apple.com/legal/privacy/fr-ca/cookies/" data-analytics-title="use of cookies">Utilisation de témoins</a>
			<c:if test="${empty hideTermsOfService || not hideTermsOfService}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty termsOfServiceTarget}"><c:out value="${termsOfServiceTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ca/fr/legal/internet-services/terms/site.html</c:otherwise></c:choose>" data-analytics-title="terms of use">Conditions d’utilisation</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/xf/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Ventes et remboursements</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ca/fr/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Avis juridique</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/ca/fr/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Plan du site</a>
</c:if>
		</div>
	</div>
</section>
