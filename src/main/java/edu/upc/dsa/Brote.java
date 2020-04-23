package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class Brote {
     public String id;
     public List<Casos> casos = null;

    public Brote(String id, List<Casos> casos) {
    }
    public Brote(String id) {
        this.id = id;
        this.casos=new LinkedList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Casos> getCasos() {
        return casos;
    }

    public void setCasos(List<Casos> casos) {
        this.casos = casos;
    }

    public int sizeCasos(){
        return this.casos.size();
    }

    public int añadirunCaso(Casos caso){
        try{
            this.casos.add(caso);
        }
        catch (ExceptionInInitializerError e){
            return 400;
        }
        catch (IndexOutOfBoundsException e){
            return 507;
        }
        return 201;
    }

    @Override
    public String toString() {
        return "Brote [id="+ this.getId() +"]";
    }
}
