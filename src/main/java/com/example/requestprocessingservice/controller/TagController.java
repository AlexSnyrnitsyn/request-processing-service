package com.example.requestprocessingservice.controller;

import com.example.requestprocessingservice.dto.FolderDto;
import com.example.requestprocessingservice.dto.TagDto;
import com.example.requestprocessingservice.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
@RequiredArgsConstructor
@Tag(name = "TagController", description = "Работа с тегами")
public class TagController {

    private final TagService tagsService;

    @PostMapping
    @Operation(summary = "Добавление тега")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TagDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<TagDto> addTag(@RequestBody TagDto newTag) {
        TagDto result = tagsService.createTag(newTag);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    @Operation(summary = "Получение списка тегов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TagDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<List<TagDto>> getAllTags() {
        List<TagDto> tags = tagsService.getTags();
        return ResponseEntity.ok(tags);
    }
}
