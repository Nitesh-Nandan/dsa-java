package javageneric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class IteratorImplementation {
    private final List<String> inputList = new ArrayList<>();
    private int nextIndex = 0;
    private final Pattern pattern;

    public IteratorImplementation(Iterator<String> inputItr, Pattern pattern) {
        while (inputItr.hasNext()) {
            String str = inputItr.next();
            inputList.add(str);
        }
        this.pattern = pattern;
    }

    public List<String> next() {
        if(nextIndex >= inputList.size()) {
            throw new NoSuchElementException("No Such Element");
        }
        int itr = nextIndex;
        int matchFreq = 0;
        List<String> ansBlock = new ArrayList<>();
        while (itr < inputList.size()) {
            if (isPatternMatch(inputList.get(itr))) {
                matchFreq++;
            }
            if (matchFreq == 1) {
                ansBlock.add(inputList.get(itr));
            }
            if (matchFreq == 2) {
                nextIndex = itr;
                break;
            }
            itr++;
        }
        if(itr == inputList.size()) {
            nextIndex = inputList.size();
        }
        return ansBlock;
    }

    public boolean hasNext() {
        if (inputList.size() == 0 || nextIndex >= inputList.size()) {
            return false;
        }
        for (int it = nextIndex; it < inputList.size(); it++) {
            if (isPatternMatch(inputList.get(it))) {
                return true;
            }
        }
        nextIndex = inputList.size();
        return false;
    }

    private boolean isPatternMatch(String str) {

        return pattern.matcher(str).matches();
    }

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("123", "start1", "data1", "data2", "start-foo", "data3", "start-bar");
        Pattern pattern = Pattern.compile("start.*");

//        test1();

        IteratorImplementation test= new IteratorImplementation(strList.iterator(), pattern);

        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.hasNext());
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.hasNext());
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.hasNext());
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.next());

    }

    static void test1() {
        Pattern pattern = Pattern.compile("start*");
        List<String> strList = Arrays.asList("123", "start1", "data1", "data2", "start-foo", "data3", "start-bar");

        String re = "start*";
        String text = "start1";

        System.out.println(Pattern.compile(re).matcher(text).matches());
    }
}
