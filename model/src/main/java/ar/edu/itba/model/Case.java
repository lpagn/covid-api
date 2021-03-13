package ar.edu.itba.model;

import java.time.LocalDate;

public class Case {
    private long id_evento_caso;
    private String sexo;
    private int edad;
    private String edad_anos_meses;
    private String residencia_pais_nombre;
    private String residencia_provincia_nombre;
    private String residencia_departamento_nombre;
    private String carga_provincia_nombre;
    private LocalDate fecha_inicio_sintomas;
    private LocalDate fecha_apertura;
    private int sepi_apertura;
    private LocalDate fecha_internacion;
    private String cuidado_intensivo;
    private LocalDate fecha_cui_intensivo;
    private String fallecido;
    private LocalDate fecha_fallecimiento;
    private String asistencia_respiratoria_mecanica;
    private int carga_provincia_id;
    private String origen_financiamiento;
    private String clasificacion;
    private String clasificacion_resumen;
    private int residencia_provincia_id;
    private LocalDate fecha_diagnostico;
    private int residencia_departamento_id;
    private String lastUpdate;
    private int aux;

    public Case(){}

    public Case(String str , int count , boolean flag){
        if(flag) {
            this.clasificacion_resumen = str;
        }
        else{
            this.carga_provincia_nombre = str;
        }
        this.aux = count;
    }

    public Case(LocalDate fecha , int aux , boolean flag){
        if(flag) {
            this.fecha_fallecimiento = fecha;
        }
        else{
            this.fecha_diagnostico = fecha;
        }
        this.aux = aux;
    }

    public Case(int carga_provincia_id,String carga_provincia_nombre){
        this.carga_provincia_id=carga_provincia_id;
        this.carga_provincia_nombre=carga_provincia_nombre;
    }

    public Case(long id_evento_caso, String sexo, int edad, String edad_anos_meses, String residencia_pais_nombre, String residencia_provincia_nombre, String residencia_departamento_nombre, String carga_provincia_nombre, LocalDate fecha_inicio_sintomas, LocalDate fecha_apertura, int sepi_apertura, LocalDate fecha_internacion, String cuidado_intensivo, LocalDate fecha_cui_intensivo, String fallecido, LocalDate fecha_fallecimiento, String asistencia_respiratoria_mecanica, int carga_provincia_id, String origen_financiamiento, String clasificacion, String clasificacion_resumen, int residencia_provincia_id, LocalDate fecha_diagnostico, int residencia_departamento_id, String lastUpdate) {
        this.id_evento_caso = id_evento_caso;
        this.sexo = sexo;
        this.edad = edad;
        this.edad_anos_meses = edad_anos_meses;
        this.residencia_pais_nombre = residencia_pais_nombre;
        this.residencia_provincia_nombre = residencia_provincia_nombre;
        this.residencia_departamento_nombre = residencia_departamento_nombre;
        this.carga_provincia_nombre = carga_provincia_nombre;
        this.fecha_inicio_sintomas = fecha_inicio_sintomas;
        this.fecha_apertura = fecha_apertura;
        this.sepi_apertura = sepi_apertura;
        this.fecha_internacion = fecha_internacion;
        this.cuidado_intensivo = cuidado_intensivo;
        this.fecha_cui_intensivo = fecha_cui_intensivo;
        this.fallecido = fallecido;
        this.fecha_fallecimiento = fecha_fallecimiento;
        this.asistencia_respiratoria_mecanica = asistencia_respiratoria_mecanica;
        this.carga_provincia_id = carga_provincia_id;
        this.origen_financiamiento = origen_financiamiento;
        this.clasificacion = clasificacion;
        this.clasificacion_resumen = clasificacion_resumen;
        this.residencia_provincia_id = residencia_provincia_id;
        this.fecha_diagnostico = fecha_diagnostico;
        this.residencia_departamento_id = residencia_departamento_id;
        this.lastUpdate = lastUpdate;
    }

    public long getId_evento_caso() {
        return id_evento_caso;
    }

    public String getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getEdad_anos_meses() {
        return edad_anos_meses;
    }

    public String getResidencia_pais_nombre() {
        return residencia_pais_nombre;
    }

    public String getResidencia_provincia_nombre() {
        return residencia_provincia_nombre;
    }

