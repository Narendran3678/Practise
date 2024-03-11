package com.bank.constant;

public class BankConstants {
    private BankConstants() {
    }
    public enum ACCOUNT_TYPE {
        SAVINGS,
        CURRENT
    }
    public enum EVENT_EXCHANGE{
        SENDCOMMUNICATION_OUT_0("sendcommunication-out-0");
        private String exchangeName;
        EVENT_EXCHANGE(String exchangeName) {
            this.exchangeName=exchangeName;
        }
        public String getExchangeName() {
            return exchangeName;
        }

    }
}
