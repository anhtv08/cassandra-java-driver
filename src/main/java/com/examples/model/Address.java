package com.examples.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@UDT(
        keyspace = "cassandra_examples",
        name = "Address"
)
public class Address {
    @Field(
            name = "zip_code"
    )
    private  String zipCode;
    @Field(
            name = "street_name"
    )
    private  String streetName;
    @Field(
            name = "email"
    )
    private  String email;

}
