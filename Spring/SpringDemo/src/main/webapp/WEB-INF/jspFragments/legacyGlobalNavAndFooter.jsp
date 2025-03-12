
<c:choose>
  <c:when test="${not empty appDistUrl}">
    <link rel="stylesheet" type="text/css" href="${appDistUrl}/globalnav/7/${flagshipLocale}/styles/ac-globalnav.built.css" />
    <script type="text/stache" id="globalNav">
        <c:import url="/WEB-INF/jspFragments/legacy-globalnav/${flagshipLocale}/ac-globalnav.jsp" charEncoding="UTF-8" />
        <c:if test="${(empty showOnlyAppleLogo || not showOnlyAppleLogo)}">
        <script type="text/javascript" src="${appDistUrl}/globalnav/7/${flagshipLocale}/scripts/ac-globalnav.built.js"></script>
        </c:if>
    </script>

    <link rel="stylesheet" type="text/css" href="${appDistUrl}/globalfooter/7/${flagshipLocale}/styles/ac-globalfooter.built.css" />
    <script type="text/stache" id="globalFooter">
        <footer id="ac-globalfooter" class="no-js" lang="en-US" data-analytics-region="global footer" role="contentinfo" aria-labelledby="ac-gf-label">
            <div class="ac-gf-content">
                <h2 class="ac-gf-label" id="ac-gf-label">Apple Footer</h2>
                <c:import url="/WEB-INF/jspFragments/globalfooter/${flagshipLocale}/footer.jsp" charEncoding="UTF8"/>
            </div>
        </footer>
        <script type="text/javascript" src="${appDistUrl}/globalfooter/7/${flagshipLocale}/scripts/ac-globalfooter.built.js"></script>
    </script>
  </c:when>
  <c:otherwise>
    <link rel="stylesheet" type="text/css" href="${globalNavUrl}/ac/globalnav/7/${flagshipLocale}/styles/ac-globalnav.built.css" />
    <script type="text/stache" id="globalNav">
        <c:import url="/WEB-INF/jspFragments/legacy-globalnav/${flagshipLocale}/ac-globalnav.jsp" charEncoding="UTF-8" />
        <c:if test="${(empty showOnlyAppleLogo || not showOnlyAppleLogo)}">
        <script type="text/javascript" src="${globalNavUrl}/ac/globalnav/7/${flagshipLocale}/scripts/ac-globalnav.built.js"></script>
        </c:if>
    </script>

    <link rel="stylesheet" type="text/css" href="${globalNavUrl}/ac/globalfooter/7/${flagshipLocale}/styles/ac-globalfooter.built.css" />
    <script type="text/stache" id="globalFooter">
        <footer id="ac-globalfooter" class="no-js" lang="en-US" data-analytics-region="global footer" role="contentinfo" aria-labelledby="ac-gf-label">
            <div class="ac-gf-content">
                <h2 class="ac-gf-label" id="ac-gf-label">Apple Footer</h2>
                <c:import url="/WEB-INF/jspFragments/globalfooter/${flagshipLocale}/footer.jsp" charEncoding="UTF8"/>
            </div>
        </footer>
        <script type="text/javascript" src="${globalNavUrl}/ac/globalfooter/7/${flagshipLocale}/scripts/ac-globalfooter.built.js"></script>
    </script>
  </c:otherwise>
</c:choose>
