package com.evolving;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * weddingLayout
 */
public class weddingLayout {
    private fileReader reader = new fileReader();
    protected int tables; // No_mesas
    protected int guests; // Invitados
    protected int chairs; // No_pos
    protected ArrayList <ArrayList <Integer> > relationTable = new ArrayList< ArrayList <Integer> >(); // Tabla de relaciones entre invitados

    public void set_info(){
        JSONObject Obj = new JSONObject();
        JSONObject data = new JSONObject();
        JSONArray relations = new JSONArray();
        Obj = reader.getJSON();
        data = Obj.getJSONObject("fiesta");
        this.tables = data.getInt("No_mesas");
        this.chairs = data.getInt("No_pos");
        this.guests = data.getInt("Invitados");
        relations = Obj.getJSONArray("relaciones");
        int sizer = relations.length();
        JSONArray aux;
        for(int i=0; i< sizer; i++){
            relationTable.add(new ArrayList<Integer>());
            aux = relations.getJSONArray(i);
            for(int j=0;j<aux.length();j++){
                relationTable.get(i).add(aux.getInt(j));
            }
        }
    }
    public void print_info(){
        System.out.println("mesas: "+tables);
        System.out.println("invitados: "+guests);
        System.out.println("sillas: "+chairs);
    }

    public void print_table(){
        for(ArrayList <Integer> x : relationTable){
            System.out.print("{");
            for(Integer y : x){
                System.out.print(y+" ");
            }
            System.out.println("}");
        }
    }
}