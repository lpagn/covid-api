package ar.edu.itba.infovis.api.dto;


import ar.edu.itba.model.Case;

public class ProvDto {
    private int id;
    private String provName;

    public static ProvDto fromCase(Case modelCase){
        final ProvDto dto = new ProvDto();
        dto.setId(modelCase.getCarga_provincia_id());
        dto.setProvName(modelCase.getCarga_provincia_nombre());
        return dto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
}
