CREATE KEYSPACE IF NOT EXISTS cassandra_examples 
WITH replication={
    'class' : 'SimpleStrategy',
    'replication_factor':1
};

create type if not exists cassandra_examples.Address(
    zip_code text,
    street_name text,
    email text
);
create table if not exists cassandra_examples.Account(
    account_id  text,
    full_name text,
    addresses list<frozen<address>>,
    PRIMARY key (account_id)
);
