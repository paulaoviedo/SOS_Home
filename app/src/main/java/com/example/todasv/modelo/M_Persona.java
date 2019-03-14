package com.example.todasv.modelo;

public class M_Persona {
    public M_Persona() {

    }

    private String nombre ;

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public int getCc() {
        return cc;
    }

    public String getClave() {
        return clave;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getFecha_Expe() {
        return fecha_Expe;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setFecha_Expe(String fecha_Expe) {
        this.fecha_Expe = fecha_Expe;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getTel() {
        return tel;
    }

    private String apellido;
    private String Correo;
    private int cc;
    private String clave ;
    private String  profesion ;
    private String fecha_Expe;
    private int tel ;



    public M_Persona(String nombre , String apellido , String correo , String clave , String fecha_Expe ,int tel ,int cc){

       this.apellido=apellido;
       this.cc=cc;
       this.clave=clave;
       this.Correo=correo;
       this.nombre=nombre;
       this.fecha_Expe=fecha_Expe;
       this.tel=tel;

    }
    public M_Persona(String nombre , String apellido , String correo , String clave , String fecha_Expe ,int tel ,int cc,String profesion){

        this.apellido=apellido;
        this.cc=cc;
        this.clave=clave;
        this.Correo=correo;
        this.nombre=nombre;
        this.fecha_Expe=fecha_Expe;
        this.tel=tel;
        this.profesion=profesion;

    }


public String toJsonStringCliente (){

        return "{\"nombre\":" + "\""+getNombre()+"\","+
                " \"apellido\" :"+ " \""+ getNombre()+"\",";





}




}
