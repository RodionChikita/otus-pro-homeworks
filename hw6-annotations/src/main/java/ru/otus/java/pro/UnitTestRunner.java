package ru.otus.java.pro;

import ru.otus.java.pro.test.AnnotationDemoTest;
import java.lang.reflect.Method;

public class UnitTestRunner {
    public static void main(String[] args) {
        runAllTest(AnnotationDemoTest.class);
    }


    public static void runAllTest(Class<?> cls) {


        for (Method testMethod : cls.getDeclaredMethods()) {
            Before before1 = testMethod.getAnnotation(Before.class);
            Test test1 = testMethod.getAnnotation(Test.class);
            After after1 = testMethod.getAnnotation(After.class);

            if (test1 != null) {
                if ((before1 != null) || (after1 != null)) {
                    throw new RuntimeException("Extra annotation");
                }

                try {
                    for (Method beforeMethod : cls.getDeclaredMethods()) {
                        Before before2 = beforeMethod.getAnnotation(Before.class);
                        Test test2 = beforeMethod.getAnnotation(Test.class);
                        After after2 = beforeMethod.getAnnotation(After.class);

                        if (before2 != null) {
                            if ((test2 != null) || (after2 != null)) {
                                throw new RuntimeException();
                            }
                            try {
                                beforeMethod.invoke(cls.getDeclaredConstructor().newInstance());
                            } catch (Throwable ex) {
                                System.out.println(ex.getCause());
                            }
                        }
                    }
                    testMethod.invoke(cls.getDeclaredConstructor().newInstance());
                } catch (Throwable ex) {
                    System.out.println(ex.getCause());
                }
                for (Method afterMethod : cls.getDeclaredMethods()) {
                    Before before3 = afterMethod.getAnnotation(Before.class);
                    Test test3 = afterMethod.getAnnotation(Test.class);
                    After after3 = afterMethod.getAnnotation(After.class);
                    if (after3 != null) {
                        if ((before3 != null) || (test3 != null)) {
                            throw new RuntimeException();
                        }
                        try {
                            afterMethod.invoke(cls.getDeclaredConstructor().newInstance());
                        } catch (Throwable ex) {
                            System.out.println(ex.getCause());
                        }
                    }
                }
            }
        }
    }
}