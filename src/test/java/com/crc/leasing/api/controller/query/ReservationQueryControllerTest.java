package com.crc.leasing.api.controller.query;

import com.crc.leasing.api.dto.reservation.ReservationResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ReservationQueryControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    private static final String RESERVATION_URL = "/reservation";

    @BeforeEach
    void setUp() {
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.addBatch(
                    "INSERT INTO address (id, uuid, modification_date, deleted, street_Address, postal_Code, city_Name)" +
                            " VALUES (1,'aaa',null,false,'adasd 16','123-12','asd');");
            statement.addBatch(
                    "INSERT INTO office (" +
                            "id, uuid, modification_date, deleted, office_address_id, website_url, office_ceo)" +
                            " VALUES (2,'bbb',null,false,1,'asd.com','sad');");
            statement.addBatch("" +
                    "INSERT INTO office (" +
                    "id, uuid, modification_date, deleted, office_address_id, website_url, office_ceo) " +
                    "VALUES (6,'fff',null,false,1,'asd.com','asd');");
            statement.addBatch("" +
                    "INSERT INTO car (" +
                    "id, uuid, modification_date, deleted, brand, model, car_type, fuel_type, gearbox_type," +
                    " door_number, price_per_day, boot_capacity, office_dao_id) " +
                    "VALUES (3, 'ccc', null, false, 'asdasd', 'asdd', 'PASSENGER', 'GAS', 'MANUAL', '_3', 105, 1, 2);");
            statement.addBatch("" +
                    "INSERT INTO employee (id, uuid, modification_date, deleted, firstname, lastname, address_dao_id," +
                    " pesel, account_number, salary_amount, contract_type,  office_dao_id) " +
                    "VALUES (4,'ddd',null,false,'asdd','sadsa',1,'asdasd','123',1, 'B2B',2);");
            statement.addBatch("INSERT INTO client (id, uuid, modification_date, deleted, firstname, lastname," +
                    " email, birthdate)" +
                    " VALUES (5,'eee',null,false,'dsa','ads','sad','1999-12-12');");
            statement.addBatch(
                    "INSERT INTO reservation (" +
                            "id, uuid, modification_date, deleted, client_dao_id, receipt_id, restoration_id," +
                            " car_dao_id, start_date, end_date, price)" +
                            "VALUES (7, 'ggg', null, false, 5, 2, 2, 3, '2023-03-01', '2023-03-05', 500.00);");
            statement.addBatch(
                    "INSERT INTO reservation (" +
                            "id, uuid, modification_date, deleted, client_dao_id, receipt_id, restoration_id," +
                            " car_dao_id, start_date, end_date, price)" +
                            "VALUES (8, 'hhh', null, false, 5, 2, 2, 3, '2023-03-01', '2023-03-05', 500.00);");
            statement.addBatch(
                    "INSERT INTO reservation (" +
                            "id, uuid, modification_date, deleted, client_dao_id, receipt_id, restoration_id," +
                            " car_dao_id, start_date, end_date, price)" +
                            "VALUES (9, 'iii', null, false, 5, 2, 2, 3, '2023-03-01', '2023-03-05', 500.00);");
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.addBatch("DELETE FROM reservation;");
            statement.addBatch("DELETE  FROM client ;");
            statement.addBatch("DELETE FROM employee;");
            statement.addBatch("DELETE FROM car;");
            statement.addBatch("DELETE FROM office;");
            statement.addBatch("DELETE FROM address;");
            statement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetReservationsByDateRange() {
        LocalDate from = LocalDate.of(2023, 3, 1);
        LocalDate to = LocalDate.of(2023, 3, 28);
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(RESERVATION_URL)
                        .queryParam("from", from)
                        .queryParam("to", to)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(ReservationResponse.class);
    }


    @Test
    void testGetPagedReservationsByDateRangeIs200Status() {
        LocalDate from = LocalDate.of(2023, 3, 1);
        LocalDate to = LocalDate.of(2023, 3, 28);

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder.path(RESERVATION_URL + "/paged")
                        .queryParam("from", from)
                        .queryParam("to", to)
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .build())
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testGetReservationByUuid() {
        webTestClient.get()
                .uri(RESERVATION_URL + "/ggg")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ReservationResponse.class);
    }
}