/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainnodos;

/**
 *
 * @author USUARIO
 */
public class StarLAN extends LAN {

    public Node buscarNodo(String name) {
    for (Node node : nodes) {
        if (node.getNombre().equals(name)) {
            return node;
        }
    }
    return null;
}
    public Packet crearPaquete(int size) {
    return new Packet(size);
}

    @Override
    public void enviarPaquete(Packet packet, Node fromNode, Node toNode) {
        System.out.println("Enviando paquete de " + fromNode.getNombre() + " a " + toNode.getNombre());
        totalPaquetesEnviados++;
        totalPaqueteTamaño += packet.getSize();
    }

    @Override
    public void paqueteDeDatos(Packet packet, Node fromNode) {
       System.out.println("Difundiendo paquete desde " + fromNode.getNombre() + " a todos los nodos");
        for (Node node : nodes) {
            if (!node.equals(fromNode)) {
                enviarPaquete(packet, fromNode, node);
            }
        }
    }
}