package br.com.senac.api.useCases.clientes.domanis;

public class ClientesRequestDom {
    private String nome;
    private String sobreNome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
