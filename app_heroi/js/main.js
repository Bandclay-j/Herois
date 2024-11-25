document.addEventListener("DOMContentLoaded", function() {
    const gridContainer = document.querySelector("#grid-herois");

    // Função para formatar a data para o padrão brasileiro
    const formatarData = (dataIso) => {
        const data = new Date(dataIso);
        return data.toLocaleDateString("pt-BR", {
            day: "2-digit",
            month: "2-digit",
            year: "numeric"
        });
    };

    // Função para carregar os hérois
    axios.get("http://localhost:8080/superHeroi")
    .then(response => {
        const herois = response.data;

        // Montar o HTML dos cards dos hérois
        herois.forEach(heroi => {
            const dataFormatada = formatarData(heroi.primeiraAparicao);

            const cardHTML = `
                <div class="col">
                    <div class="card h-100">
                        <img src="${heroi.imagem}" class="card-img-top" alt="${heroi.nome}">
                        <div class="card-body">
                            <h5 class="card-title"><strong>${heroi.nome}</strong></h5>
                            <p class="card-text"><strong>Apelido: </strong>${heroi.apelido}</p>
                            <p class="card-text"><strong>Super-poder: </strong>${heroi.superPoder}</p>
                            <p class="card-text"><strong>Fraqueza: </strong>${heroi.fraqueza}</p>
                            <p class="card-text"><strong>Historia de Origem: </strong>${heroi.historiaOrigem}</p>
                            <p class="card-text"><strong>Primeira aparição: </strong>${dataFormatada}</p>
                        </div>
                    </div>
                </div>
            `;
            gridContainer.innerHTML += cardHTML;
        });
    })
    .catch(error => {
        console.error("Erro ao carregar hérois", error);

        // Exibir mensagem de erro
        gridContainer.innerHTML = `
            <div class="alert alert-danger" role="alert">
                Não foi possível carregar os hérois. Tente novamente mais tarde.
            </div>
        `;
    });
});