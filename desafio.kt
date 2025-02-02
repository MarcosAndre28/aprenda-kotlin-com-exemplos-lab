import kotlin.random.Random

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String, var matricula: Int? = null)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Gerar um número aleatório único como matrícula
        usuario.matricula = Random.nextInt(1000, 9999)
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado com sucesso! Matrícula: ${usuario.matricula}")
    }
}

fun main() {
    // Criar conteúdos educacionais
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", nivel = Nivel.BASICO)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", duracao = 120, nivel = Nivel.DIFICIL)

    // Criar formação com conteúdos
    val formacaoKotlin = Formacao("Formação Kotlin", listOf(kotlinBasico, kotlinAvancado))

    // Criar usuários
    val usuario1 = Usuario("Luccas Del Cu", "luccas@example.com")
    val usuario2 = Usuario("Maria Silva", "maria@example.com")

    // Matricular usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // Exibir inscritos
    println("\nLista de inscritos na formação ${formacaoKotlin.nome}:")
    formacaoKotlin.inscritos.forEach {
        println("Nome: ${it.nome}, Matrícula: ${it.matricula}, Email: ${it.email}")
    }
}
