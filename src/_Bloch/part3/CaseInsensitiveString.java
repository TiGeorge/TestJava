package _Bloch.part3;

import java.util.ArrayList;
import java.util.List;

public class CaseInsensitiveString {

    private final String string;

    public CaseInsensitiveString(String string) {
        this.string = string;
    }

    @Override
    public boolean equals(Object obj) {

        return obj instanceof CaseInsensitiveString
                && string.equalsIgnoreCase(((CaseInsensitiveString) obj).string);

    }

    public static void main(String[] args) {

        String s = "ABC";
        CaseInsensitiveString cis = new CaseInsensitiveString("abc");
        System.out.println(cis.equals(s));
        System.out.println(s.equals(cis));

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println(list.contains(s));

    }
}
