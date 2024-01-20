package com.home.datasource

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Interface Used to decode the original callback from a request
 * and make the calls for onResponseFailure with an ErrorResponse
 * instance and onResponseSuccess with da data of MessageResponse
 * or other type of dataclass
 * @author Yago H Pereira <yago.henriquep@gmail.com>
 * @since 20/01/2024
 * @version 1.0.0
 */
interface ResponseCallback<Any> : Callback<Any> {
    override fun onFailure(call: Call<Any>, t: Throwable)

    override fun onResponse(call: Call<Any>, response: Response<Any>) {
        if(response.code() != 200){
            try {
                val gson = GsonBuilder().create()
                val error = gson.fromJson(response.errorBody()!!.string(), ErrorResponse::class.java)
                this.onResponseFailure(call, error)
            }catch (ex : Exception){
                onFailure(call, ex)
            }
            return
        }

        try{
            this.onResponseSuccess(call, response.body()!!)
        }catch (ex : Exception){
            onFailure(call, ex)
        }
    }

    fun onResponseSuccess(call: Call<Any>, response: Any);

    fun onResponseFailure(call: Call<Any>, response: ErrorResponse)
}