package ar.edu.itba.infovis.api.controller;

import ar.edu.itba.infovis.api.dto.*;
import ar.edu.itba.infovis.persistance.CaseJDBCDao;
import ar.edu.itba.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Path("/main")
public class MainController {

    @Autowired
    CaseJDBCDao caseJDBCDao;

    //TODO: endpoint que haga el update

    @GET
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response main() {
        // curl localhost:8080/api/main
        return Response.ok("OK\n").build();
    }

    @GET
    @Path("sample")
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response sample() {
        // curl localhost:8080/api/main/sample
        //return Response.ok("result: " + caseJDBCDao.sample() + "\n").build();
        List<Case> l = caseJDBCDao.sample();
        List<TableDto> cases = l.stream().map(
                TableDto::fromCase
        ).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<TableDto>>(cases){}).build();
    }

    @GET
    @Path("deaths")
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response deaths() {
        // curl localhost:8080/api/main/deaths
        return Response.ok(NumberDto.fromNumber(caseJDBCDao.deaths())).build();
    }

    @GET
    @Path("deaths/{provName}")
    @Produces(value = { MediaType.APPLICATION_JSON })
    public Response deaths(@PathParam("provName") final String provName) {
        // curl localhost:8080/api/main/deaths/Buenos%20Aires
        return Response.ok("deaths in " + provName + " : " + caseJDBCDao.deaths(provName) + "\n").build();
    }

    @GET
    @Path("cases")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response cases(){
        // curl localhost:8080/api/main/cases
        return Response.ok(NumberDto.fromNumber(caseJDBCDao.cases())).build();
    }

    @GET
    @Path("cases/{provName}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response cases(@PathParam("provName") final String provName){
        // curl localhost:8080/api/main/cases/Buenos%20Aires
        return Response.ok("cases in " + provName + " : " + caseJDBCDao.cases(provName) + "\n").build();
    }

    @GET
    @Path("lastUpdate")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response lastUpdate(){
        // con lastUpdate favorecemos a que la API sea autoconsumbile
        // curl localhost:8080/api/main/lastUpdate
        return Response.ok("LAST UPDATE " + caseJDBCDao.lastUpdate() + "\n").build();
    }

    @GET
    @Path("casesByAge/{age}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response casesByAge(@PathParam("age") final int age){
        // curl localhost:8080/api/main/casesByAge/{age}
        // curl localhost:8080/api/main/casesByAge/50
        // return how many cases of people older than param age , in example : how many cases there are of people older than 50 years old
        return Response.ok("The number of cases of people older than " + age + " is " + caseJDBCDao.casesByAge(age) + "\n").build();
    }

    @GET
    @Path("casesByDate/{date}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response casesByDate(@PathParam("date") final String date){
        // curl localhost:8080/api/main/casesByDate/{date}
        // curl localhost:8080/api/main/casesByDate/2021-01-26
        // return how many cases of people older than param age , in example : how many cases there are of people older than 50 years old
        return Response.ok("The number of cases on day " + date + " is " + caseJDBCDao.casesByDate(date) + "\n").build();
    }

