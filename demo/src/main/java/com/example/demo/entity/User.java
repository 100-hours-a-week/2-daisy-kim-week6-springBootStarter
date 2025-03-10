package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // 실제 DB 테이블명
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 증가 (Auto Increment)
    @Column(name="userId")
    private int userId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userPassword")
    private String userPassword;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name="userProfileImgUrl")
    private String userProfileImgUrl;

    public User() {}  // JPA 기본 생성자 필수

    // 생성자
    public User(String userName, String userPassword, String userEmail, String userProfileImgUrl) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userProfileImgUrl = userProfileImgUrl;
    }

    // Getter & Setter
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserProfileImgUrl() {
        return userProfileImgUrl;
    }
}
