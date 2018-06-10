<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<table border="1">
    <thead>
        <tr>
            <th>Codigo</th>
            <th>Título</th>
            <th>Valor Mínimo</th>
            <th>DataInicial</th>
            <th>DataSorteio</th>
            <th>Opções</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="evento" items="${eventos}">
            <tr>
                <td>${evento.codigo}</td>
                <td>${evento.titulo}</td>
                <td>R$ ${evento.minimo}</td>
                <td>${evento.data}></td>
                <td>${evento.sorteio}</td>
                
                <c:if test="${evento.isSorteado()}">
                <td>
                    <form method="get" action="inscricao.html">
                        <input type="hidden" name="codigo" value="${evento.codigo}" />
                        <input type="hidden" name="codigoParticipante" value="${codigoParticipante}" />
                        <input type="submit" value="Inscrever"/>
                    </form>                                        
                </td>  
                </c:if>
                
                <c:if test="${!evento.isSorteado()}">
                <td>
                    <form method="get" action="inscritos.html">
                        <input type="hidden" name="codigo" value="${evento.codigo}">
                        <input type="hidden" name="codigoParticipante" value="${codigoParticipante}">                      
                        <input type="submit" value="Sorteio"/>
                    </form>            
                </td>
                </c:if>

            </tr>
        </c:forEach>
            
    </tbody>
</table>
<a href="novoevento.html">Novo Evento</a>
<%@include file="jspf/rodape.jspf" %>