package com.examples.repository;

import com.datastax.driver.mapping.MappingManager;
import com.examples.model.Account;
import com.examples.model.Address;
import com.google.common.collect.Lists;
import org.apache.thrift.transport.TTransportException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(
        JUnit4.class
)
public class TestRepositoryTests extends CassandraTestHelper {

    TestRepository testRepository;
    MappingManager mappingManager;
    final String CQL_FILE = "cql/account.cql";

    @Before
    public void setup() throws IOException, TTransportException {

        setupCassandra(CQL_FILE);
        mappingManager = new MappingManager(
                session
        );

        testRepository = new TestRepository(
                mappingManager
        );

    }
    @Test
    public void test_add_new_account(){
        createSampleTestData();
        Account testAccount  = createSampleTestData();
        testRepository.addNewAccount(testAccount);
    }

    @Test
    public void test_delete_a_account(){

        Account testAccount  = createSampleTestData();
        testRepository.addNewAccount(testAccount);
        testRepository.deleteAccount(testAccount);

    }

    @Test
    public void test_get_a_account(){
        Account testAccount  = createSampleTestData();

        testRepository.addNewAccount(testAccount);
        Account account = testRepository.getAccount(testAccount);
        assertNotNull(account);
    }
    @After
    public void cleanup(){
        cleanupCassandra();
    }
    private Account createSampleTestData(){
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
        return testAccount;
    }

}