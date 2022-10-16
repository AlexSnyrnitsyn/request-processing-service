package com.example.requestprocessingservice.mapper;

import com.example.requestprocessingservice.dto.TagDto;
import com.example.requestprocessingservice.model.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag TagDtoToTag(TagDto tagDto);
    TagDto TagToTagDto(Tag tag);
    List<TagDto> tagsToTagsDto(List<Tag> tagList);
}
