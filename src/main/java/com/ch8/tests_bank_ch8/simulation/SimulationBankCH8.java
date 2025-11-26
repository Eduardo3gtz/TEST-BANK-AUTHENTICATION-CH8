package com.ch8.tests_bank_ch8.simulation;

import java.util.regex.Pattern;

public class SimulationBankCH8 {

    // REGEX basados en tus clases de equivalencia
    private static final Pattern BANK_BRANCH_REGEX = Pattern.compile("\\d{4}");
    private static final Pattern ACCOUNT_REGEX = Pattern.compile("\\d{10}");
    private static final Pattern PERSONAL_KEY_REGEX =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");

    public static void main(String[] args) {

        System.out.println("=== BANK APPLICATION SIMULATION (SPRINT 3) ===\n");

        // Caso 1: válido
        simulateCase("1234", "5678", "1234567890", "Abc12345", 150, "VALID CASE");

        // Caso 2: borde (personal key de 16 caracteres)
        simulateCase("9999", "0001", "9876543210", "Abcd1234Efgh5678", 300, "BOUNDARY CASE");

        // Caso 3: inválido (bank code < 4 dígitos)
        simulateCase("123", "5678", "1234567890", "Abc12345", 100, "INVALID CASE");
    }

    private static void simulateCase(String bank, String branch, String account,
                                     String key, int orderValue, String label) {

        System.out.println("\n----------------------------------------");
        System.out.println("Running: " + label);
        System.out.println("Bank Code: " + bank);
        System.out.println("Branch Code: " + branch);
        System.out.println("Account Number: " + account);
        System.out.println("Personal Key: " + key);
        System.out.println("Order Value: $" + orderValue);

        boolean validBank = BANK_BRANCH_REGEX.matcher(bank).matches();
        boolean validBranch = BANK_BRANCH_REGEX.matcher(branch).matches();
        boolean validAccount = ACCOUNT_REGEX.matcher(account).matches();
        boolean validKey = PERSONAL_KEY_REGEX.matcher(key).matches();

        if (validBank && validBranch && validAccount && validKey) {
            System.out.println("→ RESULT: SUCCESS – Operation accepted.");
        } else {
            System.out.println("→ RESULT: ERROR – Invalid input detected.");
            System.out.println("  DETAILS:");
            if (!validBank) System.out.println("  - Bank code must be exactly 4 numeric digits.");
            if (!validBranch) System.out.println("  - Branch code must be exactly 4 numeric digits.");
            if (!validAccount) System.out.println("  - Account number must be exactly 10 digits.");
            if (!validKey) System.out.println("  - Personal key must be 8–16 chars, with upper, lower & digits.");
        }
    }
}
