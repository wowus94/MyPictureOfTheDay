package com.example.mypictureoftheday.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypictureoftheday.BuildConfig
import com.example.mypictureoftheday.repository.PictureOfTheDayResponseData
import com.example.mypictureoftheday.repository.PictureOfTheDayRetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel(
    private val liveData: MutableLiveData<PictureOfTheDayAppState> = MutableLiveData(),
    private val pictureOfDayRetrofitImp: PictureOfTheDayRetrofitImpl = PictureOfTheDayRetrofitImpl()
) : ViewModel() {
    fun getLiveData(): LiveData<PictureOfTheDayAppState> {
        return liveData
    }

    fun sendRequest() {
        liveData.postValue(PictureOfTheDayAppState.Loading(null))
        // TODO HW проверить на наличие BuildConfig.NASA_API_KEY
        pictureOfDayRetrofitImp.getRetrofit().getPictureOfTheDay(BuildConfig.NASA_API_KEY)
            .enqueue(callback)
    }

    private val callback = object : Callback<PictureOfTheDayResponseData> {
        override fun onResponse(
            call: Call<PictureOfTheDayResponseData>,
            response: Response<PictureOfTheDayResponseData>
        ) {
            if (response.isSuccessful) {
                response.body()?.let {
                    liveData.postValue(PictureOfTheDayAppState.Success(it))
                }
            } else {
                // TODO HW
            }
        }

        override fun onFailure(call: Call<PictureOfTheDayResponseData>, t: Throwable) {
            // TODO HW
        }
    }
}