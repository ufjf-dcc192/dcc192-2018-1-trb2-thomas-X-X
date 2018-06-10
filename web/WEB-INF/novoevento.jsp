<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<form method="post" action="novoevento.html">

    <label>Título:</label>
    <input type="text" name="titulo" value="" />

    <label>Valor Mínimo:</label>
    <input type="text" name="minimo" value="" />

    <label>Data do Evento:</label>
    <input type="text" name="dataInicio" value="" />
    
    <label>Data do Sorteio:</label>
    <input type="text" name="dataSorteio" value="" />
    
    <input type="submit" value="Criar"/>
    <input type="reset" value="Limpar"/>

</form>
<%@include file="jspf/rodape.jspf" %>