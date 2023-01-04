import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String site = "http://www.google.com";
        String siteContent=htmlContent(site);
        writeToFile("1.html",siteContent);

    }
    public static String htmlContent (String webSite){
        String content = null;
        URLConnection connection = null;
        String websiteHtml = webSite;
        try {
            connection =  new URL(websiteHtml).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }
        return content;

    }
    public static void writeToFile (String fileName, String content) throws IOException {
        File myObj = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(content);
        writer.close();

    }
}