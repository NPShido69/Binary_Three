package main.materia.controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Sets {
    public Sets(){
        construirHashSet();
        System.out.println();
        construirLinkedHashSet();
        System.out.println();
        construirTreeSet();
        System.out.println();
        construirTreeSetConComparador();
    }
    //Construir y mostrar un HashSet
    public void construirHashSet(){
        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("Monitor");
        conjunto.add("Teclado");
        conjunto.add("Raton");
        conjunto.add("HDMI");
        conjunto.add("Monitor");
        conjunto.add("Case");
        conjunto.add("RAM");
        System.out.println("HashSet" + conjunto);
        //Eliminar un elemento
        conjunto.remove("Monitor");
        System.out.println("HashSet despues de eliminar un conjunto:" + conjunto);

        //Verificar si un elemento existe
        boolean contieneMonitor = conjunto.contains("Monitor");
        System.out.println("¿HashSet contiene 'Monitor'? + conjunto");

        //Obtener el tamaño de un conjunto
        int tamanio = conjunto.size();
        System.out.println("Tamaño del HashSet: " + tamanio);

    }

    public void construirLinkedHashSet(){
        HashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Monitor");
        conjunto.add("Teclado");
        conjunto.add("Raton");
        conjunto.add("HDMI");
        conjunto.add("Monitor");
        conjunto.add("Case");
        conjunto.add("RAM");
        System.out.println("LinkedHashSet: " + conjunto);

    }

    public void construirTreeSet(){
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Monitor");
        conjunto.add("Teclado");
        conjunto.add("Raton");
        conjunto.add("HDMI");
        conjunto.add("Monitor");
        conjunto.add("Case");
        conjunto.add("RAM");
        System.out.println("TreeSet: " + conjunto);

    }

    public void construirTreeSetConComparador(){
        //Comparador personalizado
        Comparator<String> comparadorOrdenInverso = new Comparator<String>(){
            @Override
            public int compare (String s1, String s2){
                return s2.compareTo(s1);
            }
        };
        TreeSet<String> conjunto = new TreeSet<>(comparadorOrdenInverso);
        conjunto.add("Monitor");
        conjunto.add("Teclado");
        conjunto.add("Raton");
        conjunto.add("HDMI");
        conjunto.add("Monitor");
        conjunto.add("Case");
        conjunto.add("RAM");
        System.out.println("TreeSet con comparador: " + conjunto);

    }

}
