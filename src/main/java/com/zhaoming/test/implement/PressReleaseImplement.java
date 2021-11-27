package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;
import com.zhaoming.test.enums.KeyEventEnum;

import java.awt.*;

/**
 * @author zm
 */
public class PressReleaseImplement extends CommonImplement {
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        for (String key : command.getCommandContent().split("\\+")) {
            KeyEventEnum byInput = KeyEventEnum.getByInput(key.toUpperCase());
            if (byInput == null) {
                return false;
            }
            if (byInput.getType() == 1) {
                robot.keyPress(byInput.getKeyEvent());
                robot.keyRelease(byInput.getKeyEvent());
            }
            if (byInput.getType() == 2) {
                robot.mousePress(byInput.getKeyEvent());
                robot.mouseRelease(byInput.getKeyEvent());
            }
        }
        return true;
    }

    @Override
    public int method() {
        return 10;
    }
}
