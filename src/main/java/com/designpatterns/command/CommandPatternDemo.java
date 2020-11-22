package com.designpatterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xu rongchao
 * @date 2020/10/19 21:27
 */
public class CommandPatternDemo {

    /**
     * 优点： 1、降低了系统耦合度。 2、新的命令可以很容易添加到系统中去。
     *
     * 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。
     * @param args
     */
    public static void main(String[] args) {

    }

    interface Command {
        Object execute();
    }

    static class Shell {
        List<Command> list = new ArrayList<>();

        void inputCommand(Command command) {
            list.add(command);
        }

        void pressEnter() {
            try {
                for (Command command : list) {
                    command.execute();
                }
            } finally {
                list.clear();
            }
        }
    }
}
