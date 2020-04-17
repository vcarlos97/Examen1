package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class Brote {
     public String id;
     public List<Casos> casos = null;

    public Brote() {
    }
    public Brote(String id) {
        this.id = id;

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

    @Override
    public String toString() {
        return "Casos [id="+ id +", casos=" + casos + "]";
    }
}
