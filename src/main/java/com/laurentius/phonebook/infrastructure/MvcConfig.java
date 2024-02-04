package com.laurentius.phonebook.infrastructure;

import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.usecase.*;
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

    @Bean
    public ContactGetUseCase contactGetUseCase(JpaContactRepository repository) {
        ContactGateway gateway = new ContactDatabaseGateway(repository);
        return new ContactGetUseCase(gateway);
    }

    @Bean
    public ContactUpdateUseCase contactUpdateUseCase(JpaContactRepository repository) {
        ContactGateway gateway = new ContactDatabaseGateway(repository);
        ContactPresenter contactPresenter = new ContactResponseFormatter();
        return new ContactUpdateUseCase(gateway, contactPresenter);
    }

    @Bean
    public ContactDeleteUseCase contactDeleteUseCase(JpaContactRepository repository) {
        ContactGateway gateway = new ContactDatabaseGateway(repository);
        ContactPresenter contactPresenter = new ContactResponseFormatter();
        return new ContactDeleteUseCase(gateway, contactPresenter);
    }
}
