/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2p1_miguelmoran;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author flash
 */
public class Examen2P1_MiguelMoran {

    static Scanner sc = new Scanner(System.in);
    static Random rng = new Random();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean seguir = true;
        while (seguir) {
            System.out.println("1. Agregar empleados al sistema");
            System.out.println("2. Buscar empleados");
            System.out.println("3. Mostrar una lista con todos los empleados");
            System.out.println("4. Modificar la información de los empleados");
            System.out.println("5. Registrar el retiro de un empleado");
            System.out.println("6. Listar empleados por departamento");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            ArrayList<Empleado> company = new ArrayList<>();
            switch (opcion) {
                case 1 -> {
                    sc.nextLine();
                    NuevoEmpleado(company);
                }
                case 2 -> {
                    System.out.println("Por que criterio desea realizar su busqueda: ");
                    System.out.println("1. Nombre");
                    System.out.println("2. Numero de Identificacion");
                    System.out.println("Elija una opcion: ");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1 -> {
                            sc.nextLine();
                            System.out.println("Imgrese el nombre del empleado: ");
                            String nombre = sc.nextLine();
                            Empleado resultado = BuscarNombre(company, nombre);
                            System.out.println("Numero de identificacion: " + resultado.getID() + "     Nombre: " + resultado.getNombre() + "     Puesto: " + resultado.getPuesto() + "     Salario: " + resultado.getSalario() + "     Departamento: " + resultado.getDepartamento());
                        }
                        case 2 -> {
                            System.out.println("Imgrese el nombre del empleado: ");
                            int id = sc.nextInt();
                            Empleado resultado = BuscarID(company, id);
                            System.out.println("Numero de identificacion: " + resultado.getID() + "     Nombre: " + resultado.getNombre() + "     Puesto: " + resultado.getPuesto() + "     Salario: " + resultado.getSalario() + "     Departamento: " + resultado.getDepartamento());
                        }
                        default -> {
                            System.out.println("Elija una opcion valida");
                        }
                    }
                }
                case 3 -> {
                    Listar(company);
                }
                case 4 -> {
                    Listar(company);
                    int empleado = sc.nextInt();
                    System.out.println("Que informacion desea cambiar: ");
                    System.out.println("1. Nombre: ");
                    System.out.println("2. Puesto: ");
                    System.out.println("3. Salario: ");
                    System.out.println("4. Departamento: ");
                    System.out.println("Elija una opcion: ");
                    opcion = sc.nextInt();
                    switch(opcion){
                        case 1 ->{
                            System.out.println("Escriba el nuevo nombre: ");
                            sc.nextLine();
                            String nombre = sc.nextLine();
                            company.get(empleado).setNombre(nombre);
                            
                        }
                        case 2 ->{
                            System.out.println("Escriba el nuevo puesto: ");
                            sc.nextLine();
                            String puesto = sc.nextLine();
                            company.get(empleado).setPuesto(puesto);
                        }
                        case 3 ->{
                            System.out.println("Escriba el nuevo salario: ");
                            sc.nextLine();
                            int salario = sc.nextInt();
                            company.get(empleado).setSalario(salario);
                        }
                        case 4 ->{
                            System.out.println("Escriba el nuevo nombre: ");
                            sc.nextLine();
                            String Departamento = sc.nextLine();
                            company.get(empleado).setDepartamento(Departamento);
                        }
                        default ->{
                            System.out.println("Elija una opcion valida");
                        }
                    }
                }
                case 5 -> {
                    Listar(company);
                    System.out.println("Elija el empleado que desea eliminar: ");
                    int empleado = sc.nextInt();
                    company.remove(empleado);
                }
                case 6 -> {
                    System.out.print("Escriba el departamento que desea buscar: ");
                    sc.nextLine();
                    String departamento = sc.nextLine();
                    ArrayList<Empleado> Departamento = ListarDept(company, departamento);
                    if(Departamento.size() > 0){
                        Listar(Departamento);
                    } else {
                        System.out.println("Departemento vacio.");
                    }
                }
                case 7 -> {
                    seguir = false;
                }
                default -> {
                    System.out.println("Porfavor elija una opcion valida.");
                }
            }
        }
    }

    public static ArrayList<Empleado> NuevoEmpleado(ArrayList<Empleado> empleados) {
        int id = 0;
        while (id < 20) {
            id = rng.nextInt(131) + 20;
            for (int i = 0; i < empleados.size(); i++) {
                if (empleados.get(i).getID() == id) {
                    id = 0;
                }
            }
        }
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = sc.nextLine();
        int salario = 0;
        while (salario < 1) {
            System.out.print("Ingrese el salario del empleado: ");
            salario = sc.nextInt();
            if (salario < 1) {
                System.out.println("Ingrese un salario valido.");
            }
        }
        sc.nextLine();
        System.out.print("Ingrese el departamento al que pertenece: ");
        String departamento = sc.nextLine();
        Empleado empleado = new Empleado(id, nombre, puesto, salario, departamento);
        empleados.add(empleado);
        return empleados;
    }

    public static Empleado BuscarNombre(ArrayList<Empleado> empleados, String nombre) {
        Empleado empleado = new Empleado(0, "0", "0", 0, "0");
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equalsIgnoreCase(nombre)) {
                empleado = empleados.get(i);
            }
        }
        return empleado;
    }

    public static Empleado BuscarID(ArrayList<Empleado> empleados, int id) {
        Empleado empleado = new Empleado(0, "0", "0", 0, "0");
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getID() == id) {
                empleado = empleados.get(i);
            }
        }
        return empleado;
    }

    public static void Listar(ArrayList<Empleado> empleados) {
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            System.out.println("Numero de identificacion: " + empleado.getID() + "     Nombre: " + empleado.getNombre() + "     Puesto: " + empleado.getPuesto() + "     Salario: " + empleado.getSalario() + "     Departamento: " + empleado.getDepartamento());
        }
    }
    public static ArrayList<Empleado> ListarDept(ArrayList<Empleado> empleados, String departamento){
        ArrayList<Empleado> Departamento = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i).getDepartamento().equalsIgnoreCase(departamento)){
                Departamento.add(empleados.get(i));
            }
        }
        return Departamento;
    }
}
