package jdk8.lambada;

import java.util.Optional;

/**
 * Optional类测试
 *
 * @author gongwq
 * @create 2018-08-09 19:32
 */
public class OptionalTest {
    public static void main(String[] args) {

        // jdk explain
        /**
         * A container object which may or may not contain a non-null value.
         * If a value is present, {@code isPresent()} will return {@code true} and
         * {@code get()} will return the value.
         *
         * <p>Additional methods that depend on the presence or absence of a contained
         * value are provided, such as {@link #orElse(java.lang.Object) orElse()}
         * (return a default value if value not present) and
         * {@link #ifPresent(java.util.function.Consumer) ifPresent()} (execute a block
         * of code if the value is present).
         *
         * <p>This is a <a href="../lang/doc-files/ValueBased.html">value-based</a>
         * class; use of identity-sensitive operations (including reference equality
         * ({@code ==}), identity hash code, or synchronization) on instances of
         * {@code Optional} may have unpredictable results and should be avoided.
         *
         * @since 1.8
         */

        //1. inital
        Optional<String> notNullOptional = Optional.of("2");
//        Optional<String> notNullOptional2 = Optional.of(null); //不能放null，报异常
        Optional nullOptional2 = Optional.ofNullable("3");
        Optional nullOptional1 = Optional.ofNullable(null);
        Optional emptyOptional = Optional.empty();

        //2. get
        Optional<String> getOptionalTest = Optional.of("2");
        System.out.println("getOptionalTest.get() = " + getOptionalTest.get());
        Optional<String> getNullOptionalTest = Optional.ofNullable(null);
//        System.out.println("getNullOptionalTest.get() = " + getNullOptionalTest.get()); // if value is null, it will throw exception
        
        //3. ifPresent
        Optional isPresentNullTest = Optional.ofNullable(null);        
        Optional isPresentNotNullTest = Optional.ofNullable("2");
        System.out.println("isPresentNotNullTest.isPresent() = " + isPresentNotNullTest.isPresent());
        System.out.println("isPresentNullTest.isPresent() = " + isPresentNullTest.isPresent());

        //4. ifPresent(param p)
        Optional ifPresentNullTest = Optional.ofNullable(null);
        Optional ifPresentNotNullTest = Optional.ofNullable("2");
        ifPresentNullTest.ifPresent(x -> System.out.println("ifPresentNullTest is invoked"));
        ifPresentNotNullTest.ifPresent(x -> System.out.println("ifPresentNotNullTest is invoked"));

        //5. filter
        Optional filterValue2Test = Optional.ofNullable("2");
        Optional filterValue3Test = Optional.ofNullable("3");
        System.out.println("filterValue2Test.filter.isPresent = " + filterValue2Test.filter(o -> "2".equals(o)).isPresent());
        System.out.println("filterValue3Test.filter.isPresent = " + filterValue3Test.filter(o -> "2".equals(o)).isPresent());

        //6. map
        Optional<String> mapTest = Optional.of("3");
        Optional<Optional<Integer>> intOptional = mapTest.map(x -> Optional.of(Integer.parseInt(x)));
        System.out.println("intOptional.get() instanceof Optional = " + (intOptional.get() instanceof Optional));
//        //疑问，也可以？泛型只是一个语法糖
//        Optional<String> mapTest1 = Optional.of("3");
//        Optional<Integer> intOptional1 = mapTest.map(x -> Integer.parseInt(x));
//        System.out.println("intOptional1.get() instanceof Integer = " + (intOptional1.get() instanceof Integer));

        //7.flatMap latMap与map（Funtion）方法类似，区别在于flatMap中的mapper返回值必须是Optional。调用结束时，flatMap不会对结果用Optional封装。
//        Optional<String> flatMapTest = Optional.of("3");
//        Optional<Integer> flatIntOptional = flatMapTest.flatMap(x -> Integer.parseInt(x));
//        System.out.println("flatIntOptional.get() instanceof Integer = " + (flatIntOptional.get() instanceof Integer));
        //疑问 本质上没什么区别
        Optional<String> flatMapTest1 = Optional.of("3");
        Optional<Integer> flatIntOptional1 = flatMapTest1.flatMap(x -> Optional.of(Integer.parseInt(x)));
        System.out.println("flatIntOptional1.get() instanceof Optional = " + (flatIntOptional1.get() instanceof Integer));

        //8. orElse
        Optional<String> orElseTest = Optional.ofNullable(null);
        System.out.println("orElseTest.orElse(\"3\") = " + orElseTest.orElse("3"));
        //9. orElseGet
        Optional<String> orElseGetTest = Optional.ofNullable(null);
        System.out.println("orElseGetTest.orElseGet(() -> \"6\") = " + orElseGetTest.orElseGet(() -> "6"));

        //10. orElseThrow
        Optional<String> orElseThrowTest = Optional.ofNullable(null);
        orElseGetTest.orElseThrow(CustomException::new);

    }
    private static class CustomException extends RuntimeException {
        private static final long serialVersionUID = -4399699891687593264L;

        public CustomException() {
            super("自定义异常");
        }

        public CustomException(String message) {
            super(message);
        }
    }
}
