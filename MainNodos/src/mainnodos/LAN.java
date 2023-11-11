/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainnodos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public abstract class LAN {
    protected List<Node> nodes = new ArrayList<>();
    protected int totalPaquetesEnviados = 0;
    protected int totalPaqueteTamaño = 0;

    public void agregarNodo(Node node) {
        nodes.add(node);
    }

    public void removerNodo(Node node) {
        nodes.remove(node);
    }

    public void listarNodos() {
        for (Node node : nodes) {
            System.out.println(node.getNombre());
        }
    }

    public abstract void enviarPaquete(Packet packet, Node fromNode, Node toNode);
    public abstract void paqueteDeDatos(Packet packet, Node fromNode);

    public void estadisticasDeRed() {
        double averagePacketSize = totalPaqueteTamaño / (double) totalPaquetesEnviados;
        System.out.println("Total packets sent: " + totalPaquetesEnviados);
        System.out.println("Average packet size: " + averagePacketSize);
    }
}
