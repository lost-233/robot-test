package com.zhaoming.test;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.zhaoming.test.bean.OperationCommand;
import com.zhaoming.test.implement.ClickOnImplement;
import com.zhaoming.test.implement.CommonImplement;
import com.zhaoming.test.util.PathUtil;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static com.zhaoming.test.util.ClassUtils.getAllAssignedClass;

/**
 * @author zm
 */
public class WorkMain {

    public static HashMap<Integer, CommonImplement>  implementMap = new HashMap<>();
    public static Robot robot;
    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        try {
            List<Class<?>> allAssignedClass = getAllAssignedClass(CommonImplement.class);
            allAssignedClass.forEach(aClass -> {
                try {
                    CommonImplement o = (CommonImplement) aClass.newInstance();
                    implementMap.put(o.method(), o);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("选择模式: 1.重复一遍 2.循环; 输入数字回车");
        Scanner scanner = new Scanner(System.in);
        int model = scanner.nextInt();
        extracted(model, new File(PathUtil.getPath() + "/cmd.xlsx"));
    }

    private static void extracted(int model, File file) {
        List<OperationCommand> list = checkExcel(file);
        if (list == null) {
            // 表格异常
            System.out.println("表格异常,结束");
            return;
        }
        if (1 == model) {
            mainWork(list);
        } else if (2 == model)  {
            while (true) {
                mainWork(list);
            }
        }
    }

    private static void mainWork(List<OperationCommand> list) {
        for (int i = 0; i < list.size(); i++) {
            OperationCommand command = list.get(i);
            if (!implementMap.containsKey(command.getCommandType())) {
                throw new RuntimeException("未找到实现方式");
            }
            CommonImplement commonImplement = implementMap.get(command.getCommandType());
            commonImplement.implement(robot, command);
        }
    }

    private static List<OperationCommand> checkExcel(File file) {
        ImportParams params = new ImportParams();
        ExcelImportResult<OperationCommand> result = ExcelImportUtil.importExcelMore(file, OperationCommand.class, params);
        if (result.isVerifyFail()) {
            result.getFailList().forEach(operationCommand -> {
                System.out.println(operationCommand.getRowNum()+"行"+operationCommand.getErrorMsg());
            });
            return null;
        }
        return result.getList();
    }
}
