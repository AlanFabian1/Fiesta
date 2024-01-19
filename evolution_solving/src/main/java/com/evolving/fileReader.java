package com.evolving;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONObject;

// file to fetch the data from a .json
public class fileReader {

    protected String getFile(){
        String path = new String();

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JSON files", "json");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().toString();
        }
        else{
            path = "Not existing file";
        }
        return path;
    }

    protected String readFile(){
        String content = new String();
        try{
            BufferedReader buffread = new BufferedReader(new FileReader(getFile()));
            String line;
            while((line = buffread.readLine()) != null){
                content+=line;
            }
            buffread.close();
        }
        catch(FileNotFoundException x){
            System.out.println("File not found");
        }
        catch(IOException x){
            System.out.println("Something strange happened, retry later...");
        }
        return content;
    }

    public JSONObject getJSON(){
        JSONObject content = new JSONObject(readFile());
        return content;
    }
    
}
