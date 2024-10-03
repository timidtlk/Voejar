<!DOCTYPE html5>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Passagens Aéreas</title>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <h2 id="titulo">Passagens aéreas</h2>
        <form action="VooController" method="post">
            <div>
                <label for="origemID">Aeroporto de origem:</label>
                <select name="origem" id="origemID" class="campo">
                    <option value="gru">GRU</option>
                    <option value="cgh">CGH</option>
                    <option value="bsb">BSB</option>
                    <option value="gig">GIG</option>
                    <option value="vcp">VCP</option>
                </select>
            </div>
            <div>
                <label for="destinoID">Aeroporto de destino:</label>
                <select name="destino" id="destinoID" class="campo">
                    <option value="gru">GRU</option>
                    <option value="cgh">CGH</option>
                    <option value="bsb">BSB</option>
                    <option value="gig">GIG</option>
                    <option value="vcp">VCP</option>
                </select>
            </div>
            <div>
                <label for="idaID">Data de ida:</label>
                <input type="date" name="ida" id="idaID" class="campo">
            </div>
            <div>
                <label for="voltaID">Data de volta:</label>
                <input type="date" name="volta" id="voltaID" class="campo">
            </div>
            <div>
                <label for="pessoasID">Número de pessoas:</label>
                <input type="number" name="pessoas" id="pessoasID" class="campo">
            </div>
            <div>
                <input type="submit" value="Pesquisar" name="operacao">
            </div>
        </form>
    </body>
</html>