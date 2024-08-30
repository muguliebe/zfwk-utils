package zfwk.zutils

import java.util.concurrent.atomic.AtomicInteger

object GuidUtils {
    private val counter: AtomicInteger = AtomicInteger(0)
    const val LENGTH = 32
    private const val HOST_NAME_LEN = 7

    fun generate(): String {
        val guid = StringBuilder()
        val timestamp = DateUtils.currentDateTimeFormat("yyyyMMddHHmmssSSS") // 17
        val hostName = EtcUtils.hostName(HOST_NAME_LEN).padEnd(HOST_NAME_LEN, 'Z').uppercase() // 7
        val hop = 1

        guid.append(timestamp) // 17
        guid.append(hostName) // 6
        guid.append(counter.incrementAndGet().toString().padStart(5, '0')) // 4
        guid.append(hop.toString().padStart(3, '0')) // 3

        if (counter.get() >= 99999)
            counter.set(0)

        return guid.toString()
    }

}