    public String getResidencia_departamento_nombre() {
        return residencia_departamento_nombre;
    }

    public String getCarga_provincia_nombre() {
        return carga_provincia_nombre;
    }

    public LocalDate getFecha_inicio_sintomas() {
        return fecha_inicio_sintomas;
    }

    public LocalDate getFecha_apertura() {
        return fecha_apertura;
    }

    public int getSepi_apertura() {
        return sepi_apertura;
    }

    public LocalDate getFecha_internacion() {
        return fecha_internacion;
    }

    public String getCuidado_intensivo() {
        return cuidado_intensivo;
    }

    public LocalDate getFecha_cui_intensivo() {
        return fecha_cui_intensivo;
    }

    public String getFallecido() {
        return fallecido;
    }

    public LocalDate getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public String getAsistencia_respiratoria_mecanica() {
        return asistencia_respiratoria_mecanica;
    }

    public int getCarga_provincia_id() {
        return carga_provincia_id;
    }

    public String getOrigen_financiamiento() {
        return origen_financiamiento;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getClasificacion_resumen() {
        return clasificacion_resumen;
    }

    public int getResidencia_provincia_id() {
        return residencia_provincia_id;
    }

    public LocalDate getFecha_diagnostico() {
        return fecha_diagnostico;
    }

    public int getResidencia_departamento_id() {
        return residencia_departamento_id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public int getAux() {
        return aux;
    }

    public void setId_evento_caso(long id_evento_caso) {
        this.id_evento_caso = id_evento_caso;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEdad_anos_meses(String edad_anos_meses) {
        this.edad_anos_meses = edad_anos_meses;
    }

    public void setResidencia_pais_nombre(String residencia_pais_nombre) {
        this.residencia_pais_nombre = residencia_pais_nombre;
    }

    public void setResidencia_provincia_nombre(String residencia_provincia_nombre) {
        this.residencia_provincia_nombre = residencia_provincia_nombre;
    }

    public void setResidencia_departamento_nombre(String residencia_departamento_nombre) {
        this.residencia_departamento_nombre = residencia_departamento_nombre;
    }

    public void setCarga_provincia_nombre(String carga_provincia_nombre) {
        this.carga_provincia_nombre = carga_provincia_nombre;
    }

    public void setFecha_inicio_sintomas(LocalDate fecha_inicio_sintomas) {
        this.fecha_inicio_sintomas = fecha_inicio_sintomas;
    }

    public void setFecha_apertura(LocalDate fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public void setSepi_apertura(int sepi_apertura) {
        this.sepi_apertura = sepi_apertura;
    }

    public void setFecha_internacion(LocalDate fecha_internacion) {
        this.fecha_internacion = fecha_internacion;
    }

    public void setCuidado_intensivo(String cuidado_intensivo) {
        this.cuidado_intensivo = cuidado_intensivo;
    }

    public void setFecha_cui_intensivo(LocalDate fecha_cui_intensivo) {
        this.fecha_cui_intensivo = fecha_cui_intensivo;
    }

    public void setFallecido(String fallecido) {
        this.fallecido = fallecido;
    }

    public void setFecha_fallecimiento(LocalDate fecha_fallecimiento) {
        this.fecha_fallecimiento = fecha_fallecimiento;
    }

    public void setAsistencia_respiratoria_mecanica(String asistencia_respiratoria_mecanica) {
        this.asistencia_respiratoria_mecanica = asistencia_respiratoria_mecanica;
    }

    public void setCarga_provincia_id(int carga_provincia_id) {
        this.carga_provincia_id = carga_provincia_id;
    }

    public void setOrigen_financiamiento(String origen_financiamiento) {
        this.origen_financiamiento = origen_financiamiento;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setClasificacion_resumen(String clasificacion_resumen) {
        this.clasificacion_resumen = clasificacion_resumen;
    }

    public void setResidencia_provincia_id(int residencia_provincia_id) {
        this.residencia_provincia_id = residencia_provincia_id;
    }

    public void setFecha_diagnostico(LocalDate fecha_diagnostico) {
        this.fecha_diagnostico = fecha_diagnostico;
    }

    public void setResidencia_departamento_id(int residencia_departamento_id) {
        this.residencia_departamento_id = residencia_departamento_id;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
}
