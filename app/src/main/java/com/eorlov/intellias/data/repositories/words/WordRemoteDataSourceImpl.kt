package com.eorlov.intellias.data.repositories.words

import com.eorlov.intellias.domain.entities.Word
import com.eorlov.intellias.data.api.MainService
import com.eorlov.intellias.domain.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WordRemoteDataSourceImpl @Inject constructor(
    private val mainService: MainService
) : WordRemoteDataSource {
    override suspend fun get(word: String): Result<Word> =
        withContext(Dispatchers.IO) {
            try {
                val response = mainService.getWord(word)
                if (response.isSuccessful) {
                    return@withContext Result.Success(response.body()!![0])
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }

}