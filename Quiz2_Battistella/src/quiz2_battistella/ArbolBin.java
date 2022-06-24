/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2_battistella;

/**
 *
 * @author fabba
 */
public class ArbolBin {
    private NodoBin root;

    public ArbolBin() {
        this.root = null;
    }
    
    public void insertarRoot(NodoBin root){
        root.setNivel(1);
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public void eliminar_nivel(NodoBin root, int num){
        if(root != null){
            if(root.getNivel() == num){
                root.setHijoD(null);
                root.setHijoI(null);
            }
            eliminar_nivel(root.getHijoI(), num);
            eliminar_nivel(root.getHijoD(), num); 
        }
    }
    
    public void insertarIzq(NodoBin padre, int valor){
        NodoBin aux = search(root, padre.getElement());
        NodoBin hijoIzq = new NodoBin(valor);
        hijoIzq.setNivel(aux.getNivel() + 1);
        aux.setHijoI(hijoIzq);
    }
    
    public void insertarDer(NodoBin padre, int valor){
        NodoBin aux = search(root, padre.getElement());
        NodoBin hijoDer = new NodoBin(valor);
        hijoDer.setNivel(aux.getNivel() + 1);
        aux.setHijoD(hijoDer);
    }
    
    public String preorden1(NodoBin root, String aiua){
        String aux1 = "";
        String aux2 = "";
        if(root != null){
            aiua += root.getElement() + ", ";
            aux1 = preorden1(root.getHijoI(), aux1);
            aiua += aux1;
            aux2 = preorden1(root.getHijoD(), aux2);
            aiua += aux2;
        }
        return aiua;
    }
    
    public NodoBin search(NodoBin nodito, int valor){
        NodoBin buscado = null;
        if(nodito != null && !isEmpty()){
            if(nodito.getElement() == valor){
                return nodito;
            }
            if(nodito.getHijoI() != null){
                buscado = search(nodito.getHijoI(), valor);
            }
            if(buscado == null){
                buscado = search(nodito.getHijoD(), valor);
            }
            return buscado;
        }else{
            return null;
        }
    }

    /**
     * @return the root
     */
    public NodoBin getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(NodoBin root) {
        this.root = root;
    }
}
