# Java Spring Service Starter Template

A very small Spring Boot service which can be used as a started template for production ready codes.

## Endpoints

### `GET /health`
Returns the current application status.

Example response:
```json
{
  "status": "UP"
}
```

### `POST /example`
Processes a simple request payload.

Request body:
```json
{
  "userId": "123",
  "value": 42
}
```

Response body:
```json
{
  "status": "SUCCESS",
  "requestId": "uuid-string"
}
```

## How to run

### Prerequisites
- Java 17 or newer
- Maven 3.9+

### Start locally
On macOS, if your default terminal still uses Java 8, point `JAVA_HOME` to a newer JDK first:

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 18)
export PATH="$JAVA_HOME/bin:$PATH"
mvn spring-boot:run
```

The service starts on `http://localhost:8080`.

## Run tests
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 18)
export PATH="$JAVA_HOME/bin:$PATH"
mvn test
```

## Design decisions
- Kept the project intentionally small and readable.
- Used two controllers because the assignment defines two separate endpoints.
- Added a tiny service layer for `/example` so the controller stays thin and the request ID generation is isolated.
- Used simple Java classes for request/response models to keep the code straightforward.
- Added Bean Validation for basic request correctness.

### Project structure / separation of concerns
- `controller` handles the API endpoints.
- `service` keeps the main processing logic separate from HTTP code.
- `model.request` and `model.response` keep request and response data clear and simple.
- There is no `entity` folder yet because this project does not use a database right now.
- There is no separate `dto` folder because the request and response classes already play that role in this small project.
- This keeps the code easier to read, test, and extend.

## Assumptions
- `GET /health` only needs to report a simple status payload.
- `POST /example` does not need persistence or external integrations.
- Spring Boot's default error handling is sufficient.
- To keep the scope small and within time, I did not add authentication, database support, or advanced production features yet.

## Future Roadmap
Further, we are planning to 
- add authentication, 
- a basic DB connection,
- global exception handling,
- add logging and metrics for better monitoring,
- add CI checks so build and tests run automatically.

## NOTE
- DB Connection and Authentication is entirely missing from this!
