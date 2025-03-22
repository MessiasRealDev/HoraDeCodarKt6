class Aluno(
    var nome: String,
    var notas: List<Double>
) {
    fun calcularMedia(): Double {
        return notas.average()
    }

    fun definirStatus(): String {
        return if (calcularMedia() >= 5) "Aprovado" else "Reprovado"
    }
}

fun main() {
    val agenda = mutableListOf<Aluno>()
    var opcao: Int

    do {
        println("--- Menu de Opções ---")
        println("1. Cadastrar 20 alunos")
        println("2. Pesquisar aluno por nome")
        println("3. Apresentar todos os alunos")
        println("4. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarAlunos(agenda)
            2 -> pesquisarPorNome(agenda)
            3 -> apresentarTodos(agenda)
            4 -> println("Saindo...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != 4)
}

fun cadastrarAlunos(agenda: MutableList<Aluno>) {
    if (agenda.size >= 20) {
        println("A agenda está cheia!")
        return
    }

    for (i in agenda.size until 20) {
        println("Cadastrando aluno ${i + 1}:")
        print("Nome: ")
        val nome = readLine() ?: ""
        val notas = mutableListOf<Double>()

        for (j in 1..4) {
            print("Nota $j: ")
            val nota = readLine()?.toDoubleOrNull() ?: 0.0
            notas.add(nota)
        }

        agenda.add(Aluno(nome, notas))
    }

    agenda.sortBy { it.nome }
    println("20 alunos cadastrados e classificados por nome!")
}

fun pesquisarPorNome(agenda: List<Aluno>) {
    print("Digite o nome para pesquisar: ")
    val nome = readLine() ?: ""
    val aluno = agenda.find { it.nome.equals(nome, ignoreCase = true) }

    if (aluno != null) {
        println("Aluno encontrado:")
        exibirAluno(aluno)
    } else {
        println("Aluno não encontrado.")
    }
}

fun apresentarTodos(agenda: List<Aluno>) {
    if (agenda.isEmpty()) {
        println("Nenhum aluno cadastrado.")
    } else {
        println("--- Lista de Alunos ---")
        agenda.forEach { exibirAluno(it) }
    }
}

fun exibirAluno(aluno: Aluno) {
    println("Nome: ${aluno.nome}")
    println("Notas: ${aluno.notas.joinToString(", ")}")
    println("Média: ${aluno.calcularMedia()}")
    println("Status: ${aluno.definirStatus()}")
}