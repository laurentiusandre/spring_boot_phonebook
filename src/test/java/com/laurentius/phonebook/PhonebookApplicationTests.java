package com.laurentius.phonebook;

import com.laurentius.phonebook.entity.Contact;
import com.laurentius.phonebook.entity.ContactItf;
import com.laurentius.phonebook.entity.ContactItfFactory;
import com.laurentius.phonebook.interfaceadapter.ContactResponseFormatter;
import com.laurentius.phonebook.usecase.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class PhonebookApplicationTests {
	ContactCreateDsGateway contactDsGateway = mock(ContactCreateDsGateway.class);
	ContactPresenter contactPresenter = mock(ContactPresenter.class);
	ContactItfFactory contactItfFactory = mock(ContactItfFactory.class);
	ContactInputBoundary interactor = new ContactCreateInteractor(contactDsGateway, contactPresenter, contactItfFactory);

	ContactResponseFormatter contactResponseFormatter = new ContactResponseFormatter();

	@Test
	void contextLoads() {
	}

	@Test
	void testNameValidation() {
		ContactItf contact = new Contact("", "12345678", "Bandung", "mail@domain.com");

		assertThat(contact.nameIsValid()).isFalse();
	}

	@Test
	void testCreateContactGateway() {
		ContactItf contactItf = new Contact("Andre", "12345678", "Bandung", "2008_andre@live.com");
		ContactRequestModel contactRequestModel = new ContactRequestModel(contactItf.getName(), contactItf.getNumber(), contactItf.getAddress(), contactItf.getEmail());
		when(contactItfFactory.create(anyString(), anyString(), anyString(), anyString()))
				.thenReturn(new Contact(contactItf.getName(), contactItf.getNumber(), contactItf.getAddress(), contactItf.getEmail()));

		interactor.create(contactRequestModel);

		verify(contactDsGateway, times(1)).save(any(ContactDsRequestModel.class));
		verify(contactPresenter, times(1)).prepareSuccessView(any(ContactResponseModel.class));
	}

	@Test
	void testSuccessResponseFormatter() {
		ContactResponseModel modelResponse = new ContactResponseModel("Andre", "2020-12-20T03:00:00.000");
		ContactResponseModel formattedResponse = contactResponseFormatter.prepareSuccessView(modelResponse);

		assertThat(formattedResponse.getCreatedDate()).isEqualTo("2020-12-20 03:00:00");
	}
}
