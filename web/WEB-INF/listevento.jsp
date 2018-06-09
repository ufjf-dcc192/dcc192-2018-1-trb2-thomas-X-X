<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<p>Eventos</p>
<p><a href="novoevento.html">[Adicionar]</a></p>
<table>
    <thead>
        <tr>
            <th>Codigo</th>
            <th>Título</th>
            <th>Mínimo</th>
            <th>DataInicial</th>
            <th>DataSorteio</th>
            <th>???</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="evento" items="${eventos}">
            <tr>
                <td>${evento}</td>
                <td>${tarefa.titulo}</td>
                <td>
                    <form method="post" action="tarefa-exclui.html">
                        <input type="hidden" name="id" value="${tarefa.id}" />
                        <input type="submit" value="X"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../jspf/rodape.jspf" %>