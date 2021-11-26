package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author zm
 */
public class DoubleClickImplement extends CommonImplement{
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        robot.delay(10);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        return true;
    }

    @Override
    public int method() {
        return 1;
    }
}
