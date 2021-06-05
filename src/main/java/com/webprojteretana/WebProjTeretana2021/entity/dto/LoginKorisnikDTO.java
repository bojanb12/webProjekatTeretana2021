package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class LoginKorisnikDTO {
    public LoginKorisnikDTO() {
    }

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

    private String email;


    private String lozinka;

    public LoginKorisnikDTO(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }
}