//    @GET
//    @Path("casesByAgeAndDate/{date}")
//    @Produces(value = {MediaType.APPLICATION_JSON})
//    public Response casesByDateAndAge(
//            // curl localhost:8080/api/main/casesByAgeAndDate/{date}?age={age}
//            // curl localhost:8080/api/main/casesByAgeAndDate/2021-01-26?age=50
//            @PathParam("date") final String date,
//            @QueryParam("age") final int age
//    ){
//        int ret = caseJDBCDao.casesByAgeAndDate(age,date);
//        return Response.ok("The number of people over " + age + " years on day " + date + " is " + ret).build();
//    }

    @GET
    @Path("deathsByDay/{firstNdays}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response deathsByDay(@PathParam("firstNdays") final int firstNdays){
        // curl localhost:8080/api/main/deathsByDay/{firstNdays}
        //curl localhost:8080/api/main/deathsByDay/5
        //TODO: make a DTO
        List<Case> l = caseJDBCDao.deathsByDay(firstNdays);
        List<CaseDto> cases = l.stream().map(
                CaseDto::fromCase
        ).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<CaseDto>>(cases){}).build();
    }

    @GET
    @Path("deathsByDay")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response deathsByDay(){
        // curl localhost:8080/api/main/deathsByDay/
        List<Case> l = caseJDBCDao.deathsByDay(caseJDBCDao.pandemicLength() - 1);
        List<CaseDto> cases = l.stream().map(
                CaseDto::fromCase
        ).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<CaseDto>>(cases){}).build();
    }

    @GET
    @Path("deathsByAgeByDay/{age}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response deathsByAgeByDate(@PathParam("age") final int age){
        // curl localhost:8080/api/main/deathsByAgeByDay/50
        List<Case> l = caseJDBCDao.deathsByAgeByDate(age);
        List<CaseDto> cases = l.stream().map(
                CaseDto::fromCase
        ).collect(Collectors.toList());
        return Response.ok(new GenericEntity<List<CaseDto>>(cases){}).build();
    }

    @GET
    @Path("pandemicLength")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response pandemicLength(){
        //curl localhost:8080/api/main/pandemicLength
        return Response.ok(NumberDto.fromNumber(caseJDBCDao.pandemicLength())).build();
    }

    @GET
    @Path("getProvinceId/{provName}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response getProvinceId(@PathParam("provName")final String provName){
        // curl localhost:8080/api/main/getProvinceId/{provName}
        // curl localhost:8080/api/main/getProvinceId/CABA
        // curl localhost:8080/api/main/getProvinceId/San%20Luis
        // curl localhost:8080/api/main/getProvinceId/Tucum%C3%A1n
        // curl localhost:8080/api/main/getProvinceId/Neuqu%C3%A9n
        // curl localhost:8080/api/main/getProvinceId/C%C3%B3rdoba
        // curl localhost:8080/api/main/getProvinceId/R%C3%ADo%20Negro
        // visit https://www.urlencoder.org/
        int id = caseJDBCDao.getProvinceId(provName);
        return Response.ok("The id for province " + provName + " is " + id + "\n").build();
    }

    @GET
    @Path("provinces")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response provinces(){
        List<Case> provs = caseJDBCDao.provinces();
        List<ProvDto> prov = provs.stream().map(
                ProvDto::fromCase
        ).collect(Collectors.toList());
        Response ret = Response.ok(new GenericEntity<List<ProvDto>>(prov){}).build();
        return ret;
    }

    @GET
    @Path("deathsByProvByDay/{provName}")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response deathsByProvByDay(@PathParam("provName")final String provName){
        // curl localhost:8080/api/main/deathsByProvByDay/{provName}
        List<Case> l = caseJDBCDao.deathsByProvByDay(provName);
        List<CaseDto> cases = l.stream().map(
                CaseDto::fromCase
        ).collect(Collectors.toList());
        Response ret = Response.ok(new GenericEntity<List<CaseDto>>(cases){}).build();
        return ret;
    }

    @GET
    @Path("province/{provName}/summary")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response summary(@PathParam("provName")final String provName){
        /*
        curl localhost:8080/api/main/province/San%20Luis/summary
        curl localhost:8080/api/main/province/Tucum%C3%A1n/summary
        curl localhost:8080/api/main/province/Neuqu%C3%A9n/summary
        curl localhost:8080/api/main/province/C%C3%B3rdoba/summary
        curl localhost:8080/api/main/province/R%C3%ADo%20Negro/summary
        */
        /*
        Map provName to population size
        */
        /*

        cases
        deaths
        cases_acum
        deaths_acum

        cases_by_K
        deaths_by_K
        cases_by_K_acum
        deaths_by_K_acum

        cases_by_M
        deaths_by_M
        cases_by_M_acum
        deaths_by_M_acum

        */

        int aux = 0;
        List<Case> l1 = caseJDBCDao.deathsByProvByDay(provName);
        List<Case> l3 = caseJDBCDao.casesByProvByDay(provName);

        double population = caseJDBCDao.population(provName);

        SortedSet<LocalDate> s = new TreeSet<>();
        SortedSet<SummaryDto> sdto = new TreeSet<>();
        SortedSet<SummaryDto> ret = new TreeSet<>();

        int acum_deaths = 0;
        for(Case c : l1){
            acum_deaths+=c.getAux();
            s.add(c.getFecha_fallecimiento());

            SummaryDto x = new SummaryDto(c.getFecha_fallecimiento());
            x.setDeaths(c.getAux());
            x.setDeaths_acum(acum_deaths);
            x.setDeaths_by_K((c.getAux()/population)*1000);
            x.setDeaths_by_M((c.getAux()/population)*1000000);
            x.setDeaths_by_K_acum((acum_deaths/population)*1000);
            x.setDeaths_by_M_acum((acum_deaths/population)*1000000);
            sdto.add(x);//TODO: agregar los demás datos al DTO
        }

        int acum_cases = 0;
        for(Case c : l3){
            if(c!=null && c.getFecha_diagnostico() != null) {
                acum_cases+=c.getAux();
                s.add(c.getFecha_diagnostico());

                SummaryDto x = new SummaryDto(c.getFecha_diagnostico());
                if(sdto.contains(x)) {
                    for (SummaryDto elem : sdto) {
                        if (elem.getDate().compareTo(c.getFecha_diagnostico()) == 0) {
                            SummaryDto y = new SummaryDto(c.getFecha_diagnostico());
                            y.setDeaths(elem.getDeaths());
                            y.setDeaths_acum(elem.getDeaths_acum());
                            y.setDeaths_by_K(elem.getDeaths_by_K());
                            y.setDeaths_by_M(elem.getDeaths_by_M());
                            y.setDeaths_by_K_acum(elem.getDeaths_by_K_acum());
                            y.setDeaths_by_M_acum(elem.getCases_by_M_acum());
                            y.setCases(c.getAux());
                            y.setCases_acum(acum_cases);
                            y.setCases_by_K((c.getAux() / population) * 1000);
                            y.setCases_by_M((c.getAux() / population) * 1000000);
                            y.setCases_by_K_acum((acum_cases / population) * 1000);
                            y.setCases_by_M_acum((acum_cases / population) * 1000000);
                            ret.add(y);// agrego el x editado (y) , es importante destacar que estamos haciendo un merge, en una estructura paralela ya que sino tira error.Este error sale de querer editar una estructura que se esta iterando.
                        }
                    }
                }
                else{
                    //x.setDeaths_acum(elem.getDeaths_acum());
                    x.setCases(c.getAux());
                    x.setCases_acum(acum_cases);
                    x.setCases_by_K((c.getAux()/population)*1000);
                    x.setCases_by_M((c.getAux()/population)*1000000);
                    x.setCases_by_K_acum((acum_cases/population)*1000);
                    x.setCases_by_M_acum((acum_cases/population)*1000000);
                    ret.add(x);//agrego el x sin editar//TODO: agregar los demás datos al DTO
                    }
                }
            }

//        Response response = Response.ok(new GenericEntity<SortedSet<SummaryDto>>(ret){}).build();
//        return response;

        List<SummaryRetDto> l_dto = ret.stream().map(
                SummaryRetDto::fromSummaryDto
        ).collect(Collectors.toList());
        Response response = Response.ok(new GenericEntity<List<SummaryRetDto>>(l_dto){}).build();
        return response;

    }

    @GET
    @Path("classify")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response classify(){
        List<Case> classes = caseJDBCDao.classification();
        List<ClassificationDto> cases = classes.stream().map(
                ClassificationDto::fromCase
        ).collect(Collectors.toList());
        Response ret = Response.ok(new GenericEntity<List<ClassificationDto>>(cases){}).build();
        return ret;
    }

    @GET
    @Path("casesProv")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response casesProv(){
        List<Case> classes = caseJDBCDao.casesProv();
        List<TableDto> cases = classes.stream().map(
                TableDto::fromCase
        ).collect(Collectors.toList());
        Response ret = Response.ok(new GenericEntity<List<TableDto>>(cases){}).build();
        return ret;
    }

    @GET
    @Path("deathsProv")
    @Produces(value = {MediaType.APPLICATION_JSON})
    public Response deathsProv(){
        List<Case> classes = caseJDBCDao.deathsProv();
        List<TableDto> cases = classes.stream().map(
                TableDto::fromCase
        ).collect(Collectors.toList());
        Response ret = Response.ok(new GenericEntity<List<TableDto>>(cases){}).build();
        return ret;
    }

}
