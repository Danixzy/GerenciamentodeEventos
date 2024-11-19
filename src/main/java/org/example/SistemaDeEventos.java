package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeEventos {
    private static ArrayList<Evento> eventos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n1- Registrar Evento");
            System.out.println("2- Excluir Evento");
            System.out.println("3- Listar Eventos");
            System.out.println("0- Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    registrarEvento();
                    break;
                case 2:
                    excluirEvento();
                    break;
                case 3:
                    listarEventos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void registrarEvento() {
        System.out.println("\n1- Workshop");
        System.out.println("2- Reunião");
        System.out.println("3- Evento Corporativo");
        System.out.print("Escolha o tipo de evento: ");
        int tipoEvento = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        System.out.print("Nome do evento: ");
        String nome = scanner.nextLine();

        System.out.print("Data do evento: ");
        String data = scanner.nextLine();

        switch (tipoEvento) {
            case 1:
                System.out.print("Quantidade de participantes (máx 30): ");
                int participantes = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                try {
                    eventos.add(new Workshop(nome, data, participantes));
                    System.out.println("Workshop registrado com sucesso.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.print("Reunião privada? (s/n): ");
                boolean isPrivada = scanner.nextLine().equalsIgnoreCase("s");
                String senha = "";
                if (isPrivada) {
                    System.out.print("Digite a senha da reunião: ");
                    senha = scanner.nextLine();
                }
                eventos.add(new Reuniao(nome, data, isPrivada, senha));
                System.out.println("Reunião registrada com sucesso.");
                break;
            case 3:
                System.out.print("Ambiente reservado: ");
                String ambiente = scanner.nextLine();
                eventos.add(new EventoCorporativo(nome, data, ambiente));
                System.out.println("Evento Corporativo registrado com sucesso.");
                break;
            default:
                System.out.println("Tipo de evento inválido.");
        }
    }

    private static void excluirEvento() {
        listarEventos();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento para excluir.");
            return;
        }

        System.out.print("Digite o número do evento que deseja excluir: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir a nova linha

        if (indice >= 0 && indice < eventos.size()) {
            eventos.remove(indice);
            System.out.println("Evento excluído com sucesso.");
        } else {
            System.out.println("Evento inválido.");
        }
    }

    private static void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            System.out.println("\nEventos cadastrados:");
            for (int i = 0; i < eventos.size(); i++) {
                System.out.print((i + 1) + ". ");
                eventos.get(i).detalhes();
            }
        }
    }
}
