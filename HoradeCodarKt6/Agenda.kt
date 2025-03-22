class Contato(
    var nome: String,
    var endereco: String,
    var telefone: String
)

fun main() {
    val agenda = mutableListOf<Contato>()
    var opcao: Int

    do {
        println("Menu da Agenda")
        println("1. Cadastrar 10 registros")
        println("2. Pesquisar registro por nome")
        println("3. Classificar registros por nome")
        println("4. Apresentar todos os registros")
        println("5. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarRegistros(agenda)
            2 -> pesquisarPorNome(agenda)
            3 -> classificarPorNome(agenda)
            4 -> mostrarRegistro(agenda)
            5 -> println("Saindo...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != 5)
}

fun cadastrarRegistros(agenda: MutableList<Contato>) {
    if (agenda.size >= 10) {
        println("A agenda está cheia!")
        return
    }
    for (i in agenda.size until 10) {
        println("Cadastrando contato ${i + 1}:")
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Endereço: ")
        val endereco = readLine() ?: ""
        print("Telefone: ")
        val telefone = readLine() ?: ""
        agenda.add(Contato(nome, endereco, telefone))
    }
    println("10 cadastros feitos com sucesso")
}

fun pesquisarPorNome(agenda: List<Contato>) {
    print("Digite o nome para pesquisar: ")
    val nome = readLine() ?: ""
    val contato = agenda.find { it.nome == nome }
    if (contato != null) {
        println("Contato encontrado:")
        exibirContato(contato)
    } else {
        println("Contato não encontrado")
    }
}

fun classificarPorNome(agenda: MutableList<Contato>) {
    agenda.sortBy { it.nome }
    println("Registros classificados por nome")
}

fun mostrarRegistro(agenda: List<Contato>) {
    if (agenda.isEmpty()) {
        println("Nenhum registro cadastrado")
    } else {
        println("--- Lista de Contatos ---")
        agenda.forEachIndexed { index, contato ->
            println("Contato ${index + 1}:")
            exibirContato(contato)
        }
    }
}
fun exibirContato(contato: Contato) {
    println("Nome: ${contato.nome}")
    println("Endereço: ${contato.endereco}")
    println("Telefone: ${contato.telefone}")
}