//package cn.saglow.java.exercise.day11;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
////import org.w3c.dom.Node1;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Description: treeeeeeeeee
// * Author: HW
// * Date: 2023/7/29
// * @author HW
// */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Tree<T> {
//
//    public Node1 rootNode;
//    public void add(Node1 node){
//        node.parentNode.getChildrenNodes().add(node);
//    }
//    public void delete(Node1 node){
//        node.parentNode.getChildrenNodes().remove(node);
//    }
//    public Integer getDepth(Node1 node){
//        if (node == rootNode) {
//            return 0;
//        } else {
//            return getDepth(node.parentNode) + 1;
//        }
//    }
//    public ArrayList<Node1> toList(){
//        ArrayList<Node1> list = new ArrayList<>();
////        traverse(rootNode , list);
//        return list;
//    }
////    public void traverse (Node1 rootNode , ArrayList<Node1> list) {
////        list.add(rootNode);
////        if(!rootNode.childrenNodes.isEmpty()){
////            for (Node1 node : rootNode.childrenNodes) {
////                traverse(node, list);
////            }
////        }
////    }
//}

