package br.com.fiap.ludoboardgames.repository

import br.com.fiap.ludoboardgames.models.BoardGame
import br.com.fiap.ludoboardgames.models.GamePublisher

fun getAllBoardGames(): List<BoardGame> {
    return listOf(
        BoardGame("Azul", listOf(asmodee)),
        BoardGame("Ticket To Ride",
            listOf(asmodee)),
        BoardGame("Quem Foi?",
            listOf(paperGames)),
    )
}

fun getBoardGamesBy(gamePublisher:
                    GamePublisher
): List<BoardGame> {
    return getAllBoardGames().filter {

        it.gamesPublisher.contains(gamePublisher)
    }
}

fun getBoardGamesBy(title: String):
        List<BoardGame> {
    return getAllBoardGames().filter {
        it.title.startsWith(prefix =
            title, ignoreCase = true)
    }
}