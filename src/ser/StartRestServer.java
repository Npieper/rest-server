/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ser;

import java.net.URI;
import java.net.URISyntaxException;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author NiklasPieper
 */
public class StartRestServer {
    public static void main(String args[]) throws URISyntaxException {
        URI endpoint = new URI("http://localhost:55554/");
	ResourceConfig rc = new ResourceConfig(RestAPI.class);
        JdkHttpServerFactory.createHttpServer(endpoint, rc);
    }
}
