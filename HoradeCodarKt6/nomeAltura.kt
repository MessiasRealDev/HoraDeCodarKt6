class Pessoa(
    var nome: String,
    var altura: Double
)

fun main() {
    val pessoas = mutableListOf<Pessoa>()
    var opcao: Int

    do {
        println("--- Menu de Opções ---")
        println("1. Cadastrar 15 pessoas")
        println("2. Mostrar pessoas com altura ≤ 1.5m")
        println("3. Mostrar pessoas com altura > 1.5m")
        println("4. Mostrar pessoas com altura > 1.5m e < 2.0m")
        println("5. Calcular a média das alturas")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarPessoas(pessoas)
            2 -> mostrarPessoasAte15m(pessoas)
            3 -> mostrarPessoasAcima15m(pessoas)
            4 -> mostrarPessoasEntre15mE20m(pessoas)
            5 -> calcularMediaAlturas(pessoas)
            6 -> println("Saindo...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != 6)
}

fun cadastrarPessoas(pessoas: MutableList<Pessoa>) {
    if (pessoas.size >= 15) {
        println("Já foram cadastradas 15 pessoas!")
        return
    }

    for (i in pessoas.size until 15) {
        println("Cadastrando pessoa ${i + 1}:")
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Altura (em metros): ")
        val altura = readLine()?.toDoubleOrNull() ?: 0.0

        pessoas.add(Pessoa(nome, altura))
    }

    println("15 pessoas cadastradas com sucesso!")
}

fun mostrarPessoasAte15m(pessoas: List<Pessoa>) {
    val filtradas = pessoas.filter { it.altura <= 1.5 }

    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa com altura ≤ 1.5m encontrada.")
    } else {
        println("--- Pessoas com altura ≤ 1.5m ---")
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
    }
}

fun mostrarPessoasAcima15m(pessoas: List<Pessoa>) {
    val filtradas = pessoas.filter { it.altura > 1.5 }

    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa com altura > 1.5m encontrada.")
    } else {
        println("--- Pessoas com altura > 1.5m ---")
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
    }
}

fun mostrarPessoasEntre15mE20m(pessoas: List<Pessoa>) {
    val filtradas = pessoas.filter { it.altura > 1.5 && it.altura < 2.0 }

    if (filtradas.isEmpty()) {
        println("Nenhuma pessoa com altura > 1.5m e < 2.0m encontrada.")
    } else {
        println("--- Pessoas com altura > 1.5m e < 2.0m ---")
        filtradas.forEach { println("Nome: ${it.nome}, Altura: ${it.altura}m") }
    }
}

fun calcularMediaAlturas(pessoas: List<Pessoa>) {
    if (pessoas.isEmpty()) {
        println("Nenhuma pessoa cadastrada para calcular a média.")
    } else {
        val media = pessoas.map { it.altura }.average()
        println("Média das alturas: ${"%.2f".format(media)}m")
    }
}