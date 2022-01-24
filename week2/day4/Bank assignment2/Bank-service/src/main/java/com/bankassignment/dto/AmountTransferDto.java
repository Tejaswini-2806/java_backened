package com.bankassignment.dto;

public class AmountTransferDto {
    class TransferBalanceRequest {
        private Long fromAccountNumber;

        private Long toAccountNumber;

        private Double amount;

        public Long getFromAccountNumber() {
            return fromAccountNumber;
        }

        public void setFromAccountNumber(Long fromAccountNumber) {
            this.fromAccountNumber = fromAccountNumber;
        }

        public Long getToAccountNumber() {
            return toAccountNumber;
        }

        public void setToAccountNumber(Long toAccountNumber) {
            this.toAccountNumber = toAccountNumber;
        }

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }
    }
}
