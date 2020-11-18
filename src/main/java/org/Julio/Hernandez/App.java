package org.Julio.Hernandez;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner Lectura = new Scanner(System.in);
    static ArrayList<Coche> Array_Coches = new ArrayList<Coche>();

    public static void main( String[] args )
    {
        leer_fichero();
        menu();
    }
    public static void menu() {
        int menu = 0;

        do {
            System.out.println("___________");
            System.out.println("1 - Opcion 1");
            System.out.println("2 - Ver array");
            System.out.println("3 - Salir");
            System.out.println("___________");

            try {
                menu = Lectura.nextInt();
                switch (menu) {
                    case 1:
                        System.out.println("Tremendo");
                        break;
                    case 2:
                        for(int i = 0; i < Array_Coches.size();i++){
                            System.out.println();
                            System.out.println(Array_Coches.get(i).Id);
                            System.out.println(Array_Coches.get(i).Marca);
                            System.out.println(Array_Coches.get(i).Modelo);
                            System.out.println(Array_Coches.get(i).Cilindrada);
                            System.out.println();
                        }

                        break;
                    case 3:
                        System.out.println("Saliendo");
                        menu = 5;
                        break;
                    default:
                        System.out.println("Otro numero");
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Te equivocashte");
                Lectura.next();
            }
        }while (menu != 5);
    }

    public static void leer_fichero(){
        File file = new File("coches.xml");


        String Id;
        String Marca;
        String Modelo;
        int Cilindrada = 0;



        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("coche");
            System.out.println("Número de coches: " + nList.getLength());

            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    Id = eElement.getAttribute("id");
                    Marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
                    Modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
                    Cilindrada = Integer.parseInt(eElement.getElementsByTagName("cilindrada").item(0).getTextContent());

                    Coche coche_temp = new Coche(Id,Marca,Modelo,Cilindrada);
                    Array_Coches.add(coche_temp);

                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
