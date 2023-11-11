/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainnodos;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class MainNodos {
    public static void main(String[] args) {
        StarLAN starLAN = new StarLAN();

        Node node1 = new Node("Nodo1");
        Node node2 = new Node("Nodo2");
        Node node3 = new Node("Nodo3");

        starLAN.agregarNodo(node1);
        starLAN.agregarNodo(node2);
        starLAN.agregarNodo(node3);

        Packet packet = starLAN.crearPaquete(100); 
        Node fromNode = node1; 
        Node toNode = node2;    

        starLAN.enviarPaquete(packet, fromNode, toNode);

        Packet broadcastPacket = starLAN.crearPaquete(150); 
        Node broadcastFromNode = node3; 

        starLAN.paqueteDeDatos(broadcastPacket, broadcastFromNode);

        starLAN.estadisticasDeRed();
    }
}
