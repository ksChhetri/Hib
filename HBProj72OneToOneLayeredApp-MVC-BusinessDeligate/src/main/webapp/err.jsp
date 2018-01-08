<%@page  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<c:if test="${errMsg ne null }">
   ${errMsg}
</c:if>

