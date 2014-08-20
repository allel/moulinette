package controllers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dto.Response;
import org.kxml2.io.KXmlSerializer;
import org.kxml2.kdom.Document;
import org.kxml2.wap.WbxmlParser;
import org.xmlpull.v1.XmlPullParserException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.RootXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ben-brahim.a on 19/08/14.
 */
public class Api extends Controller {

    //operation=0&viaje=1MTL10&agencia=80009S&fecha_salida=26/03/2014&terminal=000698&version=2.3.11

    public static Result trip(String operation, String viaje,String agencia,String fetchSalida,String terminal,String version){


        URL localhost;
        Response response=null;

        //Authenticator.setDefault(new ProxyAuthenticator("ben-brahim.a","eLdorado1"));
        //System.getProperties().put("http.proxyHost", "proxy.stef-tfe.fr");
        //System.getProperties().put("http.proxyPort", "9090");


        try {

            //TODO
            // need map parameter
            // need some refactoring
            Config conf = ConfigFactory.load();
            String mtrackURL = conf.getString("mtrack.url") ;
            localhost = new URL(mtrackURL+"/ServidorComunicaciones?operation=0&viaje=1MTL10&agencia=80009S&fecha_salida=26/03/2014&terminal=000698&version=2.3.11");

            URLConnection connection = localhost.openConnection();
            InputStream in = connection.getInputStream();



            //TODO
            // Need some refactoring
            WbxmlParser parser = new WbxmlParser();
            parser.setTagTable(0, RootXml.tagTable);
            parser.setAttrStartTable( 0, RootXml.attrStartTable );
            parser.setAttrValueTable( 0, RootXml.attrValueTable );
            parser.setInput(in, "UTF-8");
            Document dom = new Document();
            dom.parse(parser);

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            KXmlSerializer ser = new KXmlSerializer();
            ser.setOutput(out, null);
            dom.write(ser);
            ser.flush();

            byte[] b = out.toByteArray();


            // Unmarshaling XML Request
            JAXBContext jc = JAXBContext.newInstance(Response.class);
            Unmarshaller u = jc.createUnmarshaller();
            ByteArrayInputStream is = new ByteArrayInputStream(b);
            response = (Response) u.unmarshal(is);


        } catch (MalformedURLException e) {
            //TODO
            // Need Error response
            e.printStackTrace();
        } catch (IOException e) {
            //TODO
            // Need Error response
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            //TODO
            // Need Error response
            e.printStackTrace();
        } catch (JAXBException e) {
            //TODO
            // Need Error response
            e.printStackTrace();
        }


        return ok(Json.toJson(response)) ;
    }

}
