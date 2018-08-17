package BinaryTree;

import java.util.ArrayList;
import java.util.Collection;

public class ArvoreBinaria<Chave extends Comparable<Chave>, Valor> implements Interface.IArvore {

    private No<Chave, Valor> raiz;

    @Override
    public No inserir(Comparable chave, Object valor, No pai, Lado lado) {
        No<Chave, Valor> novoNo = new No(chave, valor);

        if (this.raiz == null) {
            this.raiz = novoNo;
        } else {
            novoNo.setPai(pai);
            if (lado == Lado.esquerdo) {
                if (pai.getFilhoEsquerdo() == null) {
                    pai.setFilhoEsquerdo(novoNo);
                }
            }
            if (lado == Lado.direito) {
                if (pai.getFilhoDireito() == null) {
                    pai.setFilhoDireito(novoNo);
                }
            }
        }
        return novoNo;
    }

    @Override
    public No inserir(Comparable chave, Object valor) {
        No<Chave, Valor> novoNo = new No(chave, valor);
        if (raiz == null) {
            raiz = novoNo;
        } else {
            for (Object no : this.obterValores()) {
                if (((No<Chave, Valor>) no).getFilhoEsquerdo() == null) {
                    novoNo.setPai((No<Chave, Valor>) no);
                    ((No<Chave, Valor>) no).setFilhoEsquerdo(novoNo);
                    break;
                }else
                if (((No<Chave, Valor>) no).getFilhoDireito() == null) {
                    novoNo.setPai((No<Chave, Valor>) no);
                    ((No<Chave, Valor>) no).setFilhoDireito(novoNo);
                    break;
                }
            }
        }
        return novoNo;
    }

    @Override
    public No obterFilho(No pai, Lado lado) {
        if (lado == Lado.esquerdo) {
            return pai.getFilhoEsquerdo();
        }
        if (lado == Lado.direito) {
            return pai.getFilhoDireito();
        }
        return null;
    }

    @Override
    public No obterFilho(Comparable chave, Lado lado) {
        No<Chave, Valor> noPai = null;

        for (Object no : this.obterValores()) {
            if (((No<Chave, Valor>) no).getChave().equals(chave)) {
                noPai = (No<Chave, Valor>) no;
                break;
            }
        }

        if (noPai != null) {

            if (lado == Lado.esquerdo) {
                return noPai.getFilhoEsquerdo();
            } else {
                return noPai.getFilhoDireito();
            }

        }

        return null;

    }

    @Override
    public No buscarNo(Comparable chave) {
        for (Object no : this.obterValores()) {
            if (((No<Chave, Valor>) no).getChave().equals(chave)) {
                return (No) no;
            }
        }

        return null;
    }

    @Override
    public No remover(No no) {
        if (no.getFilhoDireito() == null && no.getFilhoEsquerdo() == null) {
            if (this.ladoDoFilho(no) == Lado.esquerdo) {
                no.getPai().setFilhoEsquerdo(null);
                no.setPai(null);

                return no;
            } else {
                no.getPai().setFilhoDireito(null);
                no.setPai(null);

                return no;
            }
        }

        if (no.getFilhoEsquerdo() == null) {

            no.getFilhoDireito().setPai(no.getPai());
            if (this.ladoDoFilho(no) == Lado.esquerdo) {
                no.getPai().setFilhoEsquerdo(no.getFilhoDireito());
            } else {
                no.getPai().setFilhoDireito(no.getFilhoDireito());
            }

            return no;

        } else if (no.getFilhoDireito() == null) {

            no.getFilhoEsquerdo().setPai(no.getPai());
            if (this.ladoDoFilho(no) == Lado.esquerdo) {
                no.getPai().setFilhoEsquerdo(no.getFilhoEsquerdo());
            } else {
                no.getPai().setFilhoDireito(no.getFilhoEsquerdo());
            }

            return no;

        } else {
            return null;
        }
    }

    @Override
    public No remover(No pai, Lado lado) {
        if (lado == Lado.esquerdo) {
            return this.remover(pai.getFilhoEsquerdo());
        } else {
            return this.remover(pai.getFilhoDireito());
        }
    }

    @Override
    public No remover(Comparable chave) {
        for (Object no : this.obterValores()) {
            if (((No<Chave, Valor>) no).getChave().equals(chave)) {
                return this.remover(((No<Chave, Valor>) no));
            }
        }

        return null;
    }

    @Override
    public Collection obterValores() {
        ArrayList<No<Chave, Valor>> lista = new ArrayList<>();
        this.listarPercurso(this.raiz, lista);

        return lista;
    }

    private void listarPercurso(No<Chave, Valor> no, ArrayList<No<Chave, Valor>> collection) {
        if (no == null) {
            return;
        }

        collection.add(no);

        if (no.getFilhoEsquerdo() != null) {
            listarPercurso(no.getFilhoEsquerdo(), collection);
        }

        if (no.getFilhoDireito() != null) {
            listarPercurso(no.getFilhoDireito(), collection);
        }

    }

    private Lado ladoDoFilho(No<Chave, Valor> noFilho) {
        if (noFilho.getPai().getFilhoEsquerdo() != null
                && noFilho.getPai().getFilhoEsquerdo().equals(noFilho)) {
            return Lado.esquerdo;
        } else {
            return Lado.direito;
        }
    }

    public No<Chave, Valor> getRaiz() {
        return raiz;
    }

}
