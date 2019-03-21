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
    <title>Document</title>
</head>
<body>
    <%--@elvariable id="produto" type="br.edu.tavaresdu.springmvc.loja.model.Produto"--%>
    <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto">
        <div>
            <label>T&iacute;tulo</label>
            <form:input path="titulo"/>
            <forms:errors path="titulo"></forms:errors>
        </div>
        <div>
            <label>Descri&ccedil;&atilde;o</label>
            <form:textarea rows="10" cols="20" path="descricao"/>
            <forms:errors path="descricao"></forms:errors>
        </div>
        <div>
            <label>Data de lan&ccedil;amento</label>
            <form:input path="dataLancamento"/>
            <forms:errors path="dataLancamento"></forms:errors>
        </div>
        <div>
            <label>P&aacute;ginas</label>
            <form:input path="paginas"/>
            <forms:errors path="paginas"></forms:errors>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>Pre&ccedil;o ${tipoPreco}</label>
                <form:input path="precos[${status.index}].valor"/>
                <form:hidden path="precos[${status.index}].tipo" value="${tipoPreco}"/>
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form:form>
</body>
</html>
