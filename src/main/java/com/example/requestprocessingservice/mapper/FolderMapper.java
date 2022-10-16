package com.example.requestprocessingservice.mapper;

import com.example.requestprocessingservice.dto.FolderDto;
import com.example.requestprocessingservice.model.Folder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FolderMapper {
    Folder folderDtoToFolder(FolderDto folderDto);
    FolderDto folderToFolderDto(Folder folder);
    List<FolderDto> folderListToFolderListDto(List<Folder> foldersList);
}
