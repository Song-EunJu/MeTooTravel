package com.example.metootravel;

/*
    사용자 계정 정보 모델 클래스
 */
public class UserAccount {
    private String token; // firebase uid (고유 토큰 정보)
    private String email;
    private String password;

    public UserAccount() {} // firebase 에서는 빈 생성자로 해줘야 DB 조회할 때 오류가 안남

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
