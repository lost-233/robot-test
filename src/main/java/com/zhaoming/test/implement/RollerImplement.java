package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;
import org.apache.commons.lang3.math.NumberUtils;

import java.awt.*;

/**
 * @author zm
 */
public class RollerImplement extends CommonImplement {
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        if (NumberUtils.isNumber(command.getCommandContent())) {
            robot.mouseWheel(Integer.parseInt(command.getCommandContent()));
            return true;
        }
        return false;
    }

    @Override
    public int method() {
        return 6;
    }
}
