# Code example for GraphQL issue with smallrye-graphql client

Example generates GraphQL Client from schema and queries it. (HSL Routing API)

The test can be run using `./mvnw verify`

The client sends the following request:
```
curl \
-X POST \
-H "Content-Type: application/json" \
--data '{ "query": "query pattern($id: String) { pattern(id: $id) {name} }", "variables": {"id":"HSL:1059:0:01"}, "operationName": "pattern" }' \
https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql
```
This returns an error:
```
{"errors":[{"validationErrorType":"VariableTypeMismatch","errorType":"ValidationError","locations":[{"line":1,"column":42}],"message":"Validation error of type VariableTypeMismatch: Variable type doesn't match"}]}
```

Following request returns expected response:
```
curl \
-X POST \
-H "Content-Type: application/json" \
--data '{ "query": "query pattern($id: String!) { pattern(id: $id) {name} }", "variables": {"id":"HSL:1059:0:01"}, "operationName": "pattern" }' \
https://api.digitransit.fi/routing/v1/routers/hsl/index/graphql

{"data":{"pattern":{"name":"59 to Pajamäki (HSL:1461109)"}}}
```
