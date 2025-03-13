<c:choose>
  <c:when test="${not empty appDistUrl}">
      <link rel="stylesheet" href="${globalNavUrl}/api-www/global-elements/global-header/v1/assets/globalheader.css">
      <%  try { %>
      <c:import url="/WEB-INF/jspFragments/globalnav/ac-globalnav-${flagshipLocale}.jsp" charEncoding="UTF-8" />
      <%  } catch (Exception e) { } %>
      <c:if test="${(empty showOnlyAppleLogo || not showOnlyAppleLogo)}">
        <script id="globalHeaderScript" type="text/javascript" src="${appDistUrl}/api-www/global-elements/global-header/v1/assets/globalheader.umd.js"></script>
        <%  try { %>
        <c:import url="/WEB-INF/jspFragments/globalnav/ac-globalnav-data-${flagshipLocale}.jsp" charEncoding="UTF-8" />
        <%  } catch (Exception e) { } %>
      </c:if>


    <link rel="stylesheet" type="text/css" href="${appDistUrl}/globalfooter/7/${flagshipLocale}/styles/ac-globalfooter.built.css" />

    <footer id="ac-globalfooter" class="no-js" lang="en-US" data-analytics-region="global footer" role="contentinfo" aria-labelledby="ac-gf-label">
        <div class="ac-gf-content">
            <h2 class="ac-gf-label" id="ac-gf-label">Apple Footer</h2>
            <c:import url="/WEB-INF/jspFragments/globalfooter/${flagshipLocale}/footer.jsp" charEncoding="UTF-8"/>
        </div>
    </footer>
    <script type="text/javascript" src="${appDistUrl}/globalfooter/${flagshipLocale}/scripts/ac-globalfooter.built.js"></script>

  </c:when>
  <c:otherwise>
      <link rel="stylesheet" href="${globalNavUrl}/api-www/global-elements/global-header/v1/assets/globalheader.css">
      <%  try { %>
      <c:import url="/WEB-INF/jspFragments/globalnav/ac-globalnav-${flagshipLocale}.jsp" charEncoding="UTF-8" />
      <%  } catch (Exception e) { } %>
      <c:if test="${(empty showOnlyAppleLogo || not showOnlyAppleLogo)}">
        <script id="globalHeaderScript" type="text/javascript" src="${globalNavUrl}/api-www/global-elements/global-header/v1/assets/globalheader.umd.js"></script>
        <%  try { %>
        <c:import url="/WEB-INF/jspFragments/globalnav/ac-globalnav-data-${flagshipLocale}.jsp" charEncoding="UTF-8" />
        <%  } catch (Exception e) { } %>
      </c:if>

    <link rel="stylesheet" type="text/css" href="${globalNavUrl}/ac/globalfooter/7/${flagshipLocale}/styles/ac-globalfooter.built.css" />

        <footer id="ac-globalfooter" class="no-js" lang="en-US" data-analytics-region="global footer" role="contentinfo" aria-labelledby="ac-gf-label">
            <div class="ac-gf-content">
                <h2 class="ac-gf-label" id="ac-gf-label">Apple Footer</h2>
                <c:import url="/WEB-INF/jspFragments/globalfooter/${flagshipLocale}/footer.jsp" charEncoding="UTF-8"/>
            </div>
        </footer>
        <script type="text/javascript" src="${globalNavUrl}/ac/globalfooter/7/${flagshipLocale}/scripts/ac-globalfooter.built.js"></script>

  </c:otherwise>
</c:choose>
