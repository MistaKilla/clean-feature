package ru.barru.feature.history.domain.entity

internal data class HistoryRecord(
    val id: String,
    val title: String,
    val type: Type
) {
    enum class Type {
        BUY, SELL, PENDING, UNKNOWN
    }
}