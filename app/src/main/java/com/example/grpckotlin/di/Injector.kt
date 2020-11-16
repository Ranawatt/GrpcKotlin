package com.example.grpckotlin.di

import com.example.grpckotlin.data.GreeterRemoteDataSource
import com.example.grpckotlin.data.GreeterRepository
import com.example.grpckotlin.grpc.GrpcService
import com.example.grpckotlin.view.GreeterViewModelFactory

object Injector {
    // Provide GrpcService
    private fun provideGrpcService() = GrpcService(
        "192.168.1.107",
        50051
    )

    // Provide DataSource
    private fun provideGreeterRemoteDataSource(grpcService: GrpcService) = GreeterRemoteDataSource(grpcService)

    // Provide Repository
    private fun provideGreeterRepository(greeterRemoteDataSource: GreeterRemoteDataSource) = GreeterRepository(greeterRemoteDataSource)

    // Provide GreeterViewModel factory
    fun provideGreeterViewModelFactory() = GreeterViewModelFactory(
        provideGreeterRepository(
            provideGreeterRemoteDataSource(
                provideGrpcService()
            )
        )
    )
}