package edu.upc.dsa;
import edu.upc.dsa.Brote;
import edu.upc.dsa.Casos;
import org.apache.log4j.Logger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Covid19ManagerImpl implements Covid19Manager {
    private static Covid19Manager instance;
    private HashMap<String, Brote> hash;
    private List<Casos> listacasos;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl() {
        this.hash = new HashMap<>();
        this.listacasos = new LinkedList<>();
    }

    public static Covid19Manager getInstance() {
        if (instance == null) {
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }

    @Override
    public int añadirBrote(String id, List<Casos> casos) {
        Brote brote = new Brote(id);
        try {
            hash.put(id, new Brote(id,casos));
            logger.info("El brote se ha añadido" + brote);
            return 201;//CREADO
        }
        catch (IllegalAccessError e){
            logger.error("Formato incorrecto");
            return 400;
        }
        catch (IndexOutOfBoundsException e){
            logger.error("UserMap Error");
            return 507;
        }
    }

   /* @Override
    public int añadirBrote(Brote brote) {
        return 0;
    }*/

    @Override
    public List<Brote> listabrtote() {
        if (this.hash !=null){
            List<Brote> result = new LinkedList<>(hash.values());
            return result;// 200OK
        }
        else
            return null; // 404 Tabla llena
    }

    @Override
    public int addCasoBrote(String id, Casos casos) {
        Brote b = hash.get(id);
        if (b != null){
            int res = b.añadirunCaso(casos);
            if (res == 201){
                logger.info("Añadido!" + casos.getNombre());
                return 201;
            }
            else {
                logger.error("No se ha podido añadir");
                return 400;
            }
        }
        else{
            logger.error("Not found");
            return  404;
        }
    }

    @Override
    public List<Casos> getlistaCasosBrote(Brote brote) {
       for (Brote b : this.hash.values()){
           if(hash.get(b.getId()).equals(brote.getId()))
               return brote.getCasos();
       }
       return null;
    }

    @Override
    public int sizeBrote() {
        return hash.size();
    }

    @Override
    public Brote brote(String id) {
        return hash.get(id);
    }


    @Override
    public void recursosoff() {
        this.listacasos.clear();
        this.hash.clear();

    }

}

