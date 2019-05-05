# Simple java example to experiment cassandra java driver.
## The example leverage on spring boot framework to simplify some boiler code

### Compile, Build and Deploy.

`mvn clean install`

### Run Test for adding new Account with embedded information.

```
mvn test -Dtest=TestRepositoryTests#test_add_new_account
mvn test -Dtest=TestRepositoryTests#test_delete_a_account
mvn test -Dtest=TestRepositoryTests#test_get_a_account
mvn test -Dtest=TestRepositoryTests#test_udpate_account

```

### Todo: Fixing test cases failed when running test in bulk mode.
