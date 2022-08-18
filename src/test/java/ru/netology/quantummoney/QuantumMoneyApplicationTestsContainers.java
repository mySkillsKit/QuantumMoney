package ru.netology.quantummoney;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.netology.quantummoney.model.Amount;
import ru.netology.quantummoney.model.ConfirmOperation;
import ru.netology.quantummoney.model.MoneyTransfer;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuantumMoneyApplicationTestsContainers {
    private final static int PORT = 5500;

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    public static GenericContainer<?> myapp = new GenericContainer<>("myapp:latest")
            .withExposedPorts(PORT);

    @Test
    void moneyTransferTest() {
        MoneyTransfer request = new MoneyTransfer(
                "1115666600101892",
                "05/23",
                "530",
                "5555636200001111",
                new Amount(67899, "RUB")
        );

        ResponseEntity<String> forEntity = restTemplate.postForEntity(
                "http://localhost:" + myapp.getMappedPort(PORT) + "/transfer", request, String.class);
        System.out.println(forEntity.getBody());
        String expected = "{\"operationId\":" + "\"1\"}";
        String actual = forEntity.getBody();
        Assert.assertEquals(expected, actual);
    }

   @Test
    void confirmOperationTest() {
       ConfirmOperation request = new ConfirmOperation("1","0000");

       ResponseEntity<String> forEntity = restTemplate.postForEntity(
               "http://localhost:" + myapp.getMappedPort(PORT) + "/confirmOperation", request, String.class);
       System.out.println(forEntity.getBody());
       String expected = "{\"operationId\":" + "\"1\"}";
       String actual = forEntity.getBody();
       Assert.assertEquals(expected, actual);
    }

}
