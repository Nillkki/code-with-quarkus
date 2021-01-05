package org.acme.services;

import io.smallrye.graphql.client.generator.GraphQlSchema;
import io.smallrye.graphql.client.generator.GraphqlQuery;

@GraphQlSchema("resource:hsl.graphql")
@GraphqlQuery("query pattern($id: String) { pattern(id: $id) { name }}")
public class RoutingService {
}