package com.moluArchieve.assignment.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
class AssignControllerTest {

    @Autowired
    private AssignController controller;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("외부 API 데이터를 받아온다.")
    @Test
    void test() {
        // given

        // when

        // then
        MoluResponse moluResponse = controller.useApi();


        assertThat(moluResponse.getMessage()).isEqualTo("success");
        assertThat(moluResponse.getDataAllPage()).isEqualTo(119);
    }
}