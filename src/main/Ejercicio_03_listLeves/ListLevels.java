package main.Ejercicio_03_listLeves;

import java.util.ArrayList;
import java.util.List;
import main.materia.models.Node;

public class ListLevels {

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> levels = new ArrayList<>();
        listLevelsHelper(root, 0, levels);
        return levels;
    }

    private void listLevelsHelper(Node node, int level, List<List<Node>> levels) {
        if (node == null) {
            return;
        }

        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node);

        listLevelsHelper(node.getLeft(), level + 1, levels);
        listLevelsHelper(node.getRight(), level + 1, levels);
    }
}