package com.examples.repository;

import com.datastax.driver.core.Session;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;

import java.io.IOException;

public class CassandraTestHelper {

   final String CQL_FILE ="classpath:/schema/account.cql";

   Session session;
   void setupCassandra() throws IOException, TTransportException {
       EmbeddedCassandraServerHelper.startEmbeddedCassandra(
               CQL_FILE,
               1000000L);

       session = EmbeddedCassandraServerHelper.getSession();
   }
   void  cleanupCassanra(){
       EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
   }

}
