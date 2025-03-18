package com.aurionpro.bank.dto;

import com.aurionpro.bank.enums.TransactionType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class TransactionRequestDto {
    
    @NotNull(message = "Transaction type cannot be null")
    private TransactionType transactionType;

    @Positive(message = "Amount must be positive")
    private double amount;

    @Positive(message = "Sender account ID must be a positive number")
    @Size(min = 6, max = 6, message = "Sender account number must be 6 digits long !")
    private int senderAccountId;

    @Positive(message = "Receiver account ID must be a positive number")
    @Size(min = 6, max = 6, message = "Receiver account number must be 6 digits long !")
    private int receiverAccountId;
}