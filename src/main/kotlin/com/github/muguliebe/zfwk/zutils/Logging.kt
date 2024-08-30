package com.github.muguliebe.zfwk.zutils

import ch.qos.logback.classic.Logger
import org.slf4j.LoggerFactory

inline fun <reified T> T.logger(): Logger {
    return if (T::class.isCompanion)
        LoggerFactory.getLogger(T::class.java.enclosingClass) as Logger
    else
        LoggerFactory.getLogger(T::class.java) as Logger
}
