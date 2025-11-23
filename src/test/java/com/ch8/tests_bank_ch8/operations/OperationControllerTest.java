package com.ch8.tests_bank_ch8.operations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OperationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // TC01 – Todos válidos (EC1, EC1, EC9, EC13)
    @Test
    void tc01_allValid_shouldReturn200() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    // TC02 – Bank code < 4 dígitos (EC2)
    @Test
    void tc02_bankCodeLessThan4Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "123",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC03 – Bank code > 4 dígitos (EC3)
    @Test
    void tc03_bankCodeMoreThan4Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "12345",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC04 – Bank code con letras (EC4)
    @Test
    void tc04_bankCodeNonNumeric_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "12A4",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC05 – Branch code < 4 dígitos
    @Test
    void tc05_branchCodeLessThan4Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "567",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC06 – Branch code > 4 dígitos
    @Test
    void tc06_branchCodeMoreThan4Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "56789",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC07 – Branch code con letras
    @Test
    void tc07_branchCodeNonNumeric_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "56A8",
                  "accountNumber": "1234567890",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC08 – Account number < 10 dígitos (EC10)
    @Test
    void tc08_accountLessThan10Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "123456789",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC09 – Account number > 10 dígitos (EC11)
    @Test
    void tc09_accountMoreThan10Digits_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "12345678901",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC10 – Account number con caracteres no numéricos (EC12)
    @Test
    void tc10_accountNonNumeric_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "12345678X0",
                  "personalKey": "Abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }

    // TC11 – Personal key válida en límite (16 chars) (EC13)
    @Test
    void tc11_personalKeyValidBoundary_shouldReturn200() throws Exception {
        // 16 caracteres:  Abcd1234Efgh5678
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "Abcd1234Efgh5678"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    // TC12 – Personal key sin mayúsculas (EC16)
    @Test
    void tc12_personalKeyMissingUppercase_shouldReturn400() throws Exception {
        String body = """
                {
                  "bankCode": "1234",
                  "branchCode": "5678",
                  "accountNumber": "1234567890",
                  "personalKey": "abc12345"
                }
                """;

        mockMvc.perform(post("/api/operations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());
    }
}
