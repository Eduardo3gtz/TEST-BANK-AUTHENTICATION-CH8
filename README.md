# TEST-BANK-AUTHENTICATION-CH8

Tests
Para probar los test basta con correr el apartado de operation controller test

para correr el programa corre el testbankapplication y usa postman 

pagina h2 databbase
http://localhost:8081/h2-console/login.jsp

jdbbbc url jdbc:h2:mem:testdb
user name sa

postman
post http://localhost:8081/api/operations

````
{
  "bankCode": "2025",
  "branchCode": "3340",
  "accountNumber": "1848794772",
  "personalKey": "Rrd1848794"
}
````
get http://localhost:8081/api/operations
