<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/commonTemplates/header.jsp" %>>
    
    
  
    <div class='container' id='content'>
      
      <h2>Your Order</h2>
      <form accept-charset="UTF-8" action="pay" class="simple_form form-horizontal new_order" id="new_order" method="post" novalidate="novalidate"><div style="margin:0;padding:0;display:inline">
        
        <div class='control-group'>
          <label class="string optional control-label" for="order_amount">Amount</label>
          <div class='controls'>
            <label class='checkbox'>
             <% double amount=(double)session.getAttribute("amount"); %>
             <%=amount %>
            </label>
            <input id="orderAmount" name="orderAmount" type="hidden" value="<%=amount %>" />
          </div>
        </div>
        
        <div class='form-actions'>
          <input class="btn btn btn-primary" name="commit" type="submit" value="Place Order" />
        </div>
      </form>
    </div>
    
   
   <%@include file="/WEB-INF/views/commonTemplates/footer.jsp" %>