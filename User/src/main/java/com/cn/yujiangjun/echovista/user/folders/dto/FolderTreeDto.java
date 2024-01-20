package com.cn.yujiangjun.echovista.user.folders.dto;

import com.cn.yujiangjun.echovista.user.folders.model.Folder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class FolderTreeDto extends Folder {
    private List<FolderTreeDto> sons;
}
