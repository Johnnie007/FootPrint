package com.eample.footprint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class FootPrintJsonTest{

    @Autowired
    private JacksonTester <FootPrint> json;

    @Test
    public void footPrintSerializationTest() throws IOException {
         User user = new User("Johnnie","5.9", 190.00, "typical", "active");
         User userTest = new User("Johnnie","5.9", 190.00, "typical", "active");

        FootPrint footPrint = new FootPrint(1L,user);

         assertThat(json.write(footPrint)).isStrictlyEqualToJson("expected.json");
         assertThat(json.write(footPrint)).hasJsonPathNumberValue("@.id");

         assertThat(json.write(footPrint)).extractingJsonPathNumberValue("@.id").isEqualTo(1);
         assertThat(json.write(footPrint)).hasSameClassAs("@.user");
    }

    @Test
    public void footPrintDeserialization() throws IOException{
        String expected = """
                {
                "id": 1,
                "user": {
                       "name": "Johnnie",
                       "height":"5.9",
                       "weight": 190.00,
                       "diet": "typical",
                       "lifestyle": "active"}
                }
                """;

        User userTest = new User("Johnnie","5.9", 190.00, "typical", "active");

        assertThat(json.parse(expected)).isEqualTo(new FootPrint(1L, userTest
                ));

        assertThat(json.parseObject(expected).user()).isEqualTo(userTest);
    }
}
