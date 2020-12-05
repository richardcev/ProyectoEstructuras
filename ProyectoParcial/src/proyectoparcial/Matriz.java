/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoparcial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Matriz {
    private int filas;
    private int columnas;
    
    private Cuadro matriz[][];
    
    public Matriz(){};
    


    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Cuadro[][] getMatriz() {
        return matriz;
    }
    
            
    public void crearMatriz(String file){
        ArrayList<Integer> filaColumna= new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            int cont= 0;
            while ((line = bufferedReader.readLine()) != null) {
                if(cont==2){
                    break;
                }
                filaColumna.add(Integer.parseInt(line));
                cont++;
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        filas= filaColumna.get(0);
        columnas= filaColumna.get(1);
        matriz= new Cuadro[filas][columnas];
        try{   
            List<String> x= Files.readAllLines(Paths.get(file));
            int fila=0;
            for (String s: x.subList(2, x.size())){
                String[]d=s.split(",");
                int columna=0;
                for(String l:d){
                    matriz[fila][columna]= new Cuadro(fila,columna,Integer.parseInt(l));
                    columna++;
                }
                fila++;             
            }
        }
        catch (IOException e){
            System.out.println("Error al leer Archivo:"+e);
        }

    }
    
    public void mostrarMatriz(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    
    

    
    
    
    
}
    
    

