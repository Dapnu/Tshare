package com.DRIF.tshare.util

data class DataOrException<T, E : Exception?>(
    var data: T? = null,
    var e: E? = null
)
