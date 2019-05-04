create keyspace cassandra_examples
with replication = {
  'class' : 'SimpleStrategy',
  'replication_factor' : 1
};
USE cassandra_examples;
create type if not exists Address(
    zip_code text,
    street_name text,
    email text
);
create table if not exists account(
    account_id  text,
    full_name text,
    address list<frozen Address>
    PRIMARY key (account_id)
);
