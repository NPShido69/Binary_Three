package main.materia.controllers;

import main.materia.models.Node;

public class ArbolesAVL {
    private Node root;

    //Obtener la altura de un node.
    
    private int height(Node node){

        if (node == null){
            return 0;
        }
        return node.getHeight();
    }

    //Método que obtenga el factor de balanceo o equilibrio.
    private int getBalance (Node node){
        if(node == null){
            return 0;
        }
        return height((node.getLeft())) - height(node.getRight());
    }
    public Node insert(Node node, int value){
        if (node == null){
         return new Node(value);
    }
    if (value > node.getValue()){
        node.setRight(insert(node.getRight(), value));
    } else if (value < node.getValue()){
        node.setLeft(insert(node.getLeft(), value));
    } else {
        return node;
    }

    //Actualizar la altura del predecesor o ancestro.
    node.setHeight(1+Math.max(height(node.getLeft()), height(node.getRight())));

    //Calcular el balance
    int balance = getBalance(node);

    //Si el nodo está desbalanceado tiene 3 casos.

    //Caso izquierda - izquierda
    if(balance > 1 && value < node.getLeft().getValue()){
        return rightRotate(node);
    }

    //Caso derecha - derecha
    if(balance < -1 && value > node.getRight().getValue()){
        return leftRotate(node);
    }

    //Caso izquierda - derecha
    if(balance > 1 && value > node.getLeft().getValue()){
        node.setLeft(leftRotate(node.getLeft()));
        return rightRotate(node);
    }

    //Caso derecha - izquierda
    if(balance < -1 && value < node.getRight().getValue()){
        node.setRight(rightRotate(node.getRight()));
        return leftRotate(node);
    }
    //Devolver el nodo sin cambios ni rotaciones
    return node;

}
    private Node rightRotate(Node nodeR){
        Node x = nodeR.getLeft();
        Node temp = x.getRight();

        //realizar la rotación
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        //Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight()))+ 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())));

        return x;
    }

    private Node leftRotate(Node nodeR){
        Node y = nodeR.getRight();
        Node temp = y.getLeft();

        //Realizar la rotación
        y.setLeft((nodeR));
        nodeR.setRight(temp);
        //Actualizando las alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight()))+ 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+ 1);

        return y;
    }


    public void insert(int value) {
        System.out.println("Nodo a insertar sera el " + value);
        root = insert(root, value);
        printTree();
        System.out.println("\n-------\n");
    }

    public void printTree() {
        printTreeNode(root, "", true);
    }

    public void printTreeNode(Node root, String prefix, boolean isLeft) {

        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }

}
