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

    <form name="creditCard" method="post" action="${url}">
      Credit Card: <input type="text" name="cardinfo"/> <br/>
      <input type="submit" value="submit" />
    </form>

</c:if>



</body>
</html>