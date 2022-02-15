package com.tjm.webapplication.repositories;

import com.tjm.webapplication.views.services.Services;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ServicesRepository {
    @Select("SELECT * FROM company ORDER BY id")
    List<Services> findAll();

    @Update("UPDATE company SET name=#{name}, website=#{website} WHERE id=#{id}")
    void update(Services services);

    @Insert("INSERT INTO company(name, website) VALUES(#{name}, #{website})")
    void create(Services services);
}
