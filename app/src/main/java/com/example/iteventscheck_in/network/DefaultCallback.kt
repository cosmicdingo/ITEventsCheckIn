package com.example.iteventscheck_in.network

import com.example.iteventscheck_in.exception.EmptyBodyException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DefaultCallback<T>(private val carry: Carry<T>) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        val body: T? = response.body()
        if (body != null) carry.onSuccess(body)
        else carry.onFailure(EmptyBodyException())
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        carry.onFailure(t)
    }
}