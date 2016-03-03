<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
  <c:if test="${not empty id}">
     <p>ItemID: ${id}
     </p>
</c:if>

  <c:if test="${not empty name}">
     <p>Item Name: ${name}
     </p>
</c:if>

  <c:if test="${not empty price}">
     <p>Buy Price: ${price}
     </p>
</c:if>

  <c:if test="${not empty card}">
     <p>Credit Card: ${card}
     </p>
</c:if>

  <c:if test="${not empty time}">
     <p>Time: ${time}
     </p>
</c:if>


</body>
</html>