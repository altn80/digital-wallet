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
public class DigitalWalletTransaction {

    void addMoney(DigitalWallet digitalWallet, int parseInt) throws TransactionException {
        digitalWallet.addMoney(parseInt);
    }

    void payMoney(DigitalWallet digitalWallet, int parseInt) throws TransactionException {
        digitalWallet.payMoney(parseInt);
    }
    
}
