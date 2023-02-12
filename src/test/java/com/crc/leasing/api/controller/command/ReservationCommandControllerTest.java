package com.crc.leasing.api.controller.command;

import com.crc.leasing.api.dto.AddressDto;
import com.crc.leasing.api.dto.car.CarRequest;
import com.crc.leasing.api.dto.client.ClientRequest;
import com.crc.leasing.api.dto.employee.EmployeeRequest;
import com.crc.leasing.api.dto.office.OfficeRequest;
import com.crc.leasing.api.dto.reservation.ReservationRequest;
import com.crc.leasing.api.dto.reservation.ReservationResponse;
import com.crc.leasing.infrastructure.database.jpa.car.entity.CarType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.DoorNumber;
import com.crc.leasing.infrastructure.database.jpa.car.entity.FuelType;
import com.crc.leasing.infrastructure.database.jpa.car.entity.GearboxType;
import com.crc.leasing.infrastructure.database.jpa.employee.entity.ContractType;
import com.crc.leasing.infrastructure.database.jpa.reservation.ReservationCommandDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ReservationCommandControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private ReservationCommandDAO reservationCommandDAO;

//    @Test
//    public void testCreateReservation() {
//        ReservationRequest reservationRequest = new ReservationRequest(
//                new ClientRequest(
//                        "uuid",
//                        "firstName",
//                        "lastName",
//                        "email",
//                        LocalDate.now()
//                ),
//                new OfficeRequest("uuid", new AddressDto("street", "64-100", "city"),"website","ceo"),
//                new OfficeRequest("uuid", new AddressDto("street", "64-100", "city"),"website","ceo"),
//                new CarRequest("uuid", "brand", "model", CarType.PASSENGER, FuelType.DIESEL_OIL, GearboxType.MANUAL, DoorNumber._3, 25.0, "officeId"),
//                LocalDateTime.now(),
//                LocalDateTime.now().plusDays(2),
//                new EmployeeRequest("uuid", "firstname", "lastname", new AddressDto("street", "postal", "city"), "pesel", "accNum", BigDecimal.TEN, ContractType.EMPLOYMENT_CONTRACT, "position", "officeId"),
//                new EmployeeRequest("uuid", "firstname", "lastname", new AddressDto("street", "postal", "city"), "pesel", "accNum", BigDecimal.TEN, ContractType.EMPLOYMENT_CONTRACT, "position", "officeId")
//        );
//        webTestClient.post()
//                .uri("/reservation")
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Mono.just(reservationRequest), ReservationRequest.class)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody(ReservationResponse.class);
//        System.out.println(reservationCommandDAO.findAll());
//    }
}