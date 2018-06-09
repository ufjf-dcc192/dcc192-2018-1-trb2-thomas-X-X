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
            <th>???</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="evento" items="${eventos}">
            <tr>
                <td>${evento.codigo}</td>
                <td>${evento.titulo}</td>
                <td>${evento.minimo}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.sorteio}" /></td>
                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${evento.data}" /></td>
                <td>
                    <form method="post" action="#">
                        <input type="hidden" name="codigo" value="${evento.codigo}" />
                        <input type="button" value="Excluir"/>
                    </form>

                </td>
                <a href="inscricao.html">Inscrever Participante</a>
            </tr>
        </c:forEach>
            <a href="novoevento.html">Criar Novo Evento</a>

    </tbody>
</table>
<%@include file="jspf/rodape.jspf" %>