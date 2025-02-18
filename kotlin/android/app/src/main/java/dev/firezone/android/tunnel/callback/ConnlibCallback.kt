/* Licensed under Apache 2.0 (C) 2023 Firezone, Inc. */
package dev.firezone.android.tunnel.callback

interface ConnlibCallback {
    fun onSetInterfaceConfig(
        addressIPv4: String,
        addressIPv6: String,
        dnsAddresses: String,
    ): Int

    fun onTunnelReady(): Boolean

    fun onAddRoute(
        addr: String,
        prefix: Int,
    ): Int

    fun onRemoveRoute(
        addr: String,
        prefix: Int,
    ): Int

    fun onUpdateResources(resourceListJSON: String)

    // The JNI doesn't support nullable types, so we need two method signatures
    fun onDisconnect(error: String): Boolean

    fun onDisconnect(): Boolean

    fun getSystemDefaultResolvers(): Array<ByteArray>

    fun protectFileDescriptor(fileDescriptor: Int)
}
