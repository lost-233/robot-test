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
     * 指令类型（1 单击  2 双击  3 右键  4 输入  5 等待  6滚轮  7鼠标移动 8键按下 9键抬起 100 执行命令行(高级用法)）
     */
    @Excel(name = "指令类型（1 单击  2 双击  3 右键  4 输入  5 等待  6滚轮  7鼠标移动 8键按下 9键抬起 10 执行命令行(高级用法)）")
    @Max(value = 10,message = "最大为10" )
    @Min(value = 1,message = "最小为1" )
    @NotNull
    private int commandType;
    /**
     * 内容（图片名称.png、输入内容、等待时长/秒）
     */
    @Excel(name = "内容（图片名称.png、输入内容、等待时长/秒(-1一直等待到下一条件满足)）")
    @NotNull
    private String commandContent;
    /**
     * 循环次数
     */
    @Excel(name = "重复次数(-1代表一直重复)")
    @Min(value = -1,message = "不能小于-1" )
    private int forCount = 1;
    /**
     * 循环以下行数
     */
    @Excel(name = "循环以下行数")
    @Min(value = 1,message = "最小为1" )
    private int forRow = 1;

    private String errorMsg;
    private Integer rowNum;
}
