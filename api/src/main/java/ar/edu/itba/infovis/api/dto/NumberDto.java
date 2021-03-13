package ar.edu.itba.infovis.api.dto;

public class NumberDto {
    private int number;

    public static NumberDto fromNumber(int number){
        final NumberDto dto = new NumberDto();
        dto.setNumber(number);
        return dto;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
