package Interface;

import BinaryTree.Lado;
import BinaryTree.No;
import java.util.Collection;

public interface IArvore<Chave extends Comparable<Chave>, Valor> {

    public No<Chave, Valor> inserir(Chave chave, Valor valor, No<Chave, Valor> pai, Lado lado);

    public No<Chave, Valor> inserir(Chave chave, Valor valor);

    public No<Chave, Valor> obterFilho(No<Chave, Valor> pai, Lado lado);

    public No<Chave, Valor> obterFilho(Chave chave, Lado lado);

    public No<Chave, Valor> remover(No<Chave, Valor> no);

    public No<Chave, Valor> remover(No<Chave, Valor> pai, Lado lado);

    public No<Chave, Valor> remover(Chave chave);

    public Collection<Valor> obterValores();

    public No buscarNo(Comparable chave);
}
