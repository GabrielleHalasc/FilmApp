package presentation

sealed class FilmDetailEvent {
    data class GetFilmDetail(val movieId: Int) : FilmDetailEvent()
}