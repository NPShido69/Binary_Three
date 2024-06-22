package main;

import main.materia.controllers.ArbolBinario;
import main.materia.models.Node;

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
    }
}
