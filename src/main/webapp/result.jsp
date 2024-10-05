<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Voo, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Passagens encontradas</title>
        <link rel="stylesheet" href="css/result.css">
    </head>
    <body>

        <%
            Voo vooIda = (Voo) request.getAttribute("vooIda");
            Voo vooVolta = (Voo) request.getAttribute("vooVolta");

            ArrayList<Voo> listaIda = (ArrayList<Voo>) request.getAttribute("listaIda");
            ArrayList<Voo> listaVolta = (ArrayList<Voo>) request.getAttribute("listaVolta");
        %>

        <h1 id="title">Passagens aéreas encontradas</h1>
        <div class="box">
            <h3 class="subtitle">Voos de ida</h3>
            <ul>
                <li>Origem: <%= vooIda.getOrigem() %></li>
                <li>Destino: <%= vooIda.getDestino() %></li>
                <li>Data: <%= vooIda.getData() %></li>
            </ul>
            <%
                if(!listaIda.isEmpty()) {
                    out.println("<table>"+
                        "<thead>"
                            +"<tr>"
                                +"<th>Valor</th>"
                                +"<th>Horário</th>"
                            +"</tr>"
                        +"</thead>"
                        +"<tbody>");
                    for (Voo voo : listaIda) {
                        out.println("<tr>");
                        out.println("<td>" + (voo.getValor() * voo.getQtdPessoas()) + "</td>");
                        out.println("<td>" + (voo.getHorario()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>"
                        +"</table>");
                } else {
                    out.println("<p id='erro'>Não encontramos nenhum voo com suas especificações</p>");
                }
            %>
        </div>

        <div class="box">
            <h3 class="subtitle">Voos de volta</h3>
            <ul>
                <li>Origem: <%= vooVolta.getOrigem() %></li>
                <li>Destino: <%= vooVolta.getDestino() %></li>
                <li>Data: <%= vooVolta.getData() %></li>
            </ul>
            <%
                if(!listaVolta.isEmpty()) {
                    out.println("<table>"+
                        "<thead>"
                            +"<tr>"
                                +"<th>Valor</th>"
                                +"<th>Horário</th>"
                            +"</tr>"
                        +"</thead>"
                        +"<tbody>");
                    for (Voo voo : listaVolta) {
                        out.println("<tr>");
                        out.println("<td>" + (voo.getValor() * voo.getQtdPessoas()) + "</td>");
                        out.println("<td>" + (voo.getHorario()) + "</td>");
                        out.println("</tr>");
                    }
                    out.println("</tbody>"
                        +"</table>");
                } else {
                    out.println("<p id='erro'>Não encontramos nenhum voo com suas especificações</p>");
                }
            %>
        </div>

        <a href="index.jsp">Início</a>
    </body>
</html>