package com.example.neteasecloudmusic.common

sealed class Status {
    object OK : Status()
    object PWDERR : Status()
    object INV : Status()
    object UNK : Status()
    object NETERR : Status()
}