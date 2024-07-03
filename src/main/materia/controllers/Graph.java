package main.materia.controllers;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.materia.models.NodeGraph;

public class Graph {
    private List<NodeGraph> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeGraph addNode(int value) {
        NodeGraph newNode = new NodeGraph(value);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(NodeGraph src, NodeGraph dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void printGraph() {
        for (NodeGraph node : nodes) {
            System.out.print("Vertex " + node.getValue() + ":");
            for (NodeGraph neighbor : node.getNeighbors()) {
                System.out.print(" -> " + neighbor.getValue());
            }
            System.out.println();
        }
    }

    public void getDFS(NodeGraph startNode) {
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(startNode, visited);
    }

    private void getDFSUtil(NodeGraph node, boolean[] visited) {
        visited[node.getValue() - 1] = true;
        System.out.print(node.getValue() + " ");

        for (NodeGraph neighbor : node.getNeighbors()) {
            if (!visited[neighbor.getValue() - 1]) {
                getDFSUtil(neighbor, visited);
            }
        }
    }

    public void getBFS(NodeGraph startNode) {
        boolean[] visited = new boolean[nodes.size()];
        Queue<NodeGraph> queue = new LinkedList<>();

        visited[startNode.getValue() - 1] = true;
        queue.add(startNode);

        while (!queue.isEmpty()) {
            NodeGraph node = queue.poll();
            System.out.print(node.getValue() + " ");

            for (NodeGraph neighbor : node.getNeighbors()) {
                if (!visited[neighbor.getValue() - 1]) {
                    visited[neighbor.getValue() - 1] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public int[][] getAdjacencyMatrix() {
        int[][] matrix = new int[nodes.size()][nodes.size()];

        for (int i = 0; i < nodes.size(); i++) {
            NodeGraph node = nodes.get(i);
            for (NodeGraph neighbor : node.getNeighbors()) {
                matrix[node.getValue() - 1][neighbor.getValue() - 1] = 1;
            }
        }

        return matrix;
    }

    public void printAdjacencyMatrix() {
        int[][] matrix = getAdjacencyMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }
}
