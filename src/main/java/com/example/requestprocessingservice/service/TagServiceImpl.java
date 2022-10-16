package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.TagDto;
import com.example.requestprocessingservice.mapper.TagMapper;
import com.example.requestprocessingservice.model.Tag;
import com.example.requestprocessingservice.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagsRepository;
    private final TagMapper tagsMapper;

    @Override
    public TagDto createTag(TagDto tagDto) {
        log.info("add tag begin");
        Tag tag = tagsMapper.TagDtoToTag(tagDto);
        tagsRepository.save(tag);
        log.info("tag add success");
        return tagsMapper.TagToTagDto(tag);
    }

    @Override
    public List<TagDto> getTags() {
        log.info("get tagsList begin");
        List<Tag> tagsList = tagsRepository.findAll();
        log.info("get tagsList success with result" + tagsList.size());
        return tagsMapper.tagsToTagsDto(tagsList);
    }
}
