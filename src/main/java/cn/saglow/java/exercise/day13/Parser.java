package cn.saglow.java.exercise.day13;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.LineComment;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.visitor.*;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;



/**
 * Description:
 * Author: HW
 * Date: 2023/7/31
 */
public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        String sourcefile = "D:/JavaParser.java";
        FileInputStream fis = new FileInputStream(sourcefile);
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> parseResult = javaParser.parse(fis);
        CompilationUnit cu = parseResult.getResult().get();
        cu.accept(new ClassVisitor(), null);
    }
}

class ClassVisitor extends VoidVisitorAdapter<Void> {
            @Override
        public void visit(ClassOrInterfaceDeclaration cd, Void arg) {
            super.visit(cd, arg);
            System.out.println("Found class/interface: " + cd.getNameAsString() + "\n"
                    + "Begin position:" + cd.getBegin().toString()+"\n"
                    + "End position:" + cd.getEnd().toString()+"\n");
        }
        public void visit ( final MethodDeclaration n, final Void arg){
            super.visit(n, arg);
            System.out.println("Found Method: " + n.getNameAsString() + "\n"
                    + "Begin position:" + n.getBegin().toString()+"\n"
                    + "End position:" + n.getEnd().toString()+"\n");
        }
        public void visit(final FieldDeclaration n, final Void arg) {
            super.visit(n, arg);
            System.out.println("Found Variables: " + n.getVariables().toString() + "\n"
                    + "Begin position:" + n.getBegin().toString() + "\n"
                    + "End position:" + n.getEnd().toString() + "\n");
        }
}

