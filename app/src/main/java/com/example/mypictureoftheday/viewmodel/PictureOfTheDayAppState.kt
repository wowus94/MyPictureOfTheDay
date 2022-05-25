package com.example.mypictureoftheday.viewmodel

import com.example.mypictureoftheday.repository.PictureOfTheDayResponseData

sealed class PictureOfTheDayAppState {
    data class Success(val pictureOfTheDayResponseData: PictureOfTheDayResponseData) :
        PictureOfTheDayAppState()

    data class Error(val error: Throwable) :
        PictureOfTheDayAppState()

    data class Loading(val progress: Int?) :
        PictureOfTheDayAppState()
}