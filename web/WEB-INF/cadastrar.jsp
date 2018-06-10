<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>

<form method="POST" action="cadastrar.html">
    <table border="1">
        <tbody>
            <tr><td>Nome:<input type="text" name="nome" value="" size="40" /></td></tr>
            <tr><td>Senha:<input type="password" name="senha" value="" size="40"/></td></tr>
            <tr><td>Email:<input type="text" name="email" value="" size="40"/></td></tr>
            <tr>
                <td><input  type="submit" value="Cadastrar"/></td>
                <td><input type="reset" value="Limpar"/></td>
            </tr>        
        </tbody>
    </table>
</form>

<%@include file="jspf/rodape.jspf" %>