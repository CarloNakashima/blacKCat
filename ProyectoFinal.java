/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Nakashima
 */
public class ProyectoFinal {

    public static String[] textoArray = new String[20];
    public static  String[] Students = new String [5];
    public static String[] Comments = new String[5];
    public static void main(String[] args) throws IOException
    {
       boolean opc = true;
       boolean opc2 = true;
       Scanner sc = new Scanner(System.in);
       
       while (opc==true)
       {
           System.out.println("===MENU===");
           System.out.println("Leer .txt=1");
           System.out.println("Salir=2");
           int SW = sc.nextInt();
           switch(SW)
           {
               case 1:
                   while(opc2==true)
                   {
                       System.out.println("==MENU 2==");
                       System.out.println("Imprimir Original=1");
                       System.out.println("Imprimir Colado=2");
                       System.out.println("Generar Excel=3");
                       System.out.println("Mostrar tablas=4");
                       System.out.println("Salir=5");
                       int W = sc.nextInt();
                       switch(W)
                       {
                           case 1:
                               LeerOriginal();
                               break;
                           case 2:
                               colado();
                               break;
                           case 3:
                               Excel();
                               break;
                               
                           case 4:
                               tablaColumna();
                               break;
                           case 5:
                               opc2=false;
                               break;
                       }
                   }
                            
                            
                   break;
               case 2:
                   opc=false;
                   System.out.println("GRACIAS.");
                   break;
           }
           
       }
        
      
       
    }
    //METOTO QUE LEE Y MUESTRA EL ARCHIVO .TXT ORIGINAL
    public static void LeerOriginal() throws FileNotFoundException, IOException
    {
        File archivo = new File("C:\\Users\\Luis Felipe\\Desktop\\Proyecto.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
        while((linea=br.readLine())!=null)
        {
            System.out.println(linea);
        }
    }
    
    
    //METODO QUE ELIMINA LAS PALABRAS QUE NO SON NECESARIOS EN LAS TABLAS
    public static void colado() throws FileNotFoundException, IOException
    {
        
    File archivo = new File("C:\\Users\\Luis Felipe\\Desktop\\Proyecto.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();
       
        String linea2;
        String linea3;
        String linea4;
        String linea5;
        String linea6;
        String linea7;
        String linea8;
        String linea9;
        String linea10;
        String linea11;
        String linea12;
        String linea13;
        String lineaF;
        String Linea="";
        String Linea2="";
        String Linea3="";
        String LineaF="";
    int L=0;
    int LL=0;
    int S=0;
    int C=0;
    
        while((linea = br.readLine()) != null)
        {
           linea2=linea.replace("SELECT", "");
           linea3=linea2.replace("FROM","");
           linea4=linea3.replace("JOIN", "");
           linea5=linea4.replace("WHERE", "");
           linea6=linea5.replace("ORDER", "");
           linea7=linea6.replace("BY","");
           linea8=linea7.replace("ON","");
           linea9=linea8.replace("=", "");
           linea10=linea9.replace(",","");
           linea11=linea10.replace("ASC", "");
           linea12=linea11.replace(";","");
           linea13=linea12.replace("ï¿½Ensenadaï¿½", "");
           lineaF=linea13.replace(",","");
           
          
                 StringTokenizer prueba = new StringTokenizer(lineaF);
        
        
       while(prueba.hasMoreTokens())
         {
                                   
            textoArray[L]= (prueba.nextToken());
               System.out.println(textoArray[L]);      
          }
        
        }
    }
    
    //METODO QUE MUESTRA LAS TABLAS CON SU COLUMNAS
    public static void tablaColumna()
    {
        Students[0]="students";
        Students[1]="name";
        Students[2]="age";
        Students[3]="forum_username";
        Students[4]="city";
        Comments[0]="comments";
        Comments[1]="comment";
        Comments[2]="forum_id";
        Comments[3]="forum_username";
        System.out.println("");
        System.out.println("STUDENTS");
        for (int i = 0; i < Students.length; i++) 
        {
            
            
            System.out.println(Students[i]);
            
            
        }
        System.out.println("");
        System.out.println("COMENTS");
        for (int i = 0; i < 4; i++) 
        {
           
            System.out.println(Comments[i]); 
        }
        System.out.println("");
       
        
        
    }
    
    //METODO QUE GENERA UN ARCHIVO EXCEL CON LOS DATOS DEL ARCHIVO .TXT
    public static void Excel()
    {
       Workbook book = new HSSFWorkbook();
       Sheet sheet = book.createSheet("Tabla");
    
       Students[0]="students";
        Students[1]="name";
        Students[2]="age";
        Students[3]="forum_username";
        Students[4]="city";
        Comments[0]="comments";
        Comments[1]="comment";
        Comments[2]="forum_id";
        Comments[3]="forum_username";
        
        Row row = sheet.createRow(1);
        Row R = sheet.createRow(0);
        Row RR = sheet.createRow(4);
        Row RRR=sheet.createRow(5);
            for (int j = 0; j < Students.length; j++) 
            {
                
                    if (Students[j].equals("students")) 
                    {
                         
              R.createCell(2).setCellValue(Students[0]);
              RR.createCell(1).setCellValue(Comments[0]);
                    }
                    else if(Students[j].equals("name"))
                    {
                        
              row.createCell(0).setCellValue(Students[1]);
              RRR.createCell(0).setCellValue(Comments[1]);
                    }
                    else if(Students[j].equals("age"))
                    {
                        
              row.createCell(1).setCellValue(Students[2]);
              RRR.createCell(1).setCellValue(Comments[2]);
                    }
                    else if(Students[j].equals("forum_username"))
                    {
                        
              row.createCell(2).setCellValue(Students[3]);
              RRR.createCell(2).setCellValue(Comments[3]);
                    }
                    else if(Students[j].equals("city"))
                    {
                        
              row.createCell(3).setCellValue(Students[4]);
                    }
              
        }
       
      
              
       
       try{
       FileOutputStream fileout = new FileOutputStream("Excel.xls");
       book.write(fileout);
       fileout.close();
       
       }catch(FileNotFoundException ex){
           Logger.getLogger(ProyectoFinal.class.getName()).log(Level.SEVERE,null,ex);
       
       } catch (IOException ex) { 
           Logger.getLogger(ProyectoFinal.class.getName()).log(Level.SEVERE,null,ex);}
    }
  
   
   
    
}
