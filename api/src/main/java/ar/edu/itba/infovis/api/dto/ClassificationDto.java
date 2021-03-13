package ar.edu.itba.infovis.api.dto;

import ar.edu.itba.model.Case;

import java.time.LocalDate;

public class ClassificationDto {
    private String clasificacion_resumen;
    private Integer aux;

    public String getClasificacion_resumen() {
        return clasificacion_resumen;
    }

    public void setClasificacion_resumen(String clasificaion_resumen) {
        this.clasificacion_resumen = clasificaion_resumen;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public static ClassificationDto fromCase(Case modelCase){
        final ClassificationDto dto = new ClassificationDto();
        dto.setClasificacion_resumen(modelCase.getClasificacion_resumen());
        dto.setAux(modelCase.getAux());
        return dto;
    }
}
