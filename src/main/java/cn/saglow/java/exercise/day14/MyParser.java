package cn.saglow.java.exercise.day14;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.GenericVisitorAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Description:
 * Author: HW
 * Date: 2023/8/2
 * @author HW
 */
public class MyParser {
    MyParser(File file) throws FileNotFoundException {
        CompilationUnit compilationUnit = getCompilationUnit(file);
        findAllClass(compilationUnit);
        getMethodDeclaration();
        getMethodCalled();
        getCalledMethodClass();
        getInputType();
        getOutputType();
        getAnnotations();
        getThrownExceptions();
        outputClassInfo();
    }

    private CompilationUnit getCompilationUnit(File file) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        JavaParser javaParser = new JavaParser();
        ParseResult<CompilationUnit> parseResult = javaParser.parse(fis);
        return parseResult.getResult().get();
    }

    private List<String> findAllClass(CompilationUnit cu) {
        cu.accept(new ClassDeclarationVisitor(), null);

        return null;
    }

    private void getMethodCalled() {

    }

    private void getAnnotations() {
    }

    private void getCalledMethodClass() {

    }

    private void getMethodDeclaration() {

    }

    private void getInputType() {

    }

    private void getOutputType() {

    }

    private void getThrownExceptions() {
    }

    private void init(){

    }



    private void outputClassInfo() {
        System.out.println("!");
    }


    public class ClassDeclarationVisitor extends GenericVisitorAdapter<String, Void> {
        @Override
        public String visit(final ClassOrInterfaceDeclaration n, final Void arg) {
            String result;
            {
                result = n.getExtendedTypes().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getImplementedTypes().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getPermittedTypes().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getTypeParameters().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getMembers().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getModifiers().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getName().accept(this, arg);
                if (result != null)
                    return result;
            }
            {
                result = n.getAnnotations().accept(this, arg);
                if (result != null)
                    return result;
            }
            if (n.getComment().isPresent()) {
                result = n.getComment().get().accept(this, arg);
                if (result != null)
                    return result;
            }
            return null;
        }
        @Override
        public String visit(MethodDeclaration n, Void arg) {
            System.out.println("function declaration: " + n.getNameAsString());
            System.out.println("InputType:" + n.getParameters());
            System.out.println("OutputType:" + n.getType());
            System.out.println("Annotations:" + n.getAnnotations());
            System.out.println("ThrownExceptions:" + n.getThrownExceptions());
            return super.visit(n, arg);
        }

    }
}

