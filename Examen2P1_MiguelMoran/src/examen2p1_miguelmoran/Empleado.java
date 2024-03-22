/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_miguelmoran;

/**
 *
 * @author flash
 */
public class Empleado {
    private int ID;
    private String Nombre;
    private String Puesto;
    private int Salario;
    private String Departamento;

    public Empleado(int ID, String Nombre, String Puesto, int Salario, String Departamento) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Puesto = Puesto;
        this.Salario = Salario;
        this.Departamento = Departamento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }
    
    
}
