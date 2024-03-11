package com.bank.config.message;

public record AccountMsgDto(Long accountNumber, String name, String email, String mobileNumber) {
}
