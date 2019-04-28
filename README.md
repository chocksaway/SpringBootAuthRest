# SpringBootAuthRest

*Requirements*

Single Post endpoint with a persons name as a JSon payload.

Endpoint should return "Hello Name" (in JSon) (using the name from the JSon payload).

Using the username and password to successfully authenticate.

Secured with Basic HTTP Auth (username + password)

Password should be stored securely on the server side.

---

*Design*

i.    Use Spring Boot to provide the structure for Restful endpoint, and Spring Security for authentication.

ii.   Use a command line loader (Spring Boot functionality) to "pre-populate" a (the same), single username and password everytime the application starts.

iii.  The single username, password can be used by all users (name) of the application.

iv.   Create a Name, and Detail POJO for holding the name, and the username / password detail.

v.    Use Spring Boot Security Application Security manager to check the username, and password.

vi.   If valid, create a Spring Boot (userservice), authenticated User, with a USER role, and forward to the Controller (name endpoint).

vii.  There is no need to store the persons name, as we are only outputting in Hello message.

viii. Password is stored securely using bcrypt hash.

---
*Development*


i.  *Note - during development it was necessary to Use updated Spring security 5 BCryptPasswordEncoder to avoid the following error:*
```
java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"

Documented in(https://docs.spring.io/spring-security/site/docs/5.0.0.RELEASE/reference/htmlsingle/#troubleshooting)
```

ii.  The password is stored securely on the server side, implemented in the com.chocksaway.load.Loader class, using BCryptPasswordEncoder().encode(......);

This is used by the Spring Security WebSecurityConfigurer, UserDetailsService bean.  
Debug is pasted, confirming the bcrypt password:
```
detail = {Detail@6098} 
 name = "username"
 password = "$2a$10$6LEbRP5vhXxMWTx/bixufu./TU944nE8UT9tnhiMm/I2uc4ruVz3W"
```
---
Build, and create FAT jar using maven.

Run using java -jar <name of jar>.

---

*Build Process* 

$ mvn package

```
[snip]
[INFO] --- maven-assembly-plugin:3.1.1:single (make-assembly) @ 1 ---
[INFO] Building jar: target/1-1.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 8.788 s
[INFO] Finished at: 2019-04-28T12:29:21+00:00
[INFO] Final Memory: 131M/327M
[INFO] ------------------------------------------------------------------------
$
```

---

*Running Application*

$ java -jar target/1-1.jar

```
$ java -jar target/1-1.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.4.RELEASE)

2019-04-28 12:40:02.865  INFO 13276 --- [           main] com.chocksaway.Application               : Starting Application v1 on rhubarb.local with PID 13276 (/Users/milesd/java/workspace/SpringBootAuthRest/target/1-1.jar started by milesd in /Users/milesd/java/workspace/SpringBootAuthRest)
2019-04-28 12:40:02.867  INFO 13276 --- [           main] com.chocksaway.Application               : No active profile set, falling back to default profiles: default

[snip]


```

*Testing*

*Curl has been used for Testing*

*Application running on localhost:8080*

1.  Valid security credentials.  HTTP 200 response, with valid hello message:
```
curl -i --user username:password -H "Content-Type: application/json" -H "Accept: application/json" -X POST -d '{"name":"milesd"}' http://localhost:8080/name
HTTP/1.1 200
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Content-Length: 19
Date: Sun, 28 Apr 2019 11:05:56 GMT

{"hello": "milesd"}
```

2.  Invalid password.  HTTP 401 response:
```
$ curl -i --user username:passwords -H "Content-Type: application/json" -H "Accept: application/json" -X POST -d '{"name":"milesd"}' http://localhost:8080/name
HTTP/1.1 401
WWW-Authenticate: Basic realm="Realm"
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
WWW-Authenticate: Basic realm="Realm"
Content-Length: 0
Date: Sun, 28 Apr 2019 11:06:28 GMT
```

3.  Invalid username.  HTTP 401 response:
```
$ curl -i --user usernamez:password -H "Content-Type: application/json" -H "Accept: application/json" -X POST -d '{"name":"milesd"}' http://localhost:8080/name
HTTP/1.1 401
WWW-Authenticate: Basic realm="Realm"
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
WWW-Authenticate: Basic realm="Realm"
Content-Length: 0
Date: Sun, 28 Apr 2019 11:06:51 GMT
```

4.  Valid credentials.  Name of 0  HTTP 200 response - "0" treated as String.
```
curl -i --user username:password -H "Content-Type: application/json" -plication/json" -X POST -d '{"name":0}' http://localhost:8080/name
HTTP/1.1 200
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Content-Length: 14
Date: Sun, 28 Apr 2019 11:12:51 GMT

{"hello": "0"}
```

5.  Valid credentials.  Invalid Json body.  HTTP 400 response.
```
$ curl -i --user username:password -H "Content-Type: application/json" -plication/json" -X POST -d '{"name"}' http://localhost:8080/name
HTTP/1.1 400
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Date: Sun, 28 Apr 2019 11:10:33 GMT
Connection: close

{"timestamp":"2019-04-28T11:10:33.296+0000","status":400,"error":"Bad Request","message":"JSON parse error: Unexpected character ('}' (code 125)): was expecting a colon to separate field name and value; nested exception is com.fasterxml.jackson.core.JsonParseException: Unexpected character ('}' (code 125)): was expecting a colon to separate field name and value\n at [Source: (PushbackInputStream); line: 1, column: 9]","path":"/name"}
```





