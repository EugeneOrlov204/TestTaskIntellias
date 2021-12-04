package com.eorlov.intellias.domain.common

//Code from https://github.com/ngallazzi/cleanarchitectureblueprints/blob/master/domain/src/main/java/com/ngallazzi/domain/common/Result.kt
/**
 * A generic class that holds a value or an error status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}