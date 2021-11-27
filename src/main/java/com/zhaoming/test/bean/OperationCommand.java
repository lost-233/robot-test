package com.zhaoming.test.bean;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author zm
 */
@Data
public class OperationCommand implements IExcelModel, IExcelDataModel {
    /**
     * 指令类型（1 单击图  2 双击图  3 右键图  4 输入  5 等待  6滚轮  7鼠标移动到图片上 8键按下+号链接多个 9键抬起 10按下并抬起 100 执行命令行(高级用法)）
     */
    @Excel(name = "指令类型")
    @Max(value = 10,message = "最大为10" )
    @Min(value = 1,message = "最小为1" )
    @NotNull
    private int commandType;
    /**
     * （图片名称.png、输入内容、等待时长/秒(-1一直等待到下一条件满足)）
     */
    @Excel(name = "内容")
    @NotNull
    private String commandContent;
    /**
     * 循环次数 (-1代表一直重复)
     */
    @Excel(name = "重复次数")
    @Min(value = -1,message = "不能小于-1" )
    private int forCount = 1;
    /**
     * 循环以下行数
     */
    @Excel(name = "循环以下行数")
    @Min(value = 0,message = "最小为0" )
    private int forRow = 0;
    /**
     * 0, 结束 1 等待条件满足， 2跳过
     */
    @Excel(name = "如果找不到怎么办")
    @Min(value = 0,message = "最小为0" )
    @Max(value = 2,message = "最大为2" )
    private int notFind = 1;
    /**
     * 模糊查找程度 仅图片查找时生效
     * 值0， 31， 61，81
     */
    @Excel(name = "模糊查找程度")
    private int sim = 0;

    private String errorMsg;
    private Integer rowNum;
}
