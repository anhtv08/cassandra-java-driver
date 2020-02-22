package com.examples.controller;

import com.examples.model.Account;
import com.examples.model.Address;
import com.examples.repository.TestRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// todo: to be improved.
@RestController(
     "/cassandra"
)
public class TestController {

    @Autowired
    TestRepository repository;
    @RequestMapping(
            "/addNewAccount"
    )
    public String addNewAccount(){
        Address address_1 = Address.builder()
                .email("anhtv@gmail.com")
                .streetName("bedok1")
                .zipCode("127")
                .build();

        Address address_2 = Address.builder()
                .email("anhtv2@gmail.com")
                .streetName("Bedok2")
                .zipCode("127")
                .build();

        Address address_3 = Address.builder()
                .email("anhtv3@gmail.com")
                .streetName("Bedok3")
                .zipCode("127")
                .build();

        List<Address> addresses = (

                Lists.newArrayList(
                        address_1,
                        address_2,
                        address_3

                    )
                );

        Account testAccount  =Account
                .builder()
                .accountId("joeytrang")
                .fullName("Trang van anh")
                .addresses(addresses)
                .build();

        repository.addNewAccount(testAccount);

        // safeObject by setting EMPTY value to reduce tombstone
        Account testAccount_1  =Account
                .builder()
                .accountId("joeytrang1")
                .fullName("")
                .build();

        repository.addNewAccount(testAccount_1);


        // explicit setting null value will generating tombstone
        Account testAccount_2  =Account
                .builder()
                .accountId("joeytrang2")
                .fullName(null)
                .build();

        repository.addNewAccount(testAccount_2);


        // missing setting will also generate tombstone
        Account testAccount_3  =Account
                .builder()
                .accountId("joeytrang3")
                .build();

        repository.addNewAccount(testAccount_3);




        return "Added successfully!";
    }



}
