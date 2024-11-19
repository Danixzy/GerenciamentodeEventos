package org.example;

public class EventoCorporativo extends Evento {
    private String ambiente;

    public EventoCorporativo(String nome, String data, String ambiente) {
        super(nome, data);
        this.ambiente = ambiente;
    }

    @Override
    public void detalhes() {
        System.out.println("Evento Corporativo: " + nome + ", Data: " + data + ", Ambiente reservado: " + ambiente);
    }
}
