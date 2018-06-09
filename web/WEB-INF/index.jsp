<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/cabecalhoInicial.jspf" %>
<p>Bem vindo</p>
<form method="POST" action="index.html">
    <table border="1">
        <tbody>
            <tr>
                Email:<td><input type="text" name="email" value="" size="50" /></td>
            </tr>
            <tr>
                Senha:<td><input type="password" name="senha" value="" size="50"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="Entrar"/></td>
                   <form method="get" action="cadastrar.html">
                        <td><input type="submit" value="Cadastrar"/></td>
                   </form>
                   </tr>        
        </tbody>
        
    </table>
<%@include file="jspf/rodapeInicial.jspf" %>