package com.examples.model;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import lombok.*;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@EqualsAndHashCode
@Table(
        keyspace = "cassandra_examples", name = "Account",
        readConsistency = "LOCAL_ONE",
        writeConsistency = "LOCAL_QUORUM",
        caseSensitiveKeyspace = false,
        caseSensitiveTable = false
)

public class Account implements Serializable {

     @PartitionKey
     @Column(
             name = "account_id"
     )
     private String accountId;
     @Column(
            name="full_name"
     )
     private  String fullName;

     @Column(
            name="addresses"
     )
     @Frozen
     private List<Address> addresses;
}
