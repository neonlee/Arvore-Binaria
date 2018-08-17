package BinaryTree;

public class Main {

    public static void main(String[] args) {
        ArvoreBinaria<String, String> a = new ArvoreBinaria<>();
        No first = a.inserir("A", "a");
        No second = a.inserir("B", "b");
        No tree = a.inserir("C", "c");
        System.out.println(first.getFilhoEsquerdo());
        
        for (Object obterValore : a.obterValores()) {
            System.out.println(obterValore);
        }
    }
}
