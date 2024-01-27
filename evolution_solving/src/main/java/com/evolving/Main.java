package com.evolving;

import java.util.Arrays;

import org.json.JSONObject;

// Aux file, to review functions.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        fileReader x = new fileReader();
        JSONObject Obj = new JSONObject();
        Obj = x.getJSON();
        System.out.println(Obj.getString("content"));

        // Prueba del objeto "Asignación"
        Asignacion cromosoma1 = new Asignacion(3, 3, 9);
        int [][][] mat1 = cromosoma1.getMatrix();
        int [] padres1 = cromosoma1.getPadres();

        System.out.println(Arrays.toString(padres1)); //Arreglo con el número de mesa por invitado
        System.out.println(Arrays.deepToString(mat1)); // Matriz con los invitados asignados por mesa


    }
}