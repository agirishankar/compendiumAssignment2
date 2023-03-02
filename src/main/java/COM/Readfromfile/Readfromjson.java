package COM.Readfromfile;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class Readfromjson {

    WebDriver driver;
    //common method  for json FileReader
    public String readFile(String attribute) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader read = new FileReader(System.getProperty("user.dir")+"/TestData/formdata.json");
        Object obj = jsonParser.parse(read);

        JSONObject jsonObject =(JSONObject) obj;
        String value =jsonObject.get(attribute).toString();
        return value;
    }
}
