package com.examples.repository;

import com.datastax.driver.core.Session;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.CQLDataSet;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;

import java.io.IOException;

import static org.cassandraunit.utils.EmbeddedCassandraServerHelper.CASSANDRA_RNDPORT_YML_FILE;

public class CassandraTestHelper {

   Session session;
   void setupCassandra(String cqlFile) throws IOException, TTransportException {
       EmbeddedCassandraServerHelper.startEmbeddedCassandra(
               CASSANDRA_RNDPORT_YML_FILE,
               1000000L);

       session = EmbeddedCassandraServerHelper.getSession();
       CQLDataSet dataSet = new ClassPathCQLDataSet(cqlFile);
       CQLDataLoader dataLoader = new CQLDataLoader(session);
       dataLoader.load(dataSet);

   }
   void cleanupCassandra(){
       EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
   }

}
