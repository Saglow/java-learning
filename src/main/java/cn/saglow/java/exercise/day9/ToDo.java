//package cn.saglow.java.exercise.day9;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//
//import java.awt.*;
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.util.*;
//import java.util.List;
//
///**
// * Description: todo
// * Author: HW
// * Date: 2023/7/27
// */
//public class ToDo {
//    public static void main(String[] args) throws IOException {
//        String filepath = "D:/workspace/temp/todo.json";
//        File file = new File(filepath);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        ObjectMapper objectMapper =  new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        Map<String, Mission> toDoMap = new HashMap<>();
//        JsonNode jn = objectMapper.readTree(file);
//        if (!jn.isEmpty()) {
//            toDoMap = objectMapper.readValue(file, new TypeReference<Map<String, Mission>>(){});
//        }
//        List<Mission> toDoList = new ArrayList();
//        loadToDoList(toDoList, toDoMap);
//
//        System.out.println("请输入指令");
//        MissionService ms = new MissionService();
//
//        //垃圾代码
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            if (!scanner.hasNextInt()) {
//                String command = scanner.next();
//                if (command.equals("q") || command.equals("Q")) {
//                    break;
//                } else if (command.equals("a") || command.equals("A")) {
//                    showAllMission(toDoList);
//                } else if (command.equals("n") || command.equals("N")) {
//                    newMission(toDoMap);
//                    loadToDoList(toDoList, toDoMap);
//                } else if (command.equals("l") || command.equals("L")) {
//                    loadDescriptionFile(toDoList);
//                } else if (command.equals("s") || command.equals("S")) {
//                    saveMission(toDoMap, filepath);
//                } else if (command.equals("h") || command.equals("H")) {
//                    System.out.println("""
//                                数字: 完成对应的任务
//                                a: 查看所有的任务
//                                n: 新增任务
//                                l: 加载任务文件
//                                s: 保存
//                                q: 退出
//                                h: 显示所有命令
//                                c: 清空
//                            """);
//                } else if (command.equals("c") || command.equals("C")) {
//                    toDoMap.clear();
//                    toDoList.clear();
//                    FileOutputStream os = new FileOutputStream(file);
//                    os.write("".getBytes(StandardCharsets.UTF_8));
//                    os.close();
//                } else {
//                    System.out.println("错误指令，请重新输入");
//                }
//            } else {
//                int i = scanner.nextInt();
//                if (i > 0 && i <= toDoList.size()) {
//                    toDoList.get(i - 1).setIsCompleted(true);
//                    toDoList.get(i - 1).setCompleteDate(LocalDateTime.now());
////                    toDoMap.put(toDoList.get(i - 1).name, toDoList.get(i - 1));
//                } else {
//                    System.out.println("错误指令，请重新输入");
//                }
//            }
//        }
//    }
//
//    private static class MissionService { // missionManager Missions
//        private Map<String, Mission> map;
//
//        public List<Mission> getAllMission() {
//            return null;
//        }
//
//        public List<Mission> getAllFinishedMission() {
//            return null;
//        }
//
//        public Mission createMission(String name, String fileDesp) {
//            return null;
//        }
//
//        public Mission finishedMission(String id) {
//            return null;
//        }
//    }
//    public static void showAllMission(List<Mission> listmap) {
//        for (int i = 0; i < list.size(); i++) {
//            String str = list.get(i).getIsCompleted() ? "√]":" ]";
//            if (list.get(i).isCompleted) {
//                System.out.println(i + 1 + ". [" + str + list.get(i).getName() + " 任务创建时间： " + list.get(i).getCreateDate().toString() + " 任务完成时间： " + list.get(i).getCompleteDate().toString());
//            }
//            else {
//                System.out.println(i + 1 + ". [" + str + list.get(i).getName() + " 任务创建时间： " + list.get(i).getCreateDate().toString());
//            }
//        }
//        if (list.size() == 0) {
//            System.out.println("暂无任务");
//        }
//    }
//        public static void newMission(Map<String, Mission> map) {
//        System.out.println("请输入任务名称");
//        Scanner scanner1 = new Scanner(System.in);
//        System.out.println("请选择任务文件保存路径");
//        Scanner scanner2 = new Scanner(System.in);
//        Mission mission = Mission
//                .builder()
//                .name(scanner1.next())
//                .createDate(LocalDateTime.now())
//                .isCompleted(false)
//                .descriptionFilePath(scanner2.next())
//                .build();
//        map.put(mission.name, mission);
//    }
//    public static void loadDescriptionFile(List<Mission> list) throws IOException {
//        System.out.println("请输入任务编号以选择需要查看的任务文件");
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        Desktop desktop = Desktop.getDesktop();
//        File file = new File(list.get(i-1).getDescriptionFilePath());
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        desktop.open(file);
//    }
//
//    public static void saveMission(Map<String, Mission> map, String filepath) throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.writeValue(new File(filepath), map);
//    }
//
//    public static void loadToDoList(List<Mission> toDoList, Map<String, Mission> map) {
//        if (map.isEmpty()) {
//            System.out.println("暂无任务");
//        } else {
//            for (String key : map.keySet()) {
//                toDoList.add(map.get(key));
//            }
//        }
//    }
///*    进入控制台后有
//            任务列表
//
//[  ] 吃饭
//[ ] 工作
//[ ] 学习
//            快捷键
//    数字: 完成对应的任务
//    a: 查看所有的任务
//    n: 新增任务
//    l: 加载任务文件
//    s: 保存
//    q: 退出
//    h: 显示所有命令
//    c: 清空
//    数据需要记录新增时间/完成时间
//*/
//}
