/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.manageaccounts.app;

import com.mycompany.manageaccounts.service.AccountService;
import java.util.Scanner;
import com.mycompany.manageaccounts.model.User;
import java.util.Date;
import java.util.List;
/**
 *
 * @author rayhan-andika
 */
public class Menu {
    AccountService accService;
    Scanner scan;

    public Menu(AccountService accService) {
        this.accService = accService;
        scan = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println(""
                + "Main Menu\n"
                + "1. Buat Akun\n"
                + "2. Tampilkan Semua akun\n"
                + "3. Edit Akun\n"
                + "4. Hapus Akun\n"
                + "5. Cari Akun Berdasarkan nama\n"
                + "6. Cari Akun Berdasarkan email\n"
                + "7. Cari Akun Berdasarkan username\n"
                + "8. Hapus Semua Akun\n"
                + "9. Keluar\n"
                + "Masukkan pilihan : ");
        int choice = scan.nextInt();
        return choice;
    }
    
    public void select() {
        boolean exit = false;
        while(!exit) {
            switch(mainMenu()) {
                case 1:
                    buatAkun();
                    break;
                case 2:
                    tampilkanSemuaAkun();
                    break;
                case 3:
                    editAkun();
                    break;
                case 4:
                    hapusAkun();
                    break;
                case 5:
                    cariAkunByNama();
                    break;
                case 6:
                    cariAkunByEmail();
                    break;
                case 7:
                    cariAkunByUsername();
                    break;
                case 8:
                    hapusSemuaAkun();
                    break;
                case 9:
                    System.out.println("Keluar dari Program");
                    exit = true;
                    break;
                default:
                    break;
            }
        }
    }
    
    public void buatAkun() {
        String email;
        String username;
        String password;
        String fullName;
        System.out.println("Masukkan email : ");
        email = scan.next();
        System.out.println("Masukkan username : ");
        username = scan.next();
        System.out.println("Masukkan password : ");
        password = scan.next();
        System.out.println("Masukkan full name : ");
        scan.nextLine();
        fullName = scan.nextLine();
        User user  = new User(email, username, password, fullName, new Date());
        accService.createAccount(user);
        System.out.println("Akun baru berhasil dibuat");
    }
    
    public void tampilkanSemuaAkun() {
        int count = 0;
        List<User> users = accService.findAllAccount();
        for (User user : users) {
            count++;
            System.out.println("User No " + count);
            System.out.println("ID          : " + user.getId());
            System.out.println("Email       : " + user.getEmail());
            System.out.println("username    : " + user.getUsername());
            System.out.println("password    : " + user.getPassword());
            System.out.println("fullName    : " + user.getFullName());
            System.out.println("CreatedDate : " + user.getCreatedDate().toString());
            System.out.println("");
        }
    }
    
    public void editAkun() {
        String key;
        String email;
        String username;
        String password;
        String fullName;
        int count = 0;
        List<User> users = accService.findAllAccount();
        for (User user : users) {
            count++;
            System.out.println("User No " + count);
            System.out.println("ID          : " + user.getId());
            System.out.println("Email       : " + user.getEmail());
            System.out.println("username    : " + user.getUsername());
            System.out.println("password    : " + user.getPassword());
            System.out.println("fullName    : " + user.getFullName());
            System.out.println("CreatedDate : " + user.getCreatedDate().toString());
            System.out.println("");
        }
        System.out.println("Masukkan email akun yang ingin akunnya anda edit : ");
        key = scan.next();
        User user = accService.findByEmail(key);
        System.out.println("Edit email (asalnya " + user.getEmail() + " ) : ");
        email = scan.next();
        System.out.println("Edit username (asalnya " + user.getUsername() + " ) : ");
        username = scan.next();
        System.out.println("Edit password (asalnya " + user.getPassword() + " ) : ");
        password = scan.next();
        System.out.println("Edit full name (asalnya " + user.getFullName() + " ) : ");
        scan.nextLine();
        fullName = scan.nextLine();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setFullName(fullName);
        accService.updateAccount(user);
        System.out.println("Akun Dengan ID : "+ user.getId() + " telah di update");
    }
    
    public void hapusAkun() {
        String key;
        int count = 0;
        List<User> users = accService.findAllAccount();
        for (User user : users) {
            count++;
            System.out.println("User No " + count);
            System.out.println("ID          : " + user.getId());
            System.out.println("Email       : " + user.getEmail());
            System.out.println("username    : " + user.getUsername());
            System.out.println("password    : " + user.getPassword());
            System.out.println("fullName    : " + user.getFullName());
            System.out.println("CreatedDate : " + user.getCreatedDate().toString());
            System.out.println("");
        }
        System.out.println("Masukkan email akun yang ingin akunnya anda hapus : ");
        key = scan.next();
        User user = accService.findByEmail(key);
        accService.deleteAccount(user);
        System.out.println("Akun Dengan ID : "+ user.getId() + " telah di hapus");
    }
    
    public void cariAkunByNama() {
        int count = 0;
        String keyword;
        System.out.println("Masukkan keyword nama: ");
        scan.nextLine();
        keyword = scan.nextLine();
        List<User> users = accService.findByFullName(keyword);
        for (User user : users) {
            count++;
            System.out.println("Hasil Pencarian No " + count);
            System.out.println("ID          : " + user.getId());
            System.out.println("Email       : " + user.getEmail());
            System.out.println("username    : " + user.getUsername());
            System.out.println("password    : " + user.getPassword());
            System.out.println("fullName    : " + user.getFullName());
            System.out.println("CreatedDate : " + user.getCreatedDate().toString());
            System.out.println("");
        }
    }
    
    public void cariAkunByEmail() {
        String keyword;
        System.out.println("Masukkan keyword email: ");
        scan.nextLine();
        keyword = scan.nextLine();
        User user = accService.findByEmail(keyword);
        System.out.println("Hasil Pencarian");
        System.out.println("ID          : " + user.getId());
        System.out.println("Email       : " + user.getEmail());
        System.out.println("username    : " + user.getUsername());
        System.out.println("password    : " + user.getPassword());
        System.out.println("fullName    : " + user.getFullName());
        System.out.println("CreatedDate : " + user.getCreatedDate().toString());
        System.out.println("");
        
    }
    
    public void cariAkunByUsername() {
        int count = 0;
        String keyword;
        System.out.println("Masukkan keyword username: ");
        scan.nextLine();
        keyword = scan.nextLine();
        List<User> users = accService.findByUserName(keyword);
        for (User user : users) {
            count++;
            System.out.println("Hasil Pencarian No " + count);
            System.out.println("ID          : " + user.getId());
            System.out.println("Email       : " + user.getEmail());
            System.out.println("username    : " + user.getUsername());
            System.out.println("password    : " + user.getPassword());
            System.out.println("fullName    : " + user.getFullName());
            System.out.println("CreatedDate : " + user.getCreatedDate().toString());
            System.out.println("");
        }
    }
    
    public void hapusSemuaAkun() {
        accService.deleteAllAccount();
        System.out.println("Semua Akun Telah Terhapus");
    }
}
