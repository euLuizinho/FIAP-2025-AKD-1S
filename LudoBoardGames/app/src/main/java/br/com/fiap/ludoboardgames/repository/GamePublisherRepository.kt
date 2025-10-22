package br.com.fiap.ludoboardgames.repository

import br.com.fiap.ludoboardgames.models.GamePublisher

val asmodee = GamePublisher("Asmodee")
val devir = GamePublisher("Devir")
val paperGames = GamePublisher("PaperGames")

fun getAllGamesPublisher() : List<GamePublisher> {
    return listOf(
        asmodee,
        devir,
        paperGames
    )
}
