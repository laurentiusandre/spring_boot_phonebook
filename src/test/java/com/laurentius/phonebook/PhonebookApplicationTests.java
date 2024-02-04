package com.laurentius.phonebook;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactGateway;
import com.laurentius.phonebook.infrastructure.ContactRequestDto;
import com.laurentius.phonebook.infrastructure.ContactResponseDto;
import com.laurentius.phonebook.infrastructure.ContactResponseFormatter;
import com.laurentius.phonebook.usecase.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class PhonebookApplicationTests {
	ContactGateway contactGateway = mock(ContactGateway.class);
	ContactPresenter contactPresenter = mock(ContactPresenter.class);
	ContactCreateUseCase useCase = new ContactCreateUseCase(contactGateway, contactPresenter);

	ContactResponseFormatter contactResponseFormatter = new ContactResponseFormatter();

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateContactGateway() {
		Contact contact = new Contact("Andre", "12345678", "Bandung", "2008_andre@live.com");
		ContactRequestDto contactRequestDto = new ContactRequestDto(contact.getName(), contact.getNumber(), contact.getAddress(), contact.getEmail());

		useCase.create(contactRequestDto);

		verify(contactGateway, times(1)).save(any(Contact.class));
	}

	@Test
	void testSuccessResponseFormatter() {
		ContactResponseDto modelResponse = new ContactResponseDto("Andre", "2020-12-20T03:00:00.000");
		IContactResponseDto formattedResponse = contactResponseFormatter.prepareSuccessView(modelResponse);

		assertThat(formattedResponse.createdDate()).isEqualTo("2020-12-20 03:00:00");
	}
}
