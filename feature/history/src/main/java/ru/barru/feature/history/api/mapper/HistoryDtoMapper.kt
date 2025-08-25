package ru.barru.feature.history.api.mapper

import ru.barru.feature.history.api.model.HistoryRecordDto
import ru.barru.feature.history.domain.entity.HistoryRecord

internal interface HistoryDtoMapper {
    fun fromDto(dto: HistoryRecordDto): HistoryRecord
}

internal class HistoryDtoMapperImpl : HistoryDtoMapper {
    override fun fromDto(dto: HistoryRecordDto) = HistoryRecord(
        id = dto.id,
        title = dto.title,
        type = dto.type.toType()
    )


    private fun String.toType() = when (this) {
        BUY -> HistoryRecord.Type.BUY
        SELL -> HistoryRecord.Type.SELL
        PENDING -> HistoryRecord.Type.PENDING
        else -> HistoryRecord.Type.UNKNOWN
    }
}

private const val BUY = "BUY"
private const val SELL = "SELL"
private const val PENDING = "PENDING"