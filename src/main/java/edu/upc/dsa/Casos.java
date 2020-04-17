package edu.upc.dsa;

public class Casos {
    public String nombre;
    public String apellido;
    public String idCaso;
    public String nacimiento;
    public String informe;
    public String riesgo;
    public String  genero;
    public String correo;
    public String telefono;
    public String direccion;
    public String clasificacion;

    public Casos () {
    }

    public Casos (String nombre, String apellido, String idCaso, String nacimiento, String informe, String riesgo, String genero, String correo, String telefono, String direccion, String clasificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCaso = idCaso;
        this.nacimiento = nacimiento;
        this.informe = informe;
        this.genero = genero;
        this.riesgo = riesgo;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.clasificacion = clasificacion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdCaso() {
        return idCaso;
    }

    public void setIdCaso(String idCaso) {
        this.idCaso = idCaso;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Video [nombre="+ nombre+ ", apellido=" + apellido + ", idCaso=" + idCaso +", fecha_nacimiento=" + nacimiento +", fecha_informe=" + informe +", nivel_riesgo=" + riesgo+ ", genero=" + genero +", correo=" + correo +", telefono=" + telefono +", direccion=" + direccion +", clasificacion=" + clasificacion +"] ";
    }
}

