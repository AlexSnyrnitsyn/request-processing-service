package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.TagDto;

import java.util.List;

public interface TagService {

    TagDto createTag(TagDto tagsDto);

    List<TagDto> getTags();
}
