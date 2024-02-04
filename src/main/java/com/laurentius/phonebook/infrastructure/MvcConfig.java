package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.usecase.ContactCreateUseCase;
import com.laurentius.phonebook.usecase.ContactPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public ContactCreateUseCase contactCreateUseCase(JpaContactRepository repository) {
        ContactGateway gateway = new ContactDatabaseGateway(repository);
        ContactPresenter contactPresenter = new ContactResponseFormatter();
        return new ContactCreateUseCase(gateway, contactPresenter);
    }
}
