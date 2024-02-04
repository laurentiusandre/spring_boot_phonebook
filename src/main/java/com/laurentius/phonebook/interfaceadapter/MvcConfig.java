package com.laurentius.phonebook.interfaceadapter;

import com.laurentius.phonebook.usecase.ContactCreateDsGateway;
import com.laurentius.phonebook.usecase.ContactCreateUseCase;
import com.laurentius.phonebook.usecase.ContactPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public ContactCreateUseCase contactCreateUseCase(JpaContactRepository repository) {
        ContactCreateDsGateway gateway = new JpaContact(repository);
        ContactPresenter contactPresenter = new ContactResponseFormatter();
        return new ContactCreateUseCase(gateway, contactPresenter);
    }
}
