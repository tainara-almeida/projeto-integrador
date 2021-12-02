<%-- 
    Document   : cadastro
    Created on : 23/11/2021, 14:20:19
    Author     : Andrew
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <c:import url="../uteis/header.jsp"/>

    <head>
        <title>Cadastro de Venda</title>
    </head>
    <table id="products-table">
<tbody>
 <tr>
   <th>Produto</th>
   <th>Código</th>
   <th>Quantidade</th>
   <th>Preço</th>
   <th>Ações</th>
 </tr>
 <tr>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   <td>&nbsp;</td>
   <td>
     <button onclick="remove(this)" type="button">Remover</button>
   </td>
 </tr>
</tbody>
<tfoot>
 <tr>
   <td colspan="5" style="text-align: left;">
     <button onclick="AddTableRow()" type="button">Adicionar Produto</button>
   </td>
 </tr>
</tfoot>
</table>
    </body>
    <script>
        (function($) {
  remove = function(item) {
    var tr = $(item).closest('tr');

    tr.fadeOut(400, function() {
      tr.remove();  
    });

    return false;
  }
})(jQuery);
        
        (function($) {
  AddTableRow = function() {

    var newRow = $("<tr>");
    var cols = "";

    cols += '<td>&nbsp;</td>';
    cols += '<td>&nbsp;</td>';
    cols += '<td>&nbsp;</td>';
    cols += '<td>&nbsp;</td>';
    cols += '<td>';
    cols += '<button onclick="remove(this)" type="button">Remover</button>';
    cols += '</td>';

    newRow.append(cols);
    $("#products-table").append(newRow);

    return false;
  };
})(jQuery);
    </script>
</html>
