<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalho.jspf" %>
<p><h2>Bem vindo</h2></p>
<form method="POST" action="index.html">
    <table border="1">
        <tbody>
            <tr>
                <td>Email:<input type="text" name="email" value="" size="50" /></td>
            </tr>
            <tr>
                <td>Senha:<input type="password" name="senha" value="" size="50"/></td>
            </tr>
                <tr>

                   <form method="get" action="cadastrar.html">
                        <td><input  type="submit" value="Entrar"/></td>
                        <td><input type="submit" value="Cadastrar"/></td>
                   </form>
                   </tr>        
        </tbody>
        
    </table>
<%@include file="jspf/rodape.jspf" %>