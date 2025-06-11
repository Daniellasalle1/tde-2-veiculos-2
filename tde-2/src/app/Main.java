package app;

import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n1 - Cadastrar novo veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Sair");
            System.out.print(">> ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Tipo (1-Carro, 2-Moto, 3-Caminhão): ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = Integer.parseInt(sc.nextLine());

                    switch (tipo) {
                        case 1 -> {
                            System.out.print("Quantidade de portas: ");
                            int portas = Integer.parseInt(sc.nextLine());
                            veiculos.add(new Carro(placa, modelo, ano, portas));
                        }
                        case 2 -> {
                            System.out.print("Cilindrada: ");
                            int cilindrada = Integer.parseInt(sc.nextLine());
                            veiculos.add(new Moto(placa, modelo, ano, cilindrada));
                        }
                        case 3 -> {
                            System.out.print("Capacidade de carga (toneladas): ");
                            double carga = Double.parseDouble(sc.nextLine());
                            veiculos.add(new Caminhao(placa, modelo, ano, carga));
                        }
                        default -> System.out.println("Tipo inválido.");
                    }
                }
                case 2 -> {
                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        for (Veiculo v : veiculos) {
                            v.exibirDados();
                        }
                    }
                }
                case 3 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 3);
    }
}

