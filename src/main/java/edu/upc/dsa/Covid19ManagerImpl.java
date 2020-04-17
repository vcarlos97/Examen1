package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Covid19ManagerImpl implements Covid19Manager{
    private static Covid19Manager instance;
    private HashMap<String, Brote> hash;
    private List<Casos> listacasos;
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl(){
        this.hash = new HashMap<>();
        this.listacasos = new LinkedList<>();
    }

    public static Covid19Manager getInstance(){
        if (instance == null){
            instance = new Covid19ManagerImpl();
        }
        return instance;
    }

    @Override
    public int añadirBrote(String id) {
        Brote b = new Brote(id);
        try {
            hash.put(id, b);
            logger.info("Brote añadido:" + b);
            return 201; //OK
        }
        catch (IndexOutOfBoundsException e){
            logger.error("Error en hash");
            return 507;//No hay storage
        }
        catch (IllegalAccessError e){
            logger.error("Incorrecto");
            return 400;//Bad Request
        }
    }

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
    public int addBrote(String id, Casos casos) {
        return 0;

    }

    @Override
    public List<Casos> getlistaCasosBrote(Brote brote) {
        if(this.hash != null){
            List<Brote> r = new LinkedList<>(hash.values());

        }
        return r;
    }

    @Override
    public int sizeCaso() {
        int ret = this.hash.size();
        logger.info("size " + ret);
        return ret;
    }

    @Override
    public int sizeBrote() {
        int ret = this.hash.size();
        logger.info("size " + ret);
        return ret;
    }
}
