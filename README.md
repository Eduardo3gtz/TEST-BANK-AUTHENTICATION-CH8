# TEST-BANK-AUTHENTICATION-CH8

Tests
To test the tests, simply run the operation controller test section.

To run the program, run the testbankapplication and use Postman.

h2 database page
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

BANK APPLICATION SIMULATION – SPRINT 3

Requirements:
- Java Development Kit (JDK 17 or later) – Free
- Any Java IDE (NetBeans IDE recommended, IntelliJ is also valid) – Free

Files:
- SimulationBankCH8.java
- README.txt

How to run (command line):

1. Save SimulationBankCH8.java in a folder.
2. Open a terminal in that folder.
3. Compile:
   javac SimulationBankCH8.java
4. Run:
   java SimulationBankCH8

Description:
The script simulates the validation of banking data:
- Bank Code (4 numeric digits)
- Branch Code (4 numeric digits)
- Account Number (10 numeric digits)
- Personal Key (8–16 chars, with uppercase, lowercase, and numbers)
- Order value (integer)

It runs three test cases:
- A valid case
- A boundary case
- An invalid case

Each case prints input data, validation result, and error details if needed.
