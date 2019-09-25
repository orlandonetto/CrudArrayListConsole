package com.example.crud.views;

import com.example.crud.controllers.Controller;
import com.example.crud.models.Car;

import java.util.List;
import java.util.Scanner;

public class Display {

    private Scanner scanner;

    public Display() {

        scanner = new Scanner(System.in);
        while (true) {

            // Mensagem do console
            System.out.println("\n\n\n");
            System.out.println("Digite [1] para Inserir;");
            System.out.println("Digite [2] para Alterar;");
            System.out.println("Digite [3] para Excluir;");
            System.out.println("Digite [4] para Buscar;");
            System.out.println("Digite [5] para Visualizar Relatório dos carros;");
            System.out.println("Digite [6] para Visualizar Relatório por ano de fabricação;");
            System.out.println("Digite [7] para Sair;");

            // Texto de Entrada
            String option = scanner.next();

            try {
                // Verificando e executando ação de acordo com o que foi digitado.
                switch (option) {

                    // 1 = Inserir
                    case "1":
                        inserir();
                        break;

                    // 2 = Alterar
                    case "2":
                        alterar();
                        break;

                    // 3 = Excluir
                    case "3":
                        excluir();
                        break;

                    // 4 = Buscar
                    case "4":
                        buscar();
                        break;

                    // 5 = Relatório dos carros (Listar Todos)
                    case "5":
                        listarAllInfo();
                        break;

                    // 6 = Relatório por ano de fabricação
                    case "6":
                        listarPorAno();
                        break;

                    // Stop
                    case "7":
                        System.exit(0);

                    default:
                        System.out.println("Opção Inválida, tente novamente!");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage() + ". Tente novamente!");
            }

        }

    }

    private void inserir() {
        Car car = formObject();

        // Inserindo
        boolean operacao = new Controller().insert(car);

        if (operacao)
            System.out.println("Salvo com sucesso!");
        else
            System.out.println("Objeto não salvo! Tente novamente.");
    }

    private void listar() {
        List<Car> cars = new Controller().getAll();

        for (int i = 0; i < cars.size(); i++) {
            System.out.println("[" + i + "] " + cars.get(i).getModelo() + " | " + cars.get(i).getPlaca());
        }

    }

    private void listarAllInfo() {
        List<Car> cars = new Controller().getAll();

        for (int i = 0; i < cars.size(); i++) {
            System.out.println("[" + i + "] " + cars.get(i).toString());
        }
    }

    private void listarPorAno() {

        System.out.println("Digite o ano inicial: ");
        int anoInicial = Integer.parseInt(scanner.next());

        System.out.println("Digite o ano final: ");
        int anoFinal = Integer.parseInt(scanner.next());

        List<Car> result = new Controller().findByAnos(anoInicial, anoFinal);
        System.out.println("Resultado: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).toString());
        }
    }

    private void buscar() {

        System.out.println("    Digite [1] para buscar pelo modelo;");
        System.out.println("    Digite [2] para pesquisar por preço");
        System.out.println("    Digite [0] para cancelar");
        String option = scanner.next();

        switch (option) {
            // Busca pelo modelo
            case "1":
                System.out.println("Digite o modelo do carro: ");
                String s1 = scanner.next();

                List<Car> result1 = new Controller().findByModelo(s1);
                System.out.println("Resultado: ");
                for (int i = 0; i < result1.size(); i++) {
                    System.out.println(result1.get(i).toString());
                }
                break;

            // Busca pelo preço
            case "2":
                System.out.println("Digite o preço inicial: ");
                double d1 = Double.parseDouble(scanner.next());

                System.out.println("Digite o preço final: ");
                double d2 = Double.parseDouble(scanner.next());

                List<Car> result2 = new Controller().findByPrice(d1, d2);
                System.out.println("Resultado: ");
                for (int i = 0; i < result2.size(); i++) {
                    System.out.println(result2.get(i).toString());
                }
                break;

            case "0":
                System.out.println("Cancelado!");
                break;

            default:
                System.out.println("Opção Inválida!");
                break;
        }
    }

    private void alterar() {
        int index = selectObject();

        Car car = formObject();

        new Controller().update(index, car);
    }

    private void excluir() {
        int index = selectObject();

        System.out.println("Deseja realmente excluir este objeto? \nDigite [1] para Confirmar, ou [0] para Cancelar");
        String confirm = scanner.next();

        if (confirm.equals("1")) {
            boolean operacao = new Controller().delete(index);

            if (operacao)
                System.out.println("Excluído com sucesso!");
            else
                System.out.println("Não Excluído");
        } else {
            System.out.println("Operação cancelada com sucesso!");
        }
    }

    private Car formObject() {

        System.out.println("Digite a placa do carro: ");
        String s1 = scanner.next();

        System.out.println("Digite a marca do carro: ");
        String s2 = scanner.next();

        System.out.println("Digite o modelo do carro: ");
        String s3 = scanner.next();

        System.out.println("Digite a cor do carro: ");
        String s4 = scanner.next();

        System.out.println("Digite a quilometragem do carro: ");
        double d1 = Double.parseDouble((scanner.next()).replace(",", "."));

        System.out.println("Digite o ano de fabricação do carro: ");
        int i1 = Integer.parseInt(scanner.next());

        System.out.println("Digite o ano do modelo do carro: ");
        int i2 = Integer.parseInt(scanner.next());

        System.out.println("Digite as cilindradas do carro: ");
        int i3 = Integer.parseInt(scanner.next());

        System.out.println("Digite o Valor da tabela FIPE do carro: ");
        double d2 = Double.parseDouble((scanner.next()).replace(",", "."));

        System.out.println("Digite o combustível do carro: ");
        String s5 = scanner.next();

        System.out.println("Digite o final da placa do carro: ");
        String s6 = scanner.next();

        // Criando e atribuindo dados no objeto
        Car car = new Car();
        car.setPlaca(s1);
        car.setMarca(s2);
        car.setModelo(s3);
        car.setCor(s4);
        car.setQuilometragem(d1);
        car.setAnoFabricacao(i1);
        car.setAnoModelo(i2);
        car.setCilindradas(i3);
        car.setPrecoFIPE(d2);
        car.setCombustivel(s5);
        car.setFinalplaca(s6);

        return car;
    }

    private int selectObject() {
        System.out.println("Digite o id para selecionar.");
        listar();

        int index = Integer.parseInt(scanner.next());

        System.out.println("Objeto selecionado: " + new Controller().findById(index).toString());
        return index;
    }

}
