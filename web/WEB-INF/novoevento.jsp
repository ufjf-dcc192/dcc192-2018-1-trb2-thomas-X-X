<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Novo Evento</p>
<form method="POST">
    <label>
        Título:<input type="text" name="titulo" value="" />
    </label>
    <label>
        Valor Mínimo:<input type="text" name="minimo" value="" />
    </label>
    <label>
        Data do Sorteio:<input type="text" name="dataSorteio" value="" />
    </label>
    <input type="submit" value="Criar"/>
</form>
<%@include file="../jspf/rodape.jspf" %>