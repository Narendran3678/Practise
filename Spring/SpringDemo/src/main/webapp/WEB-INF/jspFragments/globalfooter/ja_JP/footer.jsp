<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		そのほかの購入方法：<a href="https://www.apple.com/jp/retail/" data-analytics-title="find an apple store">お近くのApple Store</a>、または<a href="https://locate.apple.com/jp/ja/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>Apple製品取扱店</a>で製品を購入することもできます。電話による購入、ご相談は<a href="https://www.apple.com/jp/store/0120-993-993/">0120-993-993</a>まで。English Sales Line, <a href="https://www.apple.com/jp/store/english/">Click here</a>.
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
<c:otherwise>https://www.apple.com/jp/legal/privacy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">プライバシーポリシー</a>
</c:if>
			<c:if test="${empty hideTermsOfService || not hideTermsOfService}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty termsOfServiceTarget}"><c:out value="${termsOfServiceTarget}"/></c:when>
<c:otherwise>https://www.apple.com/jp/legal/terms/site.html</c:otherwise></c:choose>" data-analytics-title="terms of use">利用規約</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/jp/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">販売条件</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/jp/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Legal Information</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/jp/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">サイトマップ</a>
</c:if>
		</div>
	</div>
</section>
