package Modelo.vo;

public class Requerimiento_1 {
    
    private Integer ID_Proyecto;
    private String Ciudad;
    private String Banco_Vinculado;
    private String Constructora;

    public Requerimiento_1() {
    }

    public Requerimiento_1(Integer iD_Proyecto, String ciudad) {
        ID_Proyecto = iD_Proyecto;
        Ciudad = ciudad;
    }

    public Requerimiento_1(Integer iD_Proyecto, String ciudad, String banco_Vinculado, String constructora) {
        ID_Proyecto = iD_Proyecto;
        Ciudad = ciudad;
        Banco_Vinculado = banco_Vinculado;
        Constructora = constructora;
    }

    public Integer getID_Proyecto() {
        return ID_Proyecto;
    }
    public void setID_Proyecto(Integer iD_Proyecto) {
        ID_Proyecto = iD_Proyecto;
    }
    public String getCiudad() {
        return Ciudad;
    }
    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
    public String getBanco_Vinculado() {
        return Banco_Vinculado;
    }
    public void setBanco_Vinculado(String banco_Vinculado) {
        Banco_Vinculado = banco_Vinculado;
    }
    public String getConstructora() {
        return Constructora;
    }
    public void setConstructora(String constructora) {
        Constructora = constructora;
    }
    
}
