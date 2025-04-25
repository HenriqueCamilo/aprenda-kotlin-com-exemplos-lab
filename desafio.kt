enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
       inscritos.add(usuario)
       println("O usuário ${usuario.nome} foi matriculado")
       
    }
}

fun main() {
    val formacao = Formacao(
        "Computacao",
        listOf<ConteudoEducacional>(ConteudoEducacional("MATEMATICA"),ConteudoEducacional("PORTUGUES")),
        Nivel.DIFICIL
    )
    
    val usuario = Usuario("Luana")
    
    formacao.matricular(usuario)
    showInformation(formacao, usuario)
    
}

fun showInformation(formacao: Formacao, usuario: Usuario){
    
    println("O nome da formacao que ${usuario.nome} se cadastrou foi ${formacao.nome}")
    println("o conteudo que a formação ${formacao.nome} possui:")
    for(conteudo in formacao.conteudos){
            println("matéria: ${conteudo.nome}")
            println("duração: ${conteudo.duracao}")
    }
    println("O nível de dificuldade da formação ${formacao.nome}: ${formacao.nivel}")
}