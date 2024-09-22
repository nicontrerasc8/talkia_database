package com.upc.talkia_proyect.repositories;

import com.upc.talkia_proyect.dtos.queries.ShowContentByDayDTO;
import com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkia_proyect.dtos.queries.UrlDTO;
import com.upc.talkia_proyect.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {

    public Content getContentByTitle(String title);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r join r.content.levels l where l.level = :level group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO> listContentByLevels(@Param("level") String level);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            "join r.content.levels l where l.level = :level and r.content.type =:type group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO>  listContentByLevelsAndTypes(@Param("level") String level, @Param("type") String type);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            " where r.content.type =:type group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO> listContentByTypes(@Param("type") String type);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            " where r.content.theme =:theme group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO> listContentByTheme(@Param("theme") String theme);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            " where r.content.theme =:theme and r.content.type=:type group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO> listContentByThemeAndTypes(@Param("theme") String theme, @Param("type") String type);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            "join r.content.levels l where l.level = :level and r.content.theme =:theme and r.content.type=:type group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO> listContentByAllFilters(@Param("theme") String theme, @Param("type") String type, @Param("level") String level);

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO(r.content.title, avg(r.score),r.content.year) from Rating r " +
            "join r.content.levels l where l.level = :level and r.content.theme =:theme group by r.content.title, r.content.year")
    public List<ShowContentByFilterDTO>  listContentByLevelsAndTheme(@Param("level") String level, @Param("theme") String theme);
    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByDayDTO(r.content.title, avg(r.score),r.content.year) " +
            "from Rating r group by r.content.title, r.content.year order by r.content.year asc")
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationAsc();

    @Query("select new com.upc.talkia_proyect.dtos.queries.ShowContentByDayDTO(r.content.title, avg(r.score),r.content.year) " +
            "from Rating r group by r.content.title, r.content.year order by r.content.year desc")
    public List<ShowContentByDayDTO> listContentOrderByDateOfPublicationDesc();

    @Query("select new com.upc.talkia_proyect.dtos.queries.UrlDTO(c.link) from Content c where c.title=:title")
    public List<UrlDTO> listContentByLink(@Param("title") String title);


}
