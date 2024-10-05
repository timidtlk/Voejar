<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Voo, java.util.ArrayList" %>
<!DOCTYPE html5>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Passagens Aéreas</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>

        <%
            Cookie[] cookies = request.getCookies();
            String origem = "";
            String destino = "";
            String ida = "";
            String volta = "";
            String pessoas = "";

            if (cookies != null) {
                for( Cookie c : cookies ) {
                    if ("origem".equals(c.getName())) {
                        origem = c.getValue();
                        continue;
                    } else if ("destino".equals(c.getName())) {
                        destino = c.getValue();
                        continue;
                    } else if ("ida".equals(c.getName())) {
                        ida = c.getValue();
                        continue;
                    } else if ("volta".equals(c.getName())) {
                        volta = c.getValue();
                        continue;
                    } else if ("pessoas".equals(c.getName())) {
                        pessoas = c.getValue();
                        continue;
                    }
                }
            }
        %>

        <h1 id="titulo">Passagens aéreas</h1>
        <form action="VooController" method="post">
            <div>
                <label for="origemID">Aeroporto de origem:</label>
                <select name="origem" id="origemID" class="campo">
                    <option value="GRU" <%= ("GRU".equals(origem) ? "selected" : "") %>>GRU</option>
                    <option value="CGH" <%= ("CGH".equals(origem) ? "selected" : "") %>>CGH</option>
                    <option value="BSB" <%= ("BSB".equals(origem) ? "selected" : "") %>>BSB</option>
                    <option value="GIG" <%= ("GIG".equals(origem) ? "selected" : "") %>>GIG</option>
                    <option value="VCP" <%= ("VCP".equals(origem) ? "selected" : "") %>>VCP</option>
                </select>
            </div>
            <div>
                <label for="destinoID">Aeroporto de destino:</label>
                <select name="destino" id="destinoID" class="campo">
                    <option value="GRU" <%= ("GRU".equals(destino) ? "selected" : "") %>>GRU</option>
                    <option value="CGH" <%= ("CGH".equals(destino) ? "selected" : "") %>>CGH</option>
                    <option value="BSB" <%= ("BSB".equals(destino) ? "selected" : "") %>>BSB</option>
                    <option value="GIG" <%= ("GIG".equals(destino) ? "selected" : "") %>>GIG</option>
                    <option value="VCP" <%= ("VCP".equals(destino) ? "selected" : "") %>>VCP</option>
                </select>
            </div>
            <div>
                <label for="idaID">Data de ida:</label>
                <input type="date" name="ida" id="idaID" class="campo" value="<%= ida %>">
            </div>
            <div>
                <label for="voltaID">Data de volta:</label>
                <input type="date" name="volta" id="voltaID" class="campo" value="<%= volta %>">
            </div>
            <div>
                <label for="pessoasID">Número de pessoas:</label>
                <input type="number" name="pessoas" id="pessoasID" class="campo" value="<%= pessoas %>">
            </div>
            <div>
                <input type="submit" value="Pesquisar" name="operacao">
            </div>
        </form>
    </body>
</html>