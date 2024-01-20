package com.cn.yujiangjun.echovista.user.folders.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.yujiangjun.echovista.base.enums.DelFlagEnum;
import com.cn.yujiangjun.echovista.user.enums.ErrorEnums;
import com.cn.yujiangjun.echovista.user.exception.FolderException;
import com.cn.yujiangjun.echovista.user.folders.dto.FolderTreeDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MoveFolderReqDto;
import com.cn.yujiangjun.echovista.user.folders.dto.MyFoldersReqDto;
import com.cn.yujiangjun.echovista.user.folders.mapper.FolderMapper;
import com.cn.yujiangjun.echovista.user.folders.model.Folder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FolderServiceImpl extends ServiceImpl<FolderMapper, Folder> {

    private final FolderMapper folderMapper;

    public List<FolderTreeDto> getMyFolders(MyFoldersReqDto req) {
        return folderMapper.getMyFolderTree(req);
    }


    public Folder addFolder(Folder folder) {
        save(folder);
        return folder;
    }

    public Folder editFolder(Folder folder) {
        updateById(folder);
        return folder;
    }

    public void delFolder(Folder folder) {
        folder.setIsDeleted(DelFlagEnum.YES.getCode());
        updateById(folder);
    }

    public Folder moveFolder(MoveFolderReqDto reqDto) {
        LambdaQueryWrapper<Folder> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Folder::getFolderCode,reqDto.getFolderCode())
                .eq(Folder::getIsDeleted,DelFlagEnum.NO.getCode());
        Folder one = getOne(wrapper);
        if (one==null){
            throw new FolderException(ErrorEnums.FolderEnum.FOLDER_NOT_EXIST);
        }
        LambdaQueryWrapper<Folder> parentWrapper = new LambdaQueryWrapper<>();
        parentWrapper.eq(Folder::getFolderPartentCode,reqDto.getDesFolderParentCode())
                .eq(Folder::getIsDeleted,DelFlagEnum.NO.getCode());
        Folder parent = getOne(parentWrapper);
        if (parent==null){
            throw new FolderException(ErrorEnums.FolderEnum.PARENT_FOLDER_NOT_EXIST);
        }
        one.setFolderPartentCode(parent.getFolderCode());
        one.setFolderParentName(parent.getFolderName());
        updateById(one);
        return one;
    }
}
