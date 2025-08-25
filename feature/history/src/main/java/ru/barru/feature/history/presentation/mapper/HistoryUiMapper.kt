package ru.barru.feature.history.presentation.mapper

import android.graphics.Color
import ru.barru.feature.history.domain.entity.HistoryRecord
import ru.barru.feature.history.presentation.model.HistoryRecordUiModel

internal interface HistoryUiMapper {
    fun fromDomain(domain: HistoryRecord): HistoryRecordUiModel
}

internal class HistoryUiMapperImpl : HistoryUiMapper {
    override fun fromDomain(domain: HistoryRecord) = HistoryRecordUiModel(
        id = domain.id,
        title = domain.title,
        backgroundColor = domain.type.toColor()
    )

    private fun HistoryRecord.Type.toColor() = when (this) {
        HistoryRecord.Type.BUY -> Color.GREEN
        HistoryRecord.Type.SELL -> Color.RED
        HistoryRecord.Type.PENDING -> Color.YELLOW
        HistoryRecord.Type.UNKNOWN -> Color.GRAY
    }
}