package edu.umg.dw.dominio;

public class Resultado<L, R> {
    private L error;
    private R objeto;

    private Resultado(L error, R objeto) {
        this.error = error;
        this.objeto = objeto;
    }

    public L getError() {
        return error;
    }

    public R getObjeto() {
        return objeto;
    }

    public boolean tieneFalla() {
        return error != null;
    }

    public boolean exito() {
        return !tieneFalla();
    }

    public static <T1, T2> Resultado<T1, T2> conError(T1 error) {
        return new Resultado<>(error, null);
    }

    public static <T1, T2> Resultado<T1, T2> ok(T2 objeto) {
        return new Resultado<>(null, objeto);
    }
}
