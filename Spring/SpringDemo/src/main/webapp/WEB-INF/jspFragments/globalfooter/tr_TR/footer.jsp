<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		Diğer alışveriş seçenekleri: Yakınınızda <a href="https://www.apple.com/tr/retail/" data-analytics-title="find an apple store">bir Apple Store</a> veya <a href="https://locate.apple.com/tr/tr/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>başka bir yetkili satıcı bulun</a>. Veya 00800 448 829 873 ya da 0216 282 15 11 numaralı telefonu arayın.
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">Telif Hakkı © <%= java.time.Year.now()  %> Apple Inc. Tüm hakları saklıdır.
		</div>
		<div class="ac-gf-footer-legal-links">
			<c:if test="${empty hidePrivacyPolicy || not hidePrivacyPolicy}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty privacyPolicyTarget}"><c:out value="${privacyPolicyTarget}"/></c:when>
<c:otherwise>https://www.apple.com/tr/privacy/privacy-policy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">Gizlilik Politikası</a>
</c:if>
			<a class="ac-gf-footer-legal-link" href="https://www.apple.com/legal/privacy/tr/cookies/" data-analytics-title="use of cookies">Çerezlerin Kullanımı</a>
			<c:if test="${empty hideTermsOfService || not hideTermsOfService}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty termsOfServiceTarget}"><c:out value="${termsOfServiceTarget}"/></c:when>
<c:otherwise>https://www.apple.com/legal/internet-services/terms/site.html</c:otherwise></c:choose>" data-analytics-title="terms of use">Kullanım Şartları</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/tr/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Satış ve Para İadesi</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/tr/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Yasal Bilgiler</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/tr/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Site Haritası</a>
</c:if>
			<a class="ac-gf-footer-legal-link" href="https://www.belgemodul.com/sirket/329" data-analytics-title="information society services">Bilgi Toplumu Hizmetleri</a>
		</div>
	</div>
</section>
