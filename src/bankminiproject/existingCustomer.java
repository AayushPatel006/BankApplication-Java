/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankminiproject;

/**
 *
 * @author rudan
 */
public class existingCustomer {
    int AccountNumber;
    String FirstName, LastName,Password,AccountType;
    Double Balance;
    
    public existingCustomer(int ac, String fname, String lname, Double b,String pass, String AccountType) {
        this.AccountNumber = ac;
        this.FirstName = fname;
        this.LastName = lname;
        this.Balance = b;
        Password = pass;
        this.AccountType = AccountType;
    }
}
