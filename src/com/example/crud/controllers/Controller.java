package com.example.crud.controllers;

import com.example.crud.database.Database;
import com.example.crud.models.Car;

import java.util.ArrayList;
import java.util.List;

// Controlador do Objeto
public class Controller {

    // Salvar
    public Boolean insert(Car car) {

        // Verificando se ja existe cadastrado no banco de dados
        boolean existe = findByPlaca(car.getPlaca()) != null;

        if (existe) {
            System.out.println("Objeto já existe no banco de dados...");

            return false;
        } else {
            // Inserindo
            Database.getInstance().getCars().add(car);

            return true;
        }
    }

    // Atualizar
    public Boolean update(Integer id, Car car) {
        // Verificando se existe o objeto que vai ser atualizado
        if (findById(id) == null) {
            // Não existe.
            System.out.println("Objeto não existe!");

            // Confirmando que não foi salvo.
            return false;
        }

        // Caso ele exista substitua ele no index = id;
        Database.getInstance().getCars().set(id, car);

        // Confirmando que foi salvo
        return true;
    }

    // Buscando objeto pelo index
    public Car findById(Integer id) {

        // Iniciando objeto
        Car car = null;

        // verificando se existe
        if (id < Database.getInstance().getCars().size() && id >= 0) {
            // Atribuindo o objeto
            car = Database.getInstance().getCars().get(id);
        }

        return car;
    }

    // Método Para Apagar
    public Boolean delete(Integer index) {
        // Verificando se existe o objeto que vai ser deletado
        if (findById(index) == null) {
            // Objeto não existe.
            System.out.println("Objeto não existe!");

            return false;
        }

        // Deletando e Confirmando que foi deletado
        return Database.getInstance().getCars().remove(findById(index));
    }

    public List<Car> getAll() {
        return Database.getInstance().getCars();
    }

    public Car findByPlaca(String placa) {
        List<Car> cars = Database.getInstance().getCars();
        Car car = null;

        for (Car c : cars)
            if (c.getPlaca().equalsIgnoreCase(placa))
                car = c;

        return car;
    }

    public List<Car> findByModelo(String modelo) {
        List<Car> cars = Database.getInstance().getCars();
        List<Car> result = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getModelo().matches(".*" + modelo.toUpperCase() + ".*")) {
                result.add(cars.get(i));
            }
        }

        return result;
    }

    public List<Car> findByPrice(double d1, double d2) {
        List<Car> cars = Database.getInstance().getCars();
        List<Car> result = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getPrecoFIPE() >= d1 && cars.get(i).getPrecoFIPE() <= d2) {
                result.add(cars.get(i));
            }
        }

        return result;
    }

    public List<Car> findByAnos(int anoInicial, int anoFinal) {
        List<Car> cars = Database.getInstance().getCars();
        List<Car> result = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getAnoFabricacao() >= anoInicial && cars.get(i).getAnoFabricacao() <= anoFinal) {
                result.add(cars.get(i));
            }
        }

        return result;
    }
}