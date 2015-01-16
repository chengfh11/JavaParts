package junk;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

public class WholeWordIndexFinder {
    private String searchString;
    public WholeWordIndexFinder(String searchString) {

        this.searchString = searchString;

    }
    public List<String> findIndexesForKeyword(String keyword) {
        String regex = "\\b"+keyword+"\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(searchString);
        List<String> wrappers = new ArrayList<String>();
        while(matcher.find() == true){
            int end = matcher.end();
            int start = matcher.start();
            System.out.println(end);
            System.out.println(start);
        }
        return wrappers;
    }

    public static void main(String[] args) {
        WholeWordIndexFinder finder = new WholeWordIndexFinder("SAT PSAT ACT");

        List<String> indexes = finder.findIndexesForKeyword("SAT");
        
    }

}
