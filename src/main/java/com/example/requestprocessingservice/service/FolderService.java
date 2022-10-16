package com.example.requestprocessingservice.service;

import com.example.requestprocessingservice.dto.FolderDto;

import java.util.List;

public interface FolderService {

    FolderDto createFolder(FolderDto folderDto);

    List<FolderDto> getFolders();
}
