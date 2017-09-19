import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
/**
 *
 * @author jarod
 * we dem bois
 */
public class Three {
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        //get the hamlet text, convert to lower case, and find the length of it
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String lowerText = text.toLowerCase();
        int textLength = lowerText.length();

        //initially, there are no occurrences of the word prince
        int princeCount = 0;
        int princeLength = 6;
        //prince is six letters, so loop through six letter chunks of the text to look for prince
        for (int i = 0; i + princeLength < textLength; i++) {
            String current = lowerText.substring(i, i + princeLength);
            if (current.equals("prince")) {
                princeCount++;
            }
        }
        //print out the number of occurrences
        System.out.println("Occurences of prince: " + princeCount);
    }
    /**
     *
     * @param url
     * @return text from the website url
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

}
