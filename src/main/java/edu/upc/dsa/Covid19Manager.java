package edu.upc.dsa;

import java.util.List;

public interface Covid19Manager {

    public int añadirBrote(String id);
    public List<Brote> listabrtote();
    public int addBrote (String id, Casos casos);
    public List<Casos> getlistaCasosBrote (Brote brote);
    public int sizeBrote();
    public int sizeCaso();

}
