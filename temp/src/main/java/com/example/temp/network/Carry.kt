package com.example.temp.network

interface Carry<T> {

    fun onSuccess(result: T)

    fun onFailure(throwable: Throwable)
}