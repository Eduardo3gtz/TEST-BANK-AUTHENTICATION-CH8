package com.ch8.tests_bank_ch8.operations;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/operations")
@RequiredArgsConstructor
public class OperationController {

    private final OperationRepository operationRepository;

    // POST: crea y guarda una operación válida
    @PostMapping
    public ResponseEntity<?> createOperation(@Valid @RequestBody OperationRequest request) {

        Operation op = Operation.builder()
                .bankCode(request.getBankCode())
                .branchCode(request.getBranchCode())
                .accountNumber(request.getAccountNumber())
                .personalKey(request.getPersonalKey())
                .createdAt(LocalDateTime.now())
                .build();

        Operation saved = operationRepository.save(op);

        // puedes regresar solo un mensaje o el objeto guardado
        return ResponseEntity.ok(saved);
    }

    // GET: lista todas las operaciones guardadas
    @GetMapping
    public List<Operation> getAllOperations() {
        return operationRepository.findAll();
    }
}
