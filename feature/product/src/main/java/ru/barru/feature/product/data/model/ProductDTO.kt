package ru.barru.feature.product.data.model

/**
 * Конечно тут должны бть аннотации ретрофита, типа @Serialized и прочее
 */
internal data class ProductDTO(
    val id: String,
    val name: String,
    val description: String,
    val inFav: Boolean // а вдруг сервер не любит длинные названия, ну и просто чтоб показать что слои
    // могут различаться
)
