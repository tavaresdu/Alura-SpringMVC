<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Casa do C&oacute;digo</title>
</head>
<body>
    <h1>Casa do C&oacute;digo</h1>
    <div><a href="/casadocodigo/produto/form">Cadastrar Produto</a></div>
    <div>${mensagem}</div>
    <table>
        <tr>
            <td>T&iacute;tulo</td>
            <td>Descri&ccedil;&atilde;o</td>
            <td>N&uacute;mero de P&aacute;ginas</td>
        </tr>
        <c:forEach items="${produtos}" var="produto">
            <tr>
                <td>${produto.titulo}</td>
                <td>${produto.descricao}</td>
                <td>${produto.paginas}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>