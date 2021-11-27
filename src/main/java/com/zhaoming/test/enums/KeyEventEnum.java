package com.zhaoming.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.event.KeyEvent;
import java.util.Arrays;

/**
 * @author zm
 */
@Getter
@AllArgsConstructor
public enum KeyEventEnum {
    /**
     *
     */
    _0("0", KeyEvent.VK_0, 1),
    _1("1", KeyEvent.VK_1, 1),
    _2("2", KeyEvent.VK_2, 1),
    _3("3", KeyEvent.VK_3, 1),
    _4("4", KeyEvent.VK_4, 1),
    _5("5", KeyEvent.VK_5, 1),
    _6("6", KeyEvent.VK_6, 1),
    _7("7", KeyEvent.VK_7, 1),
    _8("8", KeyEvent.VK_8, 1),
    _9("9", KeyEvent.VK_9, 1),
    _A("A", KeyEvent.VK_A, 1),
    _B("B", KeyEvent.VK_B, 1),
    _C("C", KeyEvent.VK_C, 1),
    _D("D", KeyEvent.VK_D, 1),
    _E("E", KeyEvent.VK_E, 1),
    _F("F", KeyEvent.VK_F, 1),
    _G("G", KeyEvent.VK_G, 1),
    _H("H", KeyEvent.VK_H, 1),
    _I("I", KeyEvent.VK_I, 1),
    _J("J", KeyEvent.VK_J, 1),
    _K("K", KeyEvent.VK_K, 1),
    _L("L", KeyEvent.VK_L, 1),
    _M("M", KeyEvent.VK_M, 1),
    _N("N", KeyEvent.VK_N, 1),
    _O("O", KeyEvent.VK_O, 1),
    _P("P", KeyEvent.VK_P, 1),
    _Q("Q", KeyEvent.VK_Q, 1),
    _R("R", KeyEvent.VK_R, 1),
    _S("S", KeyEvent.VK_S, 1),
    _T("T", KeyEvent.VK_T, 1),
    _U("U", KeyEvent.VK_U, 1),
    _V("V", KeyEvent.VK_V, 1),
    _W("W", KeyEvent.VK_W, 1),
    _X("X", KeyEvent.VK_X, 1),
    _Y("Y", KeyEvent.VK_Y, 1),
    _Z("Z", KeyEvent.VK_Z, 1),
    CONTROL("CTRL", KeyEvent.VK_CONTROL, 1),
    SHIFT("SHIFT", KeyEvent.VK_SHIFT, 1),
    SPACE("SPACE", KeyEvent.VK_SPACE, 1),
    SPACE1("空格", KeyEvent.VK_SPACE, 1),
    ALT("ALT", KeyEvent.VK_ALT, 1),
    ESCAPE("ESCAPE", KeyEvent.VK_ESCAPE, 1),
    ENTER("ENTER", KeyEvent.VK_ENTER, 1),
    DELETE("DELETE", KeyEvent.VK_DELETE, 1),
    WINDOWS("WIN", KeyEvent.VK_WINDOWS, 1),
    BUTTON1_DOWN_MASK("左键", KeyEvent.BUTTON1_DOWN_MASK, 2),
    BUTTON3_DOWN_MASK("右键", KeyEvent.BUTTON3_DOWN_MASK, 2),
    BUTTON2_DOWN_MASK("中键", KeyEvent.BUTTON2_DOWN_MASK, 2),
    ;
    private String input;
    private int keyEvent;
    private int type;
    public static KeyEventEnum getByInput(String s){
        KeyEventEnum eventEnum = Arrays.stream(values()).filter(keyEventEnum -> keyEventEnum.getInput().equals(s)).findAny().orElse(null);
        if (eventEnum == null) {
            return null;
        }
        return eventEnum;
    }
}
