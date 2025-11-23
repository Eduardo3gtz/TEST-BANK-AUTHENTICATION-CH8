package com.ch8.tests_bank_ch8.operations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class OperationRequest {

    // Bank Code – EC1..EC4
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "Bank code must be exactly 4 numeric digits")
    private String bankCode;

    // Branch Code – misma lógica que Bank Code
    @NotBlank
    @Pattern(regexp = "\\d{4}", message = "Branch code must be exactly 4 numeric digits")
    private String branchCode;

    // Account Number – EC9..EC12
    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Account number must be exactly 10 numeric digits")
    private String accountNumber;

    // Personal Key – EC13..EC18
    // 8–16 caracteres, al menos 1 mayúscula, 1 minúscula y 1 número
    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$",
            message = "Personal key must be 8-16 chars with upper, lower and digits"
    )
    private String personalKey;
}
