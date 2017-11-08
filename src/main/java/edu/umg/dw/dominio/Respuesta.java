package edu.umg.dw.dominio;

public class Respuesta<T> {

    private String estado;
    private String mensaje;
    private T objetoRespuesta;

    public Respuesta() {

    }

    private Respuesta(String estado, String mensaje, T objetoRespuesta) {
        this.estado = estado;
        this.mensaje = mensaje;
        this.objetoRespuesta = objetoRespuesta;
    }

    public String getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getObjetoRespuesta() {
        return objetoRespuesta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setObjetoRespuesta(T objetoRespuesta) {
        this.objetoRespuesta = objetoRespuesta;
    }

    public static <R> Respuesta<R> exito(R objetoRespueta) {
        return new Respuesta<>("OK", "", objetoRespueta);
    }

    public static <U> Respuesta<U> falla(String mensaje) {
        return new Respuesta<>("ERROR", mensaje, null);
    }
}
