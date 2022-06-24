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
public class NodoBin {
    private NodoBin padre;
    private NodoBin hijoI;
    private NodoBin hijoD;
    private int element;
    private int nivel;

    public NodoBin(int element) {
        this.padre = this.hijoI = this.hijoD = null;
        this.element = element;
        this.nivel = 1;
    }

    /**
     * @return the padre
     */
    public NodoBin getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoBin padre) {
        this.padre = padre;
    }

    /**
     * @return the hijoI
     */
    public NodoBin getHijoI() {
        return hijoI;
    }

    /**
     * @param hijoI the hijoI to set
     */
    public void setHijoI(NodoBin hijoI) {
        this.hijoI = hijoI;
    }

    /**
     * @return the hijoD
     */
    public NodoBin getHijoD() {
        return hijoD;
    }

    /**
     * @param hijoD the hijoD to set
     */
    public void setHijoD(NodoBin hijoD) {
        this.hijoD = hijoD;
    }

    /**
     * @return the element
     */
    public int getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
