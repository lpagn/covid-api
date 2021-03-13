package ar.edu.itba.infovis.persistance;
import ar.edu.itba.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CaseJDBCDao {
    private JdbcTemplate jdbcTemplate;
    private final static int NATIONAL_POPULATION = 45376763 ;
    private final static RowMapper<Case> ROW_MAPPER = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    rs.getLong("id_evento_caso"),
                    rs.getString("sexo"),
                    rs.getInt("edad"),
                    rs.getString("edad_años_meses"),
                    rs.getString("residencia_pais_nombre"),
                    rs.getString("residencia_provincia_nombre"),
                    rs.getString("residencia_departamento_nombre"),
                    rs.getString("carga_provincia_nombre"),
                    /*LocalDate.parse(rs.getString("fecha_inicio_sintomas"))*/null,
                    /*LocalDate.parse(rs.getString("fecha_apertura"))*/null,
                    rs.getInt("sepi_apertura"),
                    /*LocalDate.parse(rs.getString("fecha_internacion"))*/null,
                    rs.getString("cuidado_intensivo"),
                    /*LocalDate.parse(rs.getString("fecha_cui_intensivo"))*/null,
                    rs.getString("fallecido"),
                    /*LocalDate.parse(rs.getString("fecha_fallecimiento"))*/null,
                    rs.getString("asistencia_respiratoria_mecanica"),
                    rs.getInt("carga_provincia_id"),
                    rs.getString("origen_financiamiento"),
                    rs.getString("clasificacion"),
                    rs.getString("clasificacion_resumen"),
                    rs.getInt("residencia_provincia_id"),
                    LocalDate.parse(rs.getString("fecha_diagnostico")),
                    rs.getInt("residencia_departamento_id"),
                    rs.getString("ultima_actualizacion")
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_A = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    LocalDate.parse(rs.getString("fecha_fallecimiento")),
                    rs.getInt("count"),
                    true
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_A_SUM = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    LocalDate.parse(rs.getString("fecha_fallecimiento")),
                    rs.getInt("sum"),
                    true
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_B = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    rs.getInt("carga_provincia_id"),
                    rs.getString("carga_provincia_nombre")
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_C = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            String d = rs.getString("fecha_diagnostico");
            return new Case(
                    d==null?null:LocalDate.parse(d),
                    rs.getInt("count"),
                    false
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_C_SUM = new RowMapper<Case>() {

        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            String d = rs.getString("fecha_diagnostico");
            return new Case(
                    d==null?null:LocalDate.parse(d),//LocalDate.parse(rs.getString("fecha_diagnostico")),//TODO: check!
                    rs.getInt("sum"),
                    false
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_CLASSIFICATION = new RowMapper<Case>() {
        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    rs.getString("clasificacion_resumen"),
                    rs.getInt("count"),
                    true
            );
        }
    };

    private final static RowMapper<Case> ROW_MAPPER_PROV = new RowMapper<Case>() {
        @Override
        public Case mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Case(
                    rs.getString("carga_provincia_nombre"),
                    rs.getInt("count"),
                    false
            );
        }
    };

    @Autowired
    public CaseJDBCDao(final DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }
    /*Sample method*/
    public List<Case> sample(){
        final List<Case> list = jdbcTemplate.query("SELECT * FROM covid OFFSET 0 LIMIT 3", ROW_MAPPER);
        return list;
    }

    public int deaths(){
        return jdbcTemplate.queryForObject("select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI'",Integer.class);
    }

    public int deaths(String provName){
        return jdbcTemplate.queryForObject(
                "select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ?",
                Integer.class,
                provName
                );
    }

    public int cases(){
        return jdbcTemplate.queryForObject("select count(*) from covid where clasificacion_resumen='Confirmado'",Integer.class);
    }

    public int cases(String provName){
        return jdbcTemplate.queryForObject("select count(*) from covid where clasificacion_resumen='Confirmado' and carga_provincia_nombre= ?",
                Integer.class,
                provName
                );
    }

    public String lastUpdate(){
        return jdbcTemplate.queryForObject("select ultima_actualizacion from covid offset 0 limit 1",String.class);
    }

    public LocalDate lastUpdateLD(){
        String sd = jdbcTemplate.queryForObject("select ultima_actualizacion from covid offset 0 limit 1",String.class);
        return LocalDate.parse(sd);
    }

    public int casesByAge(int age){
        int ret = jdbcTemplate.queryForObject("select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and edad>= ?"
                                                    ,Integer.class
                                                    ,age);
        return ret;
    }

    public int casesByDate(String date){
        int ret = jdbcTemplate.queryForObject("select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and date ilike= ?"
                ,Integer.class
                ,date);
        return ret;
    }

//    public int casesByAgeAndDate(int age , String date){
//        //TODO: esto esta extremadamente mal y puedo haber sql injection PERO es pq tengo problemas para pasar más de un parametro en una query for objet
//        String sql = "select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and edad>=" + age + "and date ilike=" + date;
//        int ret = jdbcTemplate.queryForObject(
//                 sql
//                ,Integer.class
//                );
//        return ret;
//    }

    public List<Case> deathsByDay(int firstNdays){
        //offset 0 limit 5
        //me trae 330 - 1 , despues al llegar a 330 se rompe, porque?
        // el resultado tiene 330 rows, pero al final tiene una row que no es un resultado, osea hay 329 rows
        String sql = "select fecha_fallecimiento , count(*) from covid group by fecha_fallecimiento offset 0 limit ?";//TODO: porque si le saco el offset deja de andar ?
        final List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_A,firstNdays);
        return list;
    }

    public List<Case> deathsByAgeByDate(int age){
        String sql = "select fecha_fallecimiento , count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and edad>= ? group by fecha_fallecimiento ";
        List<Case> ret = jdbcTemplate.query(
                sql,
                ROW_MAPPER_A,
                age);
        return ret;
    }

    // SELECT count(*) AS exact_count FROM covid;

    // TODO: query que diga la cantidad de recuperados

    // select count (*) from ( select count(*) from covid group by fecha_fallecimiento ) src  ;
    // this query calculates the days since the pandemic started

    public int pandemicLength(){
        int ret = jdbcTemplate.queryForObject(
                "select count (*) from ( select count(*) from covid group by fecha_fallecimiento ) src",
                Integer.class
        );
        return ret;
    }

    public int getProvinceId(String provinceName){
        String sql = "select carga_provincia_id , carga_provincia_nombre from covid where carga_provincia_nombre= ? offset 0 limit 1";
        final List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_B,provinceName);
        return list.get(0).getCarga_provincia_id();
    }

    public List<Case> provinces(){
        // Esto es MUY ineficiente
        String sql = "select carga_provincia_id , carga_provincia_nombre from covid group by carga_provincia_nombre , carga_provincia_id offset 0 limit 24;";
        final List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_B);
        return list;
    }

    public List<Case> deathsByProvByDay(String prov){
        String sql = "select fecha_fallecimiento, count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ? group by fecha_fallecimiento";
        List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_A,prov);
        return list;
    }

    public List<Case> deathsByProvByDayAcum(String prov){
        String sql = "with data as ( select fecha_fallecimiento,count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ? group by fecha_fallecimiento) select fecha_fallecimiento, sum(count) over (order by fecha_fallecimiento asc rows between unbounded preceding and current row) from data";
        List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_A_SUM,prov);
        return list;
    }

    public List<Case> casesByProvByDay(String prov){
        String sql = "select fecha_diagnostico , count(*) from covid where clasificacion_resumen='Confirmado' and carga_provincia_nombre= ? group by fecha_diagnostico";
        List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_C,prov);
        return list;
    }

    public List<Case> casesByProvByDayAcum(String prov){
        String sql = "with data as ( select fecha_diagnostico,count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ? group by fecha_diagnostico) select fecha_diagnostico, sum(count) over (order by fecha_diagnostico asc rows between unbounded preceding and current row) from data";
        List<Case> list = jdbcTemplate.query(sql,ROW_MAPPER_C_SUM,prov);
        return list;
    }

    public int population(String provName){
        String sql = "select population from population where provname= ?";
        int ret = jdbcTemplate.queryForObject(sql,Integer.class,provName);
        return ret;
    }

    public int deathsByProvInDay(String provName , String date){
        String sql = "select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ? and fecha_fallecimiento='2020-1-1'";
        int ret = jdbcTemplate.queryForObject(sql,Integer.class,provName);
        return 0;
    }

    public int casesByProvInDay(String provName , String date){
        String sql = "select count(*) from covid where clasificacion_resumen='Confirmado' and carga_provincia_nombre= ? and fecha_diagnostico= '2020-1-1'";
        int ret = jdbcTemplate.queryForObject(sql,Integer.class,provName);
        return 0;
    }

    public int deathsAcumByProvInDay(String provName , String date){
        String sql = "select count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI' and carga_provincia_nombre= ? and fecha_fallecimiento<= '2020-1-1'";
        int ret = jdbcTemplate.queryForObject(sql,Integer.class,provName);
        return 0;
    }

    public int casesAcumByProvInDay(String provName , String date){
        String sql = "select count(*) from covid where clasificacion_resumen='Confirmado' and carga_provincia_nombre= ? and fecha_diagnostico<= '2020-1-1'";
        int ret = jdbcTemplate.queryForObject(sql,Integer.class,provName);
        return 0;
    }

    public List<Case> classification(){
        String sql = "select clasificacion_resumen , count(*) from covid group by clasificacion_resumen";
        List<Case> l = jdbcTemplate.query(sql,ROW_MAPPER_CLASSIFICATION);
        return l;
    }

    public List<Case> casesProv(){
        String sql = "select carga_provincia_nombre ,  count(*) from covid where clasificacion_resumen='Confirmado' group by carga_provincia_nombre ORDER BY count(*) ASC";
        List<Case> l = jdbcTemplate.query(sql,ROW_MAPPER_PROV);
        return l;
    }

    public List<Case> deathsProv(){
        String sql = "select carga_provincia_nombre ,  count(*) from covid where clasificacion_resumen='Confirmado' and fallecido='SI'  group by carga_provincia_nombre ORDER BY count(*) ASC";
        List<Case> l = jdbcTemplate.query(sql,ROW_MAPPER_PROV);
        return l;
    }

}
