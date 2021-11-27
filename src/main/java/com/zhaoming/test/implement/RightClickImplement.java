package com.zhaoming.test.implement;

import com.zhaoming.test.bean.ImageXyBean;
import com.zhaoming.test.bean.OperationCommand;
import com.zhaoming.test.util.ImageCognitionUtil;
import com.zhaoming.test.util.PathUtil;
import org.springframework.util.CollectionUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @author zm
 */
public class RightClickImplement extends CommonImplement{
    @Override
    public boolean implement(Robot robot, OperationCommand command) {
        List<ImageXyBean> list = ImageCognitionUtil.findImageForScreen(PathUtil.getPath()+"cmd/" + command.getCommandContent(), command.getSim());
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        ImageXyBean imgXy = list.get(0);
        robot.mouseMove(imgXy.x,imgXy.y);
        robot.mousePress(KeyEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON3_DOWN_MASK);
        return true;
    }

    @Override
    public int method() {
        return 3;
    }
}
