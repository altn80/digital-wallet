/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.petrobras.digital.wallet;

/**
 *
 * @author kbos
 */
public class DigitalWallet {

    private int balance;
    private String walletId;
    private String username;
    private String userAccessCode;

    DigitalWallet(String walletId, String userName) {
        this.walletId = walletId;
        this.username = userName;

    }

    DigitalWallet(String walletId, String userName, String userAccessCode) {
        this.walletId = walletId;
        this.username = userName;
        this.userAccessCode = userAccessCode;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getUsername() {
        return username;
    }

    public String getUserAccessToken() {
        return userAccessCode;
    }

    public int getWalletBalance() {
        return this.balance;
    }

    public void setWalletBalance(int walletBalance) {
        this.balance = walletBalance;
    }

    void addMoney(int amount) throws TransactionException {
        validateAccess();
        validateAmount(amount);
        this.balance += amount;
    }

    void payMoney(int amount) throws TransactionException {
        validateAccess();
        validateAmount(amount);
        validateBalance(amount);
        this.balance-=amount;
    }

    private void validateAccess() throws TransactionException {
        if (this.userAccessCode == null) {
            throw new TransactionException("User not authorized", "USER_NOT_AUTHORIZED");
        }
    }

    private void validateAmount(int amount) throws TransactionException {
        if (amount <= 0) {
            throw new TransactionException("Amount should be greater than zero", "INVALID_AMOUNT");
        }
    }

    private void validateBalance(int parseInt) throws TransactionException {
        if (this.balance - parseInt < 0) {
            throw new TransactionException("Insufficient balance", "INSUFFICIENT_BALANCE");
        }
    }

}
