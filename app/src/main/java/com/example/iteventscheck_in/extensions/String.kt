package com.example.iteventscheck_in.extensions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.toConvertDate(): String {

    val pattern = "yyyy-MM-dd'T'HH:mm:ss"
    val sdf = SimpleDateFormat(pattern, Locale.getDefault())

    return DateFormat.getDateInstance(DateFormat.MEDIUM)
        .format(sdf.parse(this))
}


