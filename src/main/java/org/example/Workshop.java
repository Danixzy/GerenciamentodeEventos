package org.example;

public class Workshop extends Evento {
    private int participantes;
    private static final int LIMITE_PARTICIPANTES = 30;

    public Workshop(String nome, String data, int participantes) {
        super(nome, data);
        if (participantes > LIMITE_PARTICIPANTES) {
            throw new IllegalArgumentException("O número máximo de participantes é 30.");
        }
        this.participantes = participantes;
    }

    @Override
    public void detalhes() {
        System.out.println("Workshop: " + nome + ", Data: " + data + ", Participantes: " + participantes);
    }
}
