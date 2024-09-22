package com.upc.talkia_proyect.services;

import com.upc.talkia_proyect.dtos.queries.ShowContentByDayDTO;
import com.upc.talkia_proyect.dtos.queries.ShowContentByFilterDTO;
import com.upc.talkia_proyect.entities.Content;

import java.util.List;

public interface ContentService {
    public Content insertContent(Content content);
    public List<Content> listAllContent();
    public List<ShowContentByFilterDTO> listContentByLevels(String level);
    public List<ShowContentByFilterDTO> listContentByLevelsAndTypes(String level, String type);
    public List<ShowContentByFilterDTO> listContentByTypes(String type);
    public Content getContentByTitle(String title);
    public List<ShowContentByFilterDTO> listContentByLevelsAndTheme(String level, String theme);
    public List<ShowContentByFilterDTO> listContentByAllFilters(String theme, String type, String level);
    public List<ShowContentByFilterDTO> listContentByThemeAndTypes(String theme, String type);
    public List<ShowContentByFilterDTO> listContentByTheme(String theme);

    public List<ShowContentByDayDTO> listContentOrderByDateOfPublication();

}
