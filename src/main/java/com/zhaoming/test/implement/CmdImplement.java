package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;
import com.zhaoming.test.util.ComUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/**
 * @author zm
 */
public class CmdImplement extends CommonImplement {
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        String execute = ComUtils.execute(command.getCommandContent().split(";"));
        System.out.println(execute);
        return true;
    }

    @Override
    public int method() {
        return 100;
    }
}
