package cn.saglow.java.exercise.todo;

import cn.saglow.java.exercise.day9.Mission;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.asm.TypeReference;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Description: 管理task
 * Author: HW
 * Date: 2023/7/28
 * @author HW
 */
public class TaskManager {
    public static List<Task> getAllTasks(File file) throws IOException {
        ObjectMapper objectMapper =  new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        List<Task> list = new ArrayList<>();
        JsonNode jn = objectMapper.readTree(file);
        if (!jn.isEmpty()) {
            list = objectMapper.readValue(file, new com.fasterxml.jackson.core.type.TypeReference<List<Task>>(){});
        }
        return list;
    }

    public static List<Task> getFinishedTask(List<Task> list){
        List<Task> finishedList = new ArrayList<>();
        for(Task task : list){
            if (task.getIsCompleted()) {
                finishedList.add(task);
            }
        }
        return finishedList;
    }

    public static void completeTask(Task task){
        task.setIsCompleted(true);
        task.setCompleteDate(LocalDateTime.now());
    }
    public static void showAllTasks(List<Task> taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + ". " + taskList.get(i).displayInfo());
        }
    }
    public static Task createTask(String name){
        ThreadLocal local;
//        local.set("");

        return Task.builder()
                .name(name)
                .createDate(LocalDateTime.now())
                .isCompleted(false)
                .uuid(UUID.randomUUID())
                .build();
    };

    public static void saveTaskList(List<Task> list , File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.writeValue(file, list);
    }

}
