package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;

import java.awt.*;

/**
 * @author zm
 */
public abstract class CommonImplement {

    /**
     * 执行
     * @param robot robot
     * @param command OperationCommand
     * @return boolean
     */
    public abstract boolean implement(Robot robot, OperationCommand command);

    /**
     * 方法类型
     * @return int
     */
    public abstract int method();

}