package com.cn.yujiangjun.echovista.user.folders.controller;

import com.cn.yujiangjun.echovista.base.web.vo.Resp;
import com.cn.yujiangjun.echovista.user.folders.dto.FolderTreeDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MoveFolderReqDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MyFoldersReqDto;
import com.cn.yujiangjun.echovista.user.folders.model.Folder;
import com.cn.yujiangjun.echovista.user.folders.service.FolderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.cn.yujiangjun.echovista.base.web.vo.RespVO.success;

@RestController
@RequestMapping("/folder")
@AllArgsConstructor
public class FolderController {

    private final FolderServiceImpl folderService;
    @PostMapping("/getMyFolders")
    public Resp<List<FolderTreeDto>> getMyFolders(@RequestBody MyFoldersReqDto req){
        return success(folderService.getMyFolders(req));
    }

    @PostMapping("/addFolder")
    public Resp<Folder> addFolder(@RequestBody Folder folder){
        return success(folderService.addFolder(folder));
    }

    @PostMapping("/editFolder")
    public Resp<Folder> editFolder(@RequestBody Folder folder){
        return success(folderService.editFolder(folder));
    }

    @PostMapping("/delFolder")
    public Resp<Void> delFolder(@RequestBody Folder folder){
        folderService.delFolder(folder);
        return success(null);
    }

    @PostMapping("/moveFolder")
    public Resp<Folder> moveFolder(@RequestBody MoveFolderReqDto reqDto){
        return success(folderService.moveFolder(reqDto));
    }
}
