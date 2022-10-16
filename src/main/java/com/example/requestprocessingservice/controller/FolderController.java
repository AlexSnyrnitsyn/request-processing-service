package com.example.requestprocessingservice.controller;

import com.example.requestprocessingservice.dto.FolderDto;
import com.example.requestprocessingservice.service.FolderService;
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
@RequestMapping("/folder")
@RequiredArgsConstructor
@Tag(name = "FolderController", description = "Работа с папками")
public class FolderController {

    private final FolderService foldersService;

    @PostMapping
    @Operation(summary = "Добавление папки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FolderDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    private ResponseEntity<FolderDto> addFolder(@RequestBody FolderDto newFolder) {
        return ResponseEntity.ok(foldersService.createFolder(newFolder));
    }

    @GetMapping
    @Operation(summary = "Получение списка папок")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FolderDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<List<FolderDto>> getAllFolders() {
        return ResponseEntity.ok(foldersService.getFolders());
    }
}
