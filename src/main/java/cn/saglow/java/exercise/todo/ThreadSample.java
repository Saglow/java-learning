package cn.saglow.java.exercise.todo;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Description: todo
 * Author: HW
 * Date: 2023/7/27
 */
public class ThreadSample {
    public static List<Task> toDoList = null;
    public static void main(String[] args) throws IOException, InterruptedException {
        String filepath = "D:/workspace/temp/todo.json";
        File file = new File(filepath);
        toDoList = TaskManager.getAllTasks(file);// todo 不好
        Integer i = 0;
        Thread printTodo = new PrintTodo();
//        printTodo.setDaemon(true);
        printTodo.start();
        printTodo.join();
        while(true) {
            Thread.sleep(10);
            toDoList.add(TaskManager.createTask("cango thinking " + i));
            i++;
            if(i > 100) {
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + " is finished. size : " + toDoList.size());
    }

    public static class PrintTodo2 implements Runnable {
        @Override
        public void run() {

        }
    }

}
