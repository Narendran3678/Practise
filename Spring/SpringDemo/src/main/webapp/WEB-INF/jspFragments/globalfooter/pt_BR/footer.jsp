<%@ page pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <style>#ac-globalfooter .ac-gf-footer-legal-link:last-child  {margin: 3px 0 0 0;} #ac-globalfooter .ac-gf-footer {border-top: none;}</style><section class="ac-gf-footer">
	<c:if test="${empty hideStore || not hideStore}">
<div class="ac-gf-footer-shop" x-ms-format-detection="none">
		<p>Outras formas de comprar: <a href="https://www.apple.com/br/retail/" data-analytics-title="find an apple store">encontre uma Apple Store</a> ou <a href="https://locate.apple.com/br/pt/" data-analytics-title="other retailers or resellers" data-analytics-exit-link>revendedor Apple</a> na sua região. <span class="nowrap">Ou ligue para 0800-761-0867.</span> Rua Leopoldo Couto de Magalhães Jr., 700, 7º andar, Itaim Bibi. São Paulo, SP. CEP: 04542-000. </p>
		<p>Os Serviços de Mídia da Apple são fornecidos pela Apple Services LATAM LLC.</p>
	</div>
</c:if>
	<c:if test="${(empty hideChooseCountry || not hideChooseCountry) && requestScope_apple_locale_siteCountryCode ne 'CHN'}">
<div class="ac-gf-footer-locale"><c:import url="/WEB-INF/jspFragments/flag.jsp" charEncoding="UTF-8"/></div>
</c:if>
	<div class="ac-gf-footer-legal">
		<div class="ac-gf-footer-legal-copyright">Copyright © <%= java.time.Year.now()  %> Apple Inc. Todos os direitos reservados. Apple Computer Brasil Ltda. CNPJ: 00.623.904/0003-35
		</div>
		<div class="ac-gf-footer-legal-links">
			<c:if test="${empty hidePrivacyPolicy || not hidePrivacyPolicy}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty privacyPolicyTarget}"><c:out value="${privacyPolicyTarget}"/></c:when>
<c:otherwise>https://www.apple.com/br/legal/privacy/</c:otherwise></c:choose>" data-analytics-title="privacy policy">Política de Privacidade</a>
</c:if>
			<c:if test="${empty hideSalesAndRefunds || not hideSalesAndRefunds}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty salesAndRefundsTarget}"><c:out value="${salesAndRefundsTarget}"/></c:when>
<c:otherwise>https://www.apple.com/br/shop/goto/help/sales_refunds</c:otherwise></c:choose>" data-analytics-title="sales and refunds">Política de vendas</a>
</c:if>
			<c:if test="${empty hideLegal || not hideLegal}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty legalTarget}"><c:out value="${legalTarget}"/></c:when>
<c:otherwise>https://www.apple.com/br/legal/</c:otherwise></c:choose>" data-analytics-title="legal">Avisos legais</a>
</c:if>
			<c:if test="${(not empty customLinkText || customLinkText) and (not empty customLinkTarget || customLinkTarget)}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty customLinkTarget}"><c:out value="${customLinkTarget}"/></c:when>
 <c:otherwise>#</c:otherwise></c:choose>">${customLinkText}</a>
</c:if>
<c:if test="${empty hideSitemap || not hideSitemap}">
 <a class="ac-gf-footer-legal-link" href="<c:choose><c:when test="${not empty sitemapTarget}"><c:out value="${sitemapTarget}"/></c:when>
<c:otherwise>https://www.apple.com/br/sitemap/</c:otherwise></c:choose>" data-analytics-title="site map">Mapa do site</a>
</c:if>
		</div>
	</div>
</section>
