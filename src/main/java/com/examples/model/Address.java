package com.examples.model;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
@EqualsAndHashCode
@UDT(
        keyspace = "cassandra_examples",
        name = "Address"
)
public class Address implements Serializable {
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
