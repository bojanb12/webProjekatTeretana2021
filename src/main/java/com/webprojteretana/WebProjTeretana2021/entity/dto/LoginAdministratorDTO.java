package com.webprojteretana.WebProjTeretana2021.entity.dto;

public class LoginAdministratorDTO {

    private Long id;

    private String email;

    private String lozinka;

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

    public LoginAdministratorDTO() {
    }

    public LoginAdministratorDTO(String email, String lozinka) {
        this.email = email;
        this.lozinka = lozinka;
    }

    public LoginAdministratorDTO(Long id, String email, String lozinka) {
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
