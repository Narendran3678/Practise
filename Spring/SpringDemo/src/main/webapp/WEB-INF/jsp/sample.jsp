<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>First JSP</title>
    <link rel="stylesheet" href="https://www.apple.com/api-www/global-elements/global-header/v1/assets/globalheader.css">
    <link rel="stylesheet" type="text/css" href="https://www.apple.com/ac/globalfooter/7/en_US/styles/ac-globalfooter.built.css" />
</head>
<body>
    <c:import url="/WEB-INF/jspFragments/globalnav/ac-globalnav-en_US.jsp" charEncoding="UTF-8" />
    <h1>Hi</h1>
    <footer id="ac-globalfooter" class="no-js" lang="en-US" data-analytics-region="global footer" role="contentinfo" aria-labelledby="ac-gf-label">
        <div class="ac-gf-content">
            <h2 class="ac-gf-label" id="ac-gf-label">Apple Footer</h2>
            <c:import url="/WEB-INF/jspFragments/globalfooter/en_US/footer.jsp" charEncoding="UTF8"/>
        </div>
    </footer>
    <script type="text/javascript" src="https://www.apple.com/ac/globalfooter/7/en_US/scripts/ac-globalfooter.built.js"></script>
</body>
</html>