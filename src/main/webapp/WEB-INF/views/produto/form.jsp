<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <form action="/casadocodigo/produto" method="post">
        <div>
            <label>T&iacute;tulo</label>
            <input type="text" name="titulo">
        </div>
        <div>
            <label>Descri&ccedil;&atilde;o</label>
            <textarea rows="10" cols="20" name="descricao"></textarea>
        </div>
        <div>
            <label>P&aacute;ginas</label>
            <input type="text" name="paginas">
        </div>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
