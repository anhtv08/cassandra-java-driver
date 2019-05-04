package com.examples.repository;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.examples.model.Account;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class TestRepository  {

    @Autowired
    MappingManager mappingManager;

    public void addNewAccount(Account account){
        Mapper mapper =mappingManager.mapper(Account.class);
        mapper.save(account);

    }
    public void deleteAccount(Account account){
        Mapper mapper =mappingManager.mapper(Account.class);
        mapper.save(account);

    }
    public Account getAccount(Account account){
        Mapper mapper =mappingManager.mapper(Account.class);
        return (Account) mapper.get(account.getAccountId());
    }
}
