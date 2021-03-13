package ar.edu.itba.infovis.api.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SummaryRetDto {
    private long id = 0;
    //private String date;
    private LocalDate date = null;

    private int cases = 0;
    private int deaths = 0;

    private int cases_acum = 0;
    private int deaths_acum = 0;

    private double cases_by_K = 0;
    private double deaths_by_K = 0;
    private double cases_by_K_acum = 0;
    private double deaths_by_K_acum = 0;

    private double cases_by_M = 0;
    private double deaths_by_M = 0;
    private double cases_by_M_acum = 0;
    private double deaths_by_M_acum = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getCases_acum() {
        return cases_acum;
    }

    public void setCases_acum(int cases_acum) {
        this.cases_acum = cases_acum;
    }

    public int getDeaths_acum() {
        return deaths_acum;
    }

    public void setDeaths_acum(int deaths_acum) {
        this.deaths_acum = deaths_acum;
    }

    public double getCases_by_K() {
        return cases_by_K;
    }

    public void setCases_by_K(double cases_by_K) {
        this.cases_by_K = cases_by_K;
    }

    public double getDeaths_by_K() {
        return deaths_by_K;
    }

    public void setDeaths_by_K(double deaths_by_K) {
        this.deaths_by_K = deaths_by_K;
    }

    public double getCases_by_K_acum() {
        return cases_by_K_acum;
    }

    public void setCases_by_K_acum(double cases_by_K_acum) {
        this.cases_by_K_acum = cases_by_K_acum;
    }

    public double getDeaths_by_K_acum() {
        return deaths_by_K_acum;
    }

    public void setDeaths_by_K_acum(double deaths_by_K_acum) {
        this.deaths_by_K_acum = deaths_by_K_acum;
    }

    public double getCases_by_M() {
        return cases_by_M;
    }

    public void setCases_by_M(double cases_by_M) {
        this.cases_by_M = cases_by_M;
    }

    public double getDeaths_by_M() {
        return deaths_by_M;
    }

    public void setDeaths_by_M(double deaths_by_M) {
        this.deaths_by_M = deaths_by_M;
    }

    public double getCases_by_M_acum() {
        return cases_by_M_acum;
    }

    public void setCases_by_M_acum(double cases_by_M_acum) {
        this.cases_by_M_acum = cases_by_M_acum;
    }

    public double getDeaths_by_M_acum() {
        return deaths_by_M_acum;
    }

    public void setDeaths_by_M_acum(double deaths_by_M_acum) {
        this.deaths_by_M_acum = deaths_by_M_acum;
    }

    public static SummaryRetDto fromSummaryDto(SummaryDto s_dto){
        SummaryRetDto dto = new SummaryRetDto();

        dto.setDate(s_dto.getDate());

        dto.setCases(s_dto.getCases());
        dto.setCases_acum(s_dto.getCases_acum());

        dto.setCases_by_K(round(s_dto.getCases_by_K(),2));
        dto.setCases_by_M(round(s_dto.getCases_by_M(),2));
        dto.setCases_by_K_acum(round(s_dto.getCases_by_K_acum(),2));
        dto.setCases_by_M_acum(round(s_dto.getCases_by_M_acum(),2));

        dto.setDeaths(s_dto.getDeaths());
        dto.setDeaths_acum(s_dto.getDeaths_acum());

        dto.setDeaths_by_K(round(s_dto.getDeaths_by_K(),2));
        dto.setDeaths_by_M(round(s_dto.getDeaths_by_M(),2));
        dto.setDeaths_by_K_acum(round(s_dto.getDeaths_by_K_acum(),2));
        dto.setDeaths_by_M_acum(round(s_dto.getDeaths_by_M_acum(),2));

        return dto;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
