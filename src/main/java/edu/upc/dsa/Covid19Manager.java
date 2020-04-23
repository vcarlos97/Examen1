package edu.upc.dsa;
import java.util.List;

public interface Covid19Manager {

    public int añadirBrote(String id, List<Casos> casos);
    //public int añadirBrote(Brote brote);
    List<Brote> listabrtote();
    public int addCasoBrote (String id, Casos casos);
    List<Casos> getlistaCasosBrote (Brote brote);
    public int sizeBrote();
    Brote brote (String id);
    public void recursosoff();


}
