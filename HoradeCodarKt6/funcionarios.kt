class Funcionario(
    var matricula: Int,
    var nome: String,
    var salario: Double
)

fun main() {
    val funcionarios = mutableListOf<Funcionario>()
    var opcao: Int

    do {
        println("--- Menu de Opções ---")
        println("1. Cadastrar 20 funcionários")
        println("2. Pesquisar funcionário por matrícula")
        println("3. Mostrar funcionários com salário > R\$1.000,00")
        println("4. Mostrar funcionários com salário < R\$1.000,00")
        println("5. Mostrar funcionários com salário = R\$1.000,00")
        println("6. Sair")
        print("Escolha uma opção: ")
        opcao = readLine()?.toIntOrNull() ?: 0

        when (opcao) {
            1 -> cadastrarFuncionarios(funcionarios)
            2 -> pesquisarPorMatricula(funcionarios)
            3 -> mostrarFuncionariosAcima1000(funcionarios)
            4 -> mostrarFuncionariosAbaixo1000(funcionarios)
            5 -> mostrarFuncionariosIgual1000(funcionarios)
            6 -> println("Saindo...")
            else -> println("Opção inválida! Tente novamente.")
        }
    } while (opcao != 6)
}

fun cadastrarFuncionarios(funcionarios: MutableList<Funcionario>) {
    if (funcionarios.size >= 20) {
        println("Já foram cadastrados 20 funcionários!")
        return
    }

    for (i in funcionarios.size until 20) {
        println("Cadastrando funcionário ${i + 1}:")
        print("Matrícula: ")
        val matricula = readLine()?.toIntOrNull() ?: 0
        print("Nome: ")
        val nome = readLine() ?: ""
        print("Salário: R$")
        val salario = readLine()?.toDoubleOrNull() ?: 0.0

        funcionarios.add(Funcionario(matricula, nome, salario))
    }


    funcionarios.sortBy { it.matricula }  // Classificar por matrícula após o cadastro
    println("20 funcionários cadastrados e classificados por matrícula!")
}

fun pesquisarPorMatricula(funcionarios: List<Funcionario>) {
    print("Digite a matrícula para pesquisar: ")
    val matricula = readLine()?.toIntOrNull() ?: 0
    val funcionario = funcionarios.find { it.matricula == matricula }

    if (funcionario != null) {
        println("Funcionário encontrado:")
        exibirFuncionario(funcionario)
    } else {
        println("Funcionário não encontrado.")
    }
}
fun mostrarFuncionariosAcima1000(funcionarios: List<Funcionario>) {
    val filtrados = funcionarios.filter { it.salario > 1000.0 }

    if (filtrados.isEmpty()) {
        println("Nenhum funcionário com salário > R\$1.000,00 encontrado.")
    } else {
        println("--- Funcionários com salário > R\$1.000,00 ---")
        filtrados.forEach { exibirFuncionario(it) }
    }
}
fun mostrarFuncionariosAbaixo1000(funcionarios: List<Funcionario>) {
    val filtrados = funcionarios.filter { it.salario < 1000.0 }

    if (filtrados.isEmpty()) {
        println("Nenhum funcionário com salário < R\$1.000,00 encontrado.")
    } else {
        println("--- Funcionários com salário < R\$1.000,00 ---")
        filtrados.forEach { exibirFuncionario(it) }
    }
}
fun mostrarFuncionariosIgual1000(funcionarios: List<Funcionario>) {
    val filtrados = funcionarios.filter { it.salario == 1000.0 }

    if (filtrados.isEmpty()) {
        println("Nenhum funcionário com salário = R\$1.000,00 encontrado.")
    } else {
        println("--- Funcionários com salário = R\$1.000,00 ---")
        filtrados.forEach { exibirFuncionario(it) }
    }
}
fun exibirFuncionario(funcionario: Funcionario) {
    println("Matrícula: ${funcionario.matricula}")
    println("Nome: ${funcionario.nome}")
    println("Salário: R$${funcionario.salario}")
}