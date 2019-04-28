# SpringBootAuthRest

Single Post endpoint with a person name as a JSon payload.

Endpoint should return "Hello <Name>" (using the name from the JSon payload) as a successfully (authenticated) response.

Secured with Basic HTTP Auth (username + password)

Password should be stored securely on the server side.

*Design*

Use Spring Boot to provide the structure for Restful endpoint, and Spring Security for authentication.

Use a command line loader (Spring Boot functionality) to "pre-populate" a "set" username and password everytime the application starts.

*Note - Use updated Spring security 5 BCryptPasswordEncoder to avoid the following error:*
```
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"

Documented in(https://docs.spring.io/spring-security/site/docs/5.0.0.RELEASE/reference/htmlsingle/#troubleshooting)
```

There is no need to store the persons name.

*Unit Testing*

*Build Process* 

*Running Application*






