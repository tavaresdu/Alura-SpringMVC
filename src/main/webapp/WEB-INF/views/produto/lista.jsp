<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!doctype html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Casa do C&oacute;digo</title>
    <c:url value="/resources/css" var="cssPath" />
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
    <link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css">
    <style type="text/css">
        body {
            padding: 60px 0px;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">
                    Casa do Código
                </a>
            </div>
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="${s:mvcUrl('PC#listar').build()}">
                            Lista de Produtos
                        </a>
                    </li>
                    <li>
                        <a href="${s:mvcUrl('PC#form').build()}">
                            Cadastro de Produtos
                        </a>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div>
    </nav>
    <div class="container">
        <h1>Lista de Produtos</h1>
        <div><a href="/casadocodigo/produto/form">Cadastrar Produto</a></div>
        <div>${mensagem}</div>
        <table class="table table-bordered table-striped table-hover">
            <tr>
                <th>T&iacute;tulo</th>
                <th>Descri&ccedil;&atilde;o</th>
                <th>N&uacute;mero de P&aacute;ginas</th>
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a></td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>