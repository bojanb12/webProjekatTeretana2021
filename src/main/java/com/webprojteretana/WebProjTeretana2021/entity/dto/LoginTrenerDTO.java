package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class LoginTrenerDTO {

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    private Long id;

    private String email;

    private String lozinka;

    public LoginTrenerDTO() {
    }

    public LoginTrenerDTO(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    public LoginTrenerDTO(Long id, String email, String lozinka) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
