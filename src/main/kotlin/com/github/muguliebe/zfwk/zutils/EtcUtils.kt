package com.github.muguliebe.zfwk.zutils

import org.apache.commons.lang3.ArchUtils
import org.apache.commons.lang3.arch.Processor
import java.net.InetAddress
import java.net.UnknownHostException

object EtcUtils {
    private val log = logger()

    fun hostName(length: Int? = 100): String {
        var hostName = try {
            InetAddress.getLocalHost().hostName
        } catch (e: UnknownHostException) {
            log.error("err occurred when get hostname: ${e.message}")
            "unknown"
        }

        if (length != null && length < hostName.length) {
            hostName = hostName.substring(0 until length)
        }

        return hostName.removeSpecialChar()
    }

    fun processor(): Processor? {
        return ArchUtils.getProcessor()
    }

    fun archs(): Array<Processor.Arch> {
        return Processor.Arch.values()
    }

}
