package siit.hotel_booking_web_app.customer.serviceTests;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import siit.hotel_booking_web_app.exceptions.customer.CustomerNotFoundException;
import siit.hotel_booking_web_app.exceptions.loyalty.LoyaltyNotFoundException;
import siit.hotel_booking_web_app.mapper.customer.CustomerDtoToNttMapper;
import siit.hotel_booking_web_app.mapper.customer.CustomerNttToDtoMapper;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerCreateNewDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerRequestDto;
import siit.hotel_booking_web_app.model.dto.customerDto.CustomerUpdateDto;
import siit.hotel_booking_web_app.model.entities.CustomerEntity;

import siit.hotel_booking_web_app.model.entities.CustomerLoyaltyEntity;
import siit.hotel_booking_web_app.repository.CustomerLoyaltyRepository;
import siit.hotel_booking_web_app.repository.CustomerRepository;
import siit.hotel_booking_web_app.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerNttToDtoMapper customerNttToDtoMapper;

    @Mock
    private CustomerDtoToNttMapper customerDtoToNttMapper;

    @Mock
    private CustomerLoyaltyRepository customerLoyaltyRepository;

    private CustomerLoyaltyEntity CUSTOMER_Loyalty = CustomerLoyaltyEntity.builder()
            .loyaltyId(1)
            .loyaltyLevelName("Unranked")
            .discountPercent(0)
            .build();

    private CustomerEntity CUSTOMER_ENTITY = CustomerEntity.builder()
            .customerId(1)
            .firstName("Florin")
            .lastName("Piersic")
            .socialId("ZV123123")
            .customerEmail("piersic@piersic.piersic")
            .phoneNumber("123123123")
            .birthDate("20/10/1954")
            .city("Brasov")
            .address("Piersic street")
            .loyaltyLevel(CUSTOMER_Loyalty)
            .build();

    private CustomerRequestDto CUSTOMER_DTO = CustomerRequestDto.builder()
            .customerId(1)
            .firstName("Florin")
            .lastName("Piersic")
            .socialId("ZV123123")
            .customerEmail("piersic@piersic.piersic")
            .phoneNumber("123123123")
            .birthDate("20/10/1954")
            .city("Brasov")
            .address("Piersic street")
            .loyaltyLevel(CUSTOMER_Loyalty)
            .build();

    private CustomerCreateNewDto NEW_CUSTOMER_CREATE_DTO = CustomerCreateNewDto.builder()
            .firstName("Florin")
            .lastName("Piersic")
            .socialId("ZV123123")
            .customerEmail("piersic@piersic.piersic")
            .phoneNumber("123123123")
            .birthDate("20/10/1954")
            .city("Brasov")
            .address("Piersic street")
            .loyaltyLevel(CUSTOMER_Loyalty)
            .build();

    @Test
    public void getAllCustomers_givenNoCustomers_thenReturnEmptyList() {

        when(customerRepository.findAll()).thenReturn(Lists.emptyList());

        var allCustomers = customerService.getAllCustomers();

        assertThat(allCustomers).isNotNull();
        assertThat(allCustomers.isEmpty()).isTrue();
    }

    @Test
    public void getAllCustomers_givenExistingCustomer_thenReturnCustomerList() {

        List<CustomerEntity> customerEntityList = new ArrayList<>();
        customerEntityList.add(CUSTOMER_ENTITY);
        customerEntityList.add(CUSTOMER_ENTITY);
        customerEntityList.add(CUSTOMER_ENTITY);

        when(customerRepository.findAll()).thenReturn(customerEntityList);
        when(customerNttToDtoMapper.mapNttToDto(CUSTOMER_ENTITY)).thenReturn(CUSTOMER_DTO);

        var allCustomers = customerService.getAllCustomers();

        assertThat(allCustomers).isNotNull();
        assertThat(allCustomers.size()).isEqualTo(3);
        assertThat(allCustomers.get(0)).isNotNull();
        assertThat(allCustomers.get(0).getCity()).isEqualTo(CUSTOMER_ENTITY.getCity());
    }

    @Test
    public void getCustomerDetails_givenExistingCustomerId_thenReturnCustomerDetails() {

        when(customerRepository.findById(1)).thenReturn(Optional.ofNullable(CUSTOMER_ENTITY));
        assert CUSTOMER_ENTITY != null;
        when(customerNttToDtoMapper.mapNttToDto(CUSTOMER_ENTITY)).thenReturn(CUSTOMER_DTO);
        CustomerRequestDto customerRequestDto = customerService.getCustomerById(1);

        assertThat(customerRequestDto).isNotNull().isEqualTo(CUSTOMER_DTO);
    }


    @Test
    public void getCustomerDetails_givenInvalidCustomerId_thenReturnException() {

        Integer customerId = 1;

        when(customerRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.catchThrowable(() -> customerService.getCustomerById(customerId));

        assertThat(throwable).isInstanceOf(CustomerNotFoundException.class);
    }

    @Test
    public void getCustomerDetails_givenLoyaltyLevel_thenReturnCustomerDetails() {

        List<CustomerEntity> customerEntityList = new ArrayList<>();
        customerEntityList.add(CUSTOMER_ENTITY);
        customerEntityList.add(CUSTOMER_ENTITY);
        customerEntityList.add(CUSTOMER_ENTITY);
        customerEntityList.add(CUSTOMER_ENTITY);

        when(customerLoyaltyRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(CUSTOMER_Loyalty));
        when(customerRepository.findAllByLoyaltyLevel(ArgumentMatchers.any())).thenReturn(customerEntityList);
        when(customerNttToDtoMapper.mapNttToDto(CUSTOMER_ENTITY)).thenReturn(CUSTOMER_DTO);

        var allCustomers = customerService.getByLoyaltyLevel(1);

        assertThat(allCustomers).isNotNull();
        assertThat(allCustomers.size()).isEqualTo(4);
        assert CUSTOMER_Loyalty != null;
        assertThat(allCustomers.get(1).getLoyaltyLevel().getLoyaltyId()).isEqualTo(CUSTOMER_Loyalty.getLoyaltyId());
        assertThat(allCustomers.get(1).getLoyaltyLevel().getLoyaltyLevelName()).isEqualTo(CUSTOMER_Loyalty.getLoyaltyLevelName());
        assertThat(allCustomers.get(1).getLoyaltyLevel().getDiscountPercent()).isEqualTo(CUSTOMER_Loyalty.getDiscountPercent());
    }

    @Test
    public void getCustomerDetails_givenLoyaltyLevelNonexistent_thenReturnException() {

        Integer loyaltyLevel = 6;

        when(customerLoyaltyRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());
        Throwable throwable = Assertions.catchThrowable(() -> customerService.getByLoyaltyLevel(loyaltyLevel));

        assertThat(throwable).isInstanceOf(LoyaltyNotFoundException.class);
    }

    @Test
    public void createCustomerNtt_givenCorrectCustomerDetails_thenReturnNewCustomerDto() {

        when(customerDtoToNttMapper.mapDtoToNtt(NEW_CUSTOMER_CREATE_DTO)).thenReturn(CUSTOMER_ENTITY);
        when(customerRepository.save(CUSTOMER_ENTITY)).thenReturn(CUSTOMER_ENTITY);
        when(customerNttToDtoMapper.createNttFromDto(CUSTOMER_ENTITY)).thenReturn(NEW_CUSTOMER_CREATE_DTO);

        CustomerCreateNewDto newCustomer = customerService.createCustomerNtt(NEW_CUSTOMER_CREATE_DTO);

        assertThat(newCustomer).isNotNull();
        assertThat(newCustomer.getCity()).isEqualTo(CUSTOMER_ENTITY.getCity());
        assertThat(newCustomer.getFirstName()).isEqualTo(CUSTOMER_ENTITY.getFirstName());

    }

    @Test
    public void updateCustomerDetails_givenNewValues_returnNewCustomerDetails() {

        CustomerUpdateDto customerUpdateDto = CustomerUpdateDto.builder()
                .customerId(1)
                .city("Bucuresti")
                .firstName("Mihai")
                .phoneNumber("0722222222")
                .build();

        when(customerRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(CUSTOMER_ENTITY));
        when(customerLoyaltyRepository.getOne(ArgumentMatchers.any())).thenReturn(CUSTOMER_Loyalty);
        when(customerNttToDtoMapper.mapNttToDto(CUSTOMER_ENTITY)).thenReturn(CUSTOMER_DTO);

        var result = customerService.updateCustomerNtt(customerUpdateDto);

        assertThat(result).isNotNull()
                .isSameAs(CUSTOMER_DTO);
    }
}
