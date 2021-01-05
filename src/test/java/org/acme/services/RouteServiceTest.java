package org.acme.services;

import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.graphql.client.typesafe.api.GraphQlClientBuilder;

@QuarkusTest
public class RouteServiceTest {

    RoutingServiceApi r = GraphQlClientBuilder.newBuilder().build(RoutingServiceApi.class);

    @Test
    public void test() {
        Pattern pattern = r.pattern("HSL:1059:0:01");
    }

}
