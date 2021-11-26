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
    _0("0", KeyEvent.VK_0),
    _1("1", KeyEvent.VK_1),
    _2("2", KeyEvent.VK_2),
    _3("3", KeyEvent.VK_3),
    _4("4", KeyEvent.VK_4),
    _5("5", KeyEvent.VK_5),
    _6("6", KeyEvent.VK_6),
    _7("7", KeyEvent.VK_7),
    _8("8", KeyEvent.VK_8),
    _9("9", KeyEvent.VK_9),
    _A("A", KeyEvent.VK_A),
    _B("B", KeyEvent.VK_B),
    _C("C", KeyEvent.VK_C),
    _D("D", KeyEvent.VK_D),
    _E("E", KeyEvent.VK_E),
    _F("F", KeyEvent.VK_F),
    _G("G", KeyEvent.VK_G),
    _H("H", KeyEvent.VK_H),
    _I("I", KeyEvent.VK_I),
    _J("J", KeyEvent.VK_J),
    _K("K", KeyEvent.VK_K),
    _L("L", KeyEvent.VK_L),
    _M("M", KeyEvent.VK_M),
    _N("N", KeyEvent.VK_N),
    _O("O", KeyEvent.VK_O),
    _P("P", KeyEvent.VK_P),
    _Q("Q", KeyEvent.VK_Q),
    _R("R", KeyEvent.VK_R),
    _S("S", KeyEvent.VK_S),
    _T("T", KeyEvent.VK_T),
    _U("U", KeyEvent.VK_U),
    _V("V", KeyEvent.VK_V),
    _W("W", KeyEvent.VK_W),
    _X("X", KeyEvent.VK_X),
    _Y("Y", KeyEvent.VK_Y),
    _Z("Z", KeyEvent.VK_Z),
    CONTROL("CTRL", KeyEvent.VK_CONTROL),
    SHIFT("SHIFT", KeyEvent.VK_SHIFT),
    SPACE("SPACE", KeyEvent.VK_SPACE),
    ALT("ALT", KeyEvent.VK_ALT),
    ESCAPE("ESCAPE", KeyEvent.VK_ESCAPE),
    ENTER("ENTER", KeyEvent.VK_ENTER),
    DELETE("DELETE", KeyEvent.VK_DELETE),
    BUTTON1_DOWN_MASK("左键", KeyEvent.BUTTON1_DOWN_MASK),
    BUTTON3_DOWN_MASK("右键", KeyEvent.BUTTON3_DOWN_MASK),
    BUTTON2_DOWN_MASK("中键", KeyEvent.BUTTON2_DOWN_MASK),
    ;
    private String input;
    private int keyEvent;
    public static Integer getByInput(String s){
        KeyEventEnum eventEnum = Arrays.stream(values()).filter(keyEventEnum -> keyEventEnum.getInput().equals(s)).findAny().orElse(null);
        if (eventEnum == null) {
            return null;
        }
        return eventEnum.keyEvent;
    }
}
