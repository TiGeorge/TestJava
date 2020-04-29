package optional;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertFalse;


class Test2 {
    public static void main(String[] args) {
        String s = '\u2002'+"Hello World!"+ '\u2002';
        System.out.println(s.trim());
        System.out.println(s.strip());
    }
}

