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

                <td>
                    <form method="post" action="#">
                        <input type="hidden" name="codigo" value="${evento.codigo}" />
                        <input type="button" value="Excluir"/>
                    </form>                                        
                </td>
            </tr>
        </c:forEach>

        <input type="submit" value="Novo Evento" href="novoevento.html"</>
    </tbody>
</table>
<%@include file="jspf/rodape.jspf" %>