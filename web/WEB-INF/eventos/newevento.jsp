<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Novo Evento:</p>
<form method="POST">
    <input type="text" name="titulo" value="" />
    <input type="submit" />
</form>
<%@include file="../jspf/rodape.jspf" %>