# PoCs
Proof of Concepts Repository
## springbasicexample
Application that uses sprint-boot to show a DI basic example
### How to run it

```bash
cd springbasicexample
mvn clean package
java -jar target/springbasicexample-1.0-SNAPSHOT.jar
```

Output: `My class is com.albpal.pocs.BMW, my brand is BMW and my colour is red`

## springAOPbasicexample
Application that uses sprint aspect oriented programming to separate cross-cutting concerns. It is about audit logging for transaction between bank accounts.
### How to run it

```bash
cd springAOPbasicexample
mvn clean package
java -jar target/springAOPbasicexample-1.0-SNAPSHOT.jar
```

Output:
`Initial scenario:
        Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 1000€
        Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 0€
***********CALL TO A NEW TRANSACTION *************
[Origin]: Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 1000€
[Destination]: Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 0€
[Amount]: 500
***********END TRANSACTION**************
Final scenario:
        Account type com.albpal.pocs.bank.NormalAccount with id 1111111 has 500€
        Account type com.albpal.pocs.bank.NormalAccount with id 2222222 has 500€`
