package main;

import main.materia.controllers.ArbolBinario;
import main.materia.controllers.ArbolesAVL;
import main.materia.controllers.Graph;
import main.materia.controllers.Sets;
import main.materia.models.Node;
import main.materia.models.NodeGraph;

/*                   1                   
 *          2                  3
 *      4       5                       6
 *  7        8
*/

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        ArbolBinario arbolBinario = new ArbolBinario();
        
        Node nodeRoot = new Node(1);
        nodeRoot.setLeft(new Node(2));
        nodeRoot.setRight(new Node(3));

        nodeRoot.getLeft().setLeft(new Node(4));
        nodeRoot.getLeft().setRight(new Node(5));
        nodeRoot.getRight().setRight(new Node(6));

        nodeRoot.getLeft().getLeft().setLeft(new Node(7));
        nodeRoot.getLeft().getRight().setLeft(new Node(8));

        System.out.print("Preorder - Loop ---> ");
        arbolBinario.preOrderLoop(nodeRoot);
        System.out.print("Preorder - Recursivo ---> ");
        arbolBinario.preOrderRecursivo(nodeRoot);
        System.out.println("");
        arbolBinario.postOrderLoop(nodeRoot);
        System.out.println("");
        arbolBinario.postOrderRecursivo(nodeRoot);
        System.out.println("");
        arbolBinario.inOrderRecursivo(nodeRoot);

        ArbolesAVL tree = new ArbolesAVL();

        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            tree.insert(value);
        }
        runGraph();
    }

    private static void runGraph() {
        Graph graph = new Graph();
        //  NodeGraph node1=new NodeGraph(1);
        // NodeGraph node2=new NodeGraph(2);
        // NodeGraph node3=new NodeGraph(3);
        // NodeGraph node4=new NodeGraph(4);
        // NodeGraph node5=new NodeGraph(5);

        NodeGraph node1 = graph.addNode(1);
        NodeGraph node2 = graph.addNode(2);
        NodeGraph node3 = graph.addNode(3);
        NodeGraph node4 = graph.addNode(4);
        NodeGraph node5 = graph.addNode(5);

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node2, node4);
        graph.addEdge(node4, node5);

        graph.printGraph();

        System.out.println("DFS a partir del nodo 1:");
        graph.getDFS(node1);
        
        System.out.println(   "\nBFS a partir del nodo 1:");
        graph.getBFS(node1);

        System.out.println("\nMatriz de adyacencia:");
        graph.printAdjacencyMatrix();
        runSets();
    }

    public static void runSets(){
        Sets variableClase = new Sets();
    }
}
