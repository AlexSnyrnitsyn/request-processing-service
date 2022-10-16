package com.example.requestprocessingservice.controller;

import com.example.requestprocessingservice.dto.FolderDto;
import com.example.requestprocessingservice.dto.RequestDto;
import com.example.requestprocessingservice.dto.TagDto;
import com.example.requestprocessingservice.service.RequestService;
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
import java.util.Set;

@RestController
@RequestMapping("/request")
@RequiredArgsConstructor
@Tag(name = "RequestController", description = "Работа с запросами")
public class RequestController {

    private final RequestService requestService;

    @PostMapping
    @Operation(summary = "Добавление запроса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    private ResponseEntity<RequestDto> addRequest(@RequestBody RequestDto newRequest) {
        RequestDto result = requestService.createRequest(newRequest);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/tag/{requestId}")
    @Operation(summary = "Добавление тега по id запроса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity Not Found",
                    content = @Content)})
    private ResponseEntity addTagsToRequest(@RequestBody TagDto tag, @PathVariable Long requestId) {
        requestService.addTagToRequest(requestId, tag.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/folder/{requestId}")
    @Operation(summary = "Добавление папки по id запроса")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Entity Not Found",
                    content = @Content)})
    private ResponseEntity addFolderToRequest(@RequestBody FolderDto folder, @PathVariable Long requestId) {
        requestService.addFolderToRequest(requestId, folder.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Operation(summary = "Получение списка запросов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<List<RequestDto>> getAllRequests() {
        List<RequestDto> requestList = requestService.getRequests();
        return ResponseEntity.ok(requestList);
    }

    @GetMapping("/byTag/{tagId}")
    @Operation(summary = "Получение запроса по id тега")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<Set<RequestDto>> getRequestsByTag(@PathVariable Long tagId) {
        Set<RequestDto> setRequest = requestService.getRequestsByTag(tagId);
        return ResponseEntity.ok(setRequest);
    }

    @GetMapping("/byFolder/{folderId}")
    @Operation(summary = "Получение запроса по id папки")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RequestDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content)})
    public ResponseEntity<List<RequestDto>> getRequestsByFolder(@PathVariable Long folderId) {
        List<RequestDto> requestList = requestService.getRequestsByFolder(folderId);
        return ResponseEntity.ok(requestList);
    }
}
