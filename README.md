# PoCs
Proof of Concepts Repository
## springbasicexample
Application that uses sprint-boot to show a DI basic example
### How to run it

```bash
$ cd springbasicexample
$ mvn clean package
$ java -jar target/springbasicexample-1.0-SNAPSHOT.jar
```

Output:
```bash
My class is com.albpal.pocs.BMW, my brand is BMW and my colour is red
```

## springAOPbasicexample
Application that uses sprint aspect oriented programming to separate cross-cutting concerns. It is about audit logging for transaction between bank accounts.
### How to run it

```bash
$ cd springAOPbasicexample
$ mvn clean package
$ java -jar target/springAOPbasicexample-1.0-SNAPSHOT.jar
```

Output:
```bash
Initial scenario:
        Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 1000€
        Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 0€
***********CALL TO A NEW TRANSACTION *************
[Origin]: Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 1000€
[Destination]: Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 0€
[Amount]: 500
***********END TRANSACTION**************
Final scenario:
        Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 500€
        Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 500€
```

## testngbasicexample
Application that uses testNG to work with the TDD paradigm
### How to run it

```bash
$ cd testngbasicexample
$ mvn clean test
```

Output:
```bash
.........
Square Area = 100.0
Rectangle Area = 200.0
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.283 sec
.........
Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
.........
```

## springRESTful
RESTful service build using spring
### How to run it

```bash
$ cd springRESTful
$ mvn clean package
$ java -jar target/gs-rest-service-0.1.0.jar
```

Output:
```bash
http://localhost:8080/greeting?name=Albert
{"id":1,"content":"Hello, Albert!"}
```

## springtestng
Application that uses spring and testNG to work with the TDD paradigm
### How to run it

```bash
$ cd springtestng
$ mvn clean test
```

Output:
```bash
.........
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 5.073 s
[INFO] Finished at: 2016-06-05T12:49:04+02:00
[INFO] Final Memory: 16M/226M
[INFO] ------------------------------------------------------------------------
```
