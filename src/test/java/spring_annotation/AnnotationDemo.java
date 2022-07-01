package spring_annotation;

@MyAnnotation(getValue = "annotation on class")
public class AnnotationDemo {

    @MyAnnotation(getValue = "annotation on field")
    public String name;

    @MyAnnotation(getValue = "annotation on method")
    public void hello() {}

}
