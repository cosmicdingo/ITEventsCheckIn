package com.example.iteventscheck_in.network

interface Carry<T> {

    fun onSuccess(result: T)

    fun onFailure(throwable: Throwable)
}