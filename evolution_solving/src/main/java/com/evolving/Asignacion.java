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
        
        List<Integer> randInv = IntStream.range(0, this.numGuests).boxed().collect(Collectors.toList());
        Collections.shuffle(randInv);
        
        double tamX = Math.ceil(Math.sqrt(this.tables));
        int baseX = (int) tamX;
        int baseY, aux;
        int conta = 0;
        
        if(tamX*(tamX-1) >= this.numGuests){
            baseY = baseX - 1;
        }else{
            baseY = baseX;
        }
        
        this.scenario = new int[baseX][baseY][this.positions];
        this.padres = new int[this.numGuests];
        
        int mesa;
   
        for(int i=0; i<baseX; i++){
            for(int j=0; j<baseY; j++){
                mesa = (i*baseY)+j;
                if(conta==this.numGuests){break;}
                for(int k=0; k<this.positions; k++){
                    aux = randInv.get(conta);
                    this.padres[aux] = mesa;
                    this.scenario[i][j][k] = aux;
                    conta++;   
                }
            }
        }
        
    }
    
    public int[][][] getMatrix(){
        return this.scenario;
    }
    
    public int[] getPadres(){
        return this.padres;
    }
    
}

