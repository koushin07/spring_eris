package com.inventory.eris.domain.administratives.province;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class ProvinceRepository implements ProvinceDao{

    private final JdbcTemplate jdbcTemplate;
    @Override
    public Province saveProvince(Province province) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        var sql = """
                INSERT INTO provinces(province_name) VALUES(?)
                """;
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"province_id"});
            ps.setString(1, province.getProvinceName());
            return ps;
        }, keyHolder);

        Long id = Objects.requireNonNull(keyHolder.getKey()).longValue();
        province.setProvinceId(id);
        return province;
    }

    @Override
    public Optional<Province> selectProvince(Long id) {
        var sql = """
                SELECT * FROM provinces  WHERE provinces.id = ? 
                """;
        List<Province> first = jdbcTemplate.query(sql, new ProvinceRowMapper(), id);
        return converter(first).stream().findFirst();
    }

    @Override
    public List<Province> selectAllProvince() {
        var sql = """
                SELECT 
                prov.province_id, prov.province_name, prov.created_at as province_created_at,
                muni.municipality_id, muni.municipality_name, muni.latitude, muni.longitude, muni.created_at as municipality_created_at
                 FROM provinces prov JOIN municipalities muni ON muni.province_id = prov.province_id;
                """;
        List<Province> query = jdbcTemplate.query(sql, new ProvinceRowMapper());

        return  converter(query);
    }


    public List<Province> converter(List<Province> query){
        Map<Long, Province> provinceById = new HashMap<>();

       for(Province prov: query){
           Long id  =prov.getProvinceId();
           if(provinceById.containsKey(id)){
               Province province = provinceById.get(id);
               province.getMunicipality().addAll(prov.getMunicipality());
           }else{
               provinceById.put(id, prov);
           }
       }
       return new ArrayList<>(provinceById.values());
    }
}
