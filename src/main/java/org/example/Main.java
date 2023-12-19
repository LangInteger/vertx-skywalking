package org.example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.SpanRef;
import org.apache.skywalking.apm.toolkit.trace.Tracer;

public class Main {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    HttpServer server = vertx.createHttpServer();

    Router router = Router.router(vertx);
    router
        .post("/success")
        .handler(ctx -> {
          SpanRef entrySpan = Tracer.createEntrySpan("${operationName}", null);
          HttpServerResponse response = ctx.response();
          response.putHeader("content-type", "text/plain");
          response.end("Hello World from Vert.x-Web!");
          Tracer.stopSpan();
        });

    router
        .post("/fail")
        .handler(ctx -> {
          SpanRef entrySpan = Tracer.createEntrySpan("${operationName}", null);
          HttpServerResponse response = ctx.response();
          response.putHeader("content-type", "text/plain");
          response.setStatusCode(500).end();
          ActiveSpan.error(new RuntimeException("exdeption by design"));
          Tracer.stopSpan();
        });

    server.requestHandler(router).listen(8081)
        .onSuccess(httpServer -> System.out.println("server start success ...."))
        .onFailure(ex -> System.out.println("server start fail: " + ex.getMessage()));
  }
}