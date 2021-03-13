package ar.edu.itba.infovis.api.dto;

import ar.edu.itba.model.Case;

import java.time.LocalDate;

public class TableDto {
    private Long id_evento_caso = null;
    private String sexo = null;
    private Integer edad = null;
    private String edad_anos_meses = null;
    private String residencia_pais_nombre = null;
    private String residencia_provincia_nombre = null;
    private String residencia_departamento_nombre = null;
    private String carga_provincia_nombre = null;
    private LocalDate fecha_inicio_sintomas = null;
    private LocalDate fecha_apertura = null;
    private Integer sepi_apertura = null;
    private LocalDate fecha_internacion = null;
    private String cuidado_intensivo = null;
    private LocalDate fecha_cui_intensivo = null;
    private String fallecido = null;
    private LocalDate fecha_fallecimiento;
    private Integer aux;

    public Long getId_evento_caso() {
        return id_evento_caso;
    }

    public void setId_evento_caso(Long id_evento_caso) {
        this.id_evento_caso = id_evento_caso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getEdad_anos_meses() {
        return edad_anos_meses;
    }

    public void setEdad_anos_meses(String edad_anos_meses) {
        this.edad_anos_meses = edad_anos_meses;
    }

    public String getResidencia_pais_nombre() {
        return residencia_pais_nombre;
    }

    public void setResidencia_pais_nombre(String residencia_pais_nombre) {
        this.residencia_pais_nombre = residencia_pais_nombre;
    }

    public String getResidencia_provincia_nombre() {
        return residencia_provincia_nombre;
    }

    public void setResidencia_provincia_nombre(String residencia_provincia_nombre) {
        this.residencia_provincia_nombre = residencia_provincia_nombre;
    }

    public String getResidencia_departamento_nombre() {
        return residencia_departamento_nombre;
    }

    public void setResidencia_departamento_nombre(String residencia_departamento_nombre) {
        this.residencia_departamento_nombre = residencia_departamento_nombre;
    }

    public String getCarga_provincia_nombre() {
        return carga_provincia_nombre;
    }

    public void setCarga_provincia_nombre(String carga_provincia_nombre) {
        this.carga_provincia_nombre = carga_provincia_nombre;
    }

    public LocalDate getFecha_inicio_sintomas() {
        return fecha_inicio_sintomas;
    }

    public void setFecha_inicio_sintomas(LocalDate fecha_inicio_sintomas) {
        this.fecha_inicio_sintomas = fecha_inicio_sintomas;
    }

    public LocalDate getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(LocalDate fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public Integer getSepi_apertura() {
        return sepi_apertura;
    }

    public void setSepi_apertura(Integer sepi_apertura) {
        this.sepi_apertura = sepi_apertura;
    }

    public LocalDate getFecha_internacion() {
        return fecha_internacion;
    }

    public void setFecha_internacion(LocalDate fecha_internacion) {
        this.fecha_internacion = fecha_internacion;
    }

    public String getCuidado_intensivo() {
        return cuidado_intensivo;
    }

    public void setCuidado_intensivo(String cuidado_intensivo) {
        this.cuidado_intensivo = cuidado_intensivo;
    }

    public LocalDate getFecha_cui_intensivo() {
        return fecha_cui_intensivo;
    }

    public void setFecha_cui_intensivo(LocalDate fecha_cui_intensivo) {
        this.fecha_cui_intensivo = fecha_cui_intensivo;
    }

    public String getFallecido() {
        return fallecido;
    }

    public void setFallecido(String fallecido) {
        this.fallecido = fallecido;
    }

    public LocalDate getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public void setFecha_fallecimiento(LocalDate fecha_fallecimiento) {
        this.fecha_fallecimiento = fecha_fallecimiento;
    }

    public Integer getAux() {
        return aux;
    }

    public void setAux(Integer aux) {
        this.aux = aux;
    }

    public static TableDto fromCase(Case modelCase){
        final TableDto dto = new TableDto();
        dto.setId_evento_caso(modelCase.getId_evento_caso());
        dto.setSexo(modelCase.getSexo());
        dto.setEdad(modelCase.getEdad());
        dto.setEdad_anos_meses(modelCase.getEdad_anos_meses());
        dto.setResidencia_pais_nombre(modelCase.getResidencia_pais_nombre());
        dto.setResidencia_provincia_nombre(modelCase.getResidencia_provincia_nombre());
        dto.setResidencia_departamento_nombre(modelCase.getResidencia_departamento_nombre());
        dto.setCarga_provincia_nombre(modelCase.getCarga_provincia_nombre());
        dto.setFecha_inicio_sintomas(modelCase.getFecha_inicio_sintomas());
        dto.setFecha_apertura(modelCase.getFecha_apertura());
        dto.setSepi_apertura(modelCase.getSepi_apertura());
        dto.setFecha_internacion(modelCase.getFecha_internacion());
        dto.setCuidado_intensivo(modelCase.getCuidado_intensivo());
        dto.setFecha_cui_intensivo(modelCase.getFecha_cui_intensivo());
        dto.setFallecido(modelCase.getFallecido());
        dto.setFecha_fallecimiento(modelCase.getFecha_fallecimiento());
        dto.setAux(modelCase.getAux());
        return dto;
    }

}
