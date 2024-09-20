package com.upc.talkia_proyect.servicesImpl;

import com.upc.talkia_proyect.entities.Content;
import com.upc.talkia_proyect.repositories.ContentRepository;
import com.upc.talkia_proyect.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content insertContent(Content content) {
        return contentRepository.save(content);
    }
}
