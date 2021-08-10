package nl.sybrenbolandit.cat.consumer;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import nl.sybrenbolandit.cat.consumer.model.CatDTO;
import nl.sybrenbolandit.cat.consumer.model.CatMapper;
import nl.sybrenbolandit.proto.Cat;
import nl.sybrenbolandit.proto.CatRequest;
import nl.sybrenbolandit.proto.CatServiceGrpc;

import javax.inject.Inject;

@Controller("/cats")
public class CatController {

  @Inject
  CatServiceGrpc.CatServiceBlockingStub stub;

  @Inject
  CatMapper mapper;

  @Get(value = "/{chipId}", produces = MediaType.APPLICATION_JSON)
  public HttpResponse<CatDTO> getProduct(String chipId) {
    Cat responseCat = stub.getCat(CatRequest.newBuilder().setChipId(chipId).build());
    return HttpResponse.ok(mapper.map(responseCat));
  }
}
