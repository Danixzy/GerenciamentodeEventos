package org.example;

public class Reuniao extends Evento {
    private boolean isPrivada;
    private String senha;

    public Reuniao(String nome, String data, boolean isPrivada, String senha) {
        super(nome, data);
        this.isPrivada = isPrivada;
        if (isPrivada) {
            this.senha = senha;
        }
    }

    @Override
    public void detalhes() {
        System.out.println("Reunião: " + nome + ", Data: " + data + ", Tipo: " + (isPrivada ? "Privada" : "Pública"));
        if (isPrivada) {
            System.out.println("Senha: " + senha);
        }
    }
}
