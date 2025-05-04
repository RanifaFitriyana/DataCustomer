/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datacustomor;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        CustomerDAO dao = new CustomerDAO();
        
        DataCustomor cust = new DataCustomor(null, "Budi Santoso", "budi@gmail.com");
        dao.addCustomer(cust);
        
        System.out.println("Customer berhasil ditambahkan.");
    }
}
