package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;
import org.apache.commons.lang3.math.NumberUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/**
 * @author zm
 */
public class SleepImplement extends CommonImplement {
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        if (NumberUtils.isNumber(command.getCommandContent())) {
            try {
                Thread.sleep(Integer.parseInt(command.getCommandContent())*1000);
                return true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int method() {
        return 5;
    }
}
