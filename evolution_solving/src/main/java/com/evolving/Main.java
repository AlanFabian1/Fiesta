package com.evolving;

import java.util.Arrays;

// Aux file, to review functions.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        weddingLayout DF = new weddingLayout();
        DF.set_info();
        DF.print_info();
        DF.print_table();

        // Prueba del objeto "Asignación"
        Asignacion cromosoma1 = new Asignacion(DF.tables, DF.chairs, DF.guests);
        int [][][] mat1 = cromosoma1.getMatrix();
        int [] padres1 = cromosoma1.getPadres();

        System.out.println(Arrays.toString(padres1)); //Arreglo con el número de mesa por invitado
        System.out.println(Arrays.deepToString(mat1)); // Matriz con los invitados asignados por mesa


    }
}