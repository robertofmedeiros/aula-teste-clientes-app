package br.com.senac.api.useCases.usuarios.domains;

public class UsuariosResponseDom {
    private Long id;
    private String email;
    private String senha;


    public UsuariosResponseDom() {
    }

    public UsuariosResponseDom(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
