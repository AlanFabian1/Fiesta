package com.evolving;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Asignacion {
    
    private final int tables;
    private final int positions;
    private final int numGuests;
    private int[] padres;
    private int [][][] scenario;
    
    public Asignacion(int mesas, int posiciones, int invitados){
        this.tables = mesas;
        this.positions = posiciones;
        this.numGuests = invitados;
        
        this.newSenerio();
    }
    
    private void newSenerio(){
        
        // Lista de 0 a n, siendo n, el número total de invitados menos 1
        List<Integer> randInv = IntStream.range(0, this.numGuests).boxed().collect(Collectors.toList());
        Collections.shuffle(randInv); // Desordenamos la lista aleatoriamente
        
        // Se busca el cuadrado más cercano al número de mesas disponibles para hacer la matriz de posiciónes
        double tamX = Math.ceil(Math.sqrt(this.tables));
        int baseX = (int) tamX;
        int baseY, aux; // aux recorre la lista desordenada, cada numero en esta representa a un invitado
        int conta = 0;
        
        // La condición es porque en algunos casos, es posible eliminar una columna completa
        // del cuadrado más cercano, y así ahorrar posiciónes
        if(tamX*(tamX-1) >= this.numGuests){
            baseY = baseX - 1;
        }else{
            baseY = baseX;
        }
        
        this.scenario = new int[baseX][baseY][this.positions]; // Matriz de 3 dimensiónes     - Propuesta Memo
        this.padres = new int[this.numGuests]; // Arreglo que indica la mesa de cada invitado - Propuesta Alan
        
        int mesa; // Controla el número de mesa actual
   
        // Llenamos la matriz y el arreglo con ayuda de la lista desordenada
        // No es necesario generar un número aleatorio de mesa por cada invitado
        // No es necesario comprobar los espacios disponibles en cada mesa
        for(int i=0; i<baseX; i++){
            for(int j=0; j<baseY; j++){
                mesa = (i*baseY)+j;
                if(conta==this.numGuests){break;}
                for(int k=0; k<this.positions; k++){
                    aux = randInv.get(conta); //se toman los primeros invitados de la lista y se acomodan en la mesa correspondiente
                    this.padres[aux] = mesa; // en el arreglo se coloca el número de mesa que le tocó al invitado ( aquí no vamos en el orden "correcto del arreglo")
                    this.scenario[i][j][k] = aux; // Le damos a cada mesa (en orden) los invitados de la lista
                    conta++;   
                }
            }
        }
        
    }
    
    public int[][][] getMatrix(){ // obtener la matriz de 3 dimensiónes
        return this.scenario;
    }
    
    public int[] getPadres(){ // obtener el arreglo padres
        return this.padres;
    }
    
}

