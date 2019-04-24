<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="forms" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
        <h1>Cadastro de Produto</h1>
        <%--@elvariable id="produto" type="br.edu.tavaresdu.springmvc.loja.model.Produto"--%>
        <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto"
                   enctype="multipart/form-data">
            <div class="form-group">
                <label>T&iacute;tulo</label>
                <form:input cssClass="form-control" path="titulo"/>
                <forms:errors path="titulo"></forms:errors>
            </div>
            <div class="form-group">
                <label>Descri&ccedil;&atilde;o</label>
                <form:textarea cssClass="form-control" path="descricao"/>
                <forms:errors path="descricao"></forms:errors>
            </div>
            <div class="form-group">
                <label>Data de lan&ccedil;amento</label>
                <form:input cssClass="form-control" path="dataLancamento"/>
                <forms:errors path="dataLancamento"></forms:errors>
            </div>
            <div class="form-group">
                <label>P&aacute;ginas</label>
                <form:input cssClass="form-control" path="paginas"/>
                <forms:errors path="paginas"></forms:errors>
            </div class="form-group">
            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>Pre&ccedil;o ${tipoPreco}</label>
                    <form:input cssClass="form-control" path="precos[${status.index}].valor"/>
                    <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
                </div>
            </c:forEach>
            <div class="form-group">
                <label>Sum&aacute;rio</label>
                <input class="form-control" type="file" name="sumario">
            </div>
            <button class="btn btn-primary" type="submit">Cadastrar</button>
        </form:form>
    </div>
</body>
</html>
