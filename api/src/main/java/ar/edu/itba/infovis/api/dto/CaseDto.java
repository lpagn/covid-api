package ar.edu.itba.infovis.api.dto;

import ar.edu.itba.model.Case;

import java.time.LocalDate;

public class CaseDto {

    private LocalDate fecha_fallecimiento;
    private Integer aux;

    public LocalDate getFecha_fallecimiento() {
        return fecha_fallecimiento;
    }

    public void setFecha_fallecimiento(LocalDate fecha_fallecimiento) {
        this.fecha_fallecimiento = fecha_fallecimiento;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public static CaseDto fromCase(Case modelCase){
        final CaseDto dto = new CaseDto();
        dto.setFecha_fallecimiento(modelCase.getFecha_fallecimiento());
        dto.setAux(modelCase.getAux());
        return dto;
    }

}
