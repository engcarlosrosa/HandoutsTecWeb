package handout11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
	
	
    HttpClient client = HttpClients.createDefault();
    HttpGet request = new HttpGet("http://localhost:8080/handout11/testeLista.jsp?format=xml");


    HttpResponse resp = client.execute(request);

    if( resp.getStatusLine().getStatusCode() == 200) {
        InputStreamReader stream = new InputStreamReader(resp.getEntity().getContent());
        BufferedReader br = new BufferedReader(stream);
        String line;
        while ( (line = br.readLine()) != null ) {
            System.out.println(line);
        }
    }
  }
}


