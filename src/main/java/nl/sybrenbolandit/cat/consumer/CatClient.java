package nl.sybrenbolandit.cat.consumer;

import io.grpc.ManagedChannel;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import nl.sybrenbolandit.proto.CatServiceGrpc;

import javax.inject.Singleton;

@Factory
class CatClient {
  @Singleton
  CatServiceGrpc.CatServiceBlockingStub stub(
      @GrpcChannel("cat") ManagedChannel channel) {
    return CatServiceGrpc.newBlockingStub(channel);
  }
}
