package br.com.fiap.ludoboardgames.models

data class BoardGame (
    val title: String,
    val gamesPublisher: List<GamePublisher>
)