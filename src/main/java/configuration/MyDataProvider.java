package configuration;

import models.Auth;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> loginData(){
        List  <Object[]> list = new ArrayList<>();
        list.add(new Object[]{Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Auth.builder().email("wick@gmail.com").password("Ww12345$").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginDataCSV() throws IOException {
        List  <Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));

        String line =reader.readLine(); ///"noa@gmail.com,Nnoa12345$"

        while (line!=null){
            String[] split = line.split(",");  //["noa@gmail.com"]  ["Nnoa12345$"]
            list.add(new Object[]{Auth.builder().email(split[0]).password(split[1]).build()});
            line = reader.readLine();
        }

        return list.iterator();
    }
}
