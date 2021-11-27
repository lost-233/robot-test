package com.zhaoming.test.implement;

import com.zhaoming.test.bean.OperationCommand;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/**
 * @author zm
 */
public class InputImplement extends CommonImplement {
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        //获取剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        //将传入字符串封装下
        Transferable tText = new StringSelection(command.getCommandContent());
        //将字符串放入剪切板
        clip.setContents(tText, null);
        //按下Ctrl+V实现粘贴文本
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(100);
        return true;
    }

    @Override
    public int method() {
        return 4;
    }
}
