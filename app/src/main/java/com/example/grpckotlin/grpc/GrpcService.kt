package com.example.grpckotlin.grpc

import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.util.concurrent.Executors

class GrpcService(private val host: String, private val port: Int) {

    fun createManagedChannel(): ManagedChannel {
        return ManagedChannelBuilder.forAddress(host, port).executor(Executors.newSingleThreadExecutor())
            .usePlaintext().build()
    }
}