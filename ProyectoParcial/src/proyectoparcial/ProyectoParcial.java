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
public class ProyectoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuadro matriz[][]= new Cuadro[6][5];
        try{   
        List<String> x=    Files.readAllLines(Paths.get("src/recursos/Cuadro.txt"));
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
        
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
        ArrayList<Cuadro> cluster= new ArrayList<>();
        int cont0=0;
        int cont1=0;
        int cont2=0;
        int cont3=0;
        
        for(int i=0;i<6;i++){
            for(int j=0;j<5;j++){
                Cuadro c= matriz[i][j];
                boolean estaRelacionado;
                if(j-1<0 && i-1>=0){ // tiene arriba pero no izquierda                
                    System.out.println(c.getColor()==matriz[i-1][j].getColor());                    
                }
                if(j-1>=0 && i-1<0){ //tiene izquierda pero no arriba
                    System.out.println(c.getColor()==matriz[i][j-1].getColor());
                }
                if(j-1>=0&&i-1>=0){//tiene izquierda y arriba
                    System.out.println(c.getColor()==matriz[i][j-1].getColor()||c.getColor()==matriz[i-1][j].getColor());
                }
                

        }

    }

        
    }
    
}
    

    

