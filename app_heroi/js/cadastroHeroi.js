function cadastrarHeroi() {
    //obtem os valores dos campos do formulário
    var nome = $("#nome").val();
    var apelido = $("#apelido").val();
    var superPoder = $("#superPoder").val();
    var fraqueza = $("#fraqueza").val();
    var historiaOrigem = $("#historiaOrigem").val();
    var primeiraAparicao = $("#primeiraAparicao").val();
    var imagem = $("#imagem").val();

    axios.post("http://localhost:8080/superHeroi", {
        "nome": nome,
        "apelido": apelido,
        "superPoder": superPoder,
        "fraqueza": fraqueza,
        "historiaOrigem": historiaOrigem,
        "primeiraAparicao": primeiraAparicao,
        "imagem": imagem

    })
    .then(function (response) {
        console.log(response);
        alert("Herói cadastrado com sucesso!");
        document.location = "listaHeroi.html";
    })
    .catch(function (error) {
        console.log(error);
    });
}

