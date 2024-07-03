package main.materia.controllers;

import main.materia.models.Node;

public class ArbolesAVL {
    private Node root;

    // Obtener la altura de un nodo
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    // Obtener el factor de equilibrio de un nodo
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    // Insertar un valor en el árbol AVL
    public Node insert(Node node, int value) {
        if (node == null) {
            System.out.println("Nodo a insertar: " + value);
            return new Node(value);
        }

        // Insertar en el subárbol izquierdo
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        }
        // Insertar en el subárbol derecho
        else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else {
            // El valor ya existe, no se permite duplicados
            return node;
        }

        // Actualizar la altura del nodo actual
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        // Calcular el balance del nodo
        int balance = getBalance(node);

        // Imprimir el mensaje de nodo insertado y balance
        System.out.println("Inserted node: " + node.getValue() + ", Balance: " + balance);

        // Casos de desequilibrio y rotaciones

        // Caso Izquierda - Izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            return rightRotate(node);
        }

        // Caso Derecha - Derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            return leftRotate(node);
        }

        // Caso Izquierda - Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Caso Derecha - Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        // Si no hay desequilibrio, devolver el nodo sin cambios
        return node;
    }

    // Rotación a la derecha
    private Node rightRotate(Node nodeR) {
        Node x = nodeR.getLeft();
        Node temp = x.getRight();

        // Realizar rotación
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        // Devolver nueva raíz
        return x;
    }

    // Rotación a la izquierda
    private Node leftRotate(Node nodeR) {
        Node y = nodeR.getRight();
        Node temp = y.getLeft();

        // Realizar rotación
        y.setLeft(nodeR);
        nodeR.setRight(temp);

        // Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        // Devolver nueva raíz
        return y;
    }

    // Método público para insertar un valor en el árbol AVL
    public void insert(int value) {
        root = insert(root, value);
        printTree();
        System.out.println("\n-------\n");
    }

    // Imprimir el árbol
    public void printTree() {
        printTreeNode(root, "", true);
    }

    // Imprimir un nodo del árbol de forma recursiva
    private void printTreeNode(Node root, String prefix, boolean isLeft) {
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
