package com.ch8.tests_bank_ch8.operations;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankCode;
    private String branchCode;
    private String accountNumber;

    // En un sistema real NO guardarías la llave en texto plano,
    // pero para el ejercicio la dejamos así.
    private String personalKey;

    private LocalDateTime createdAt;
}
