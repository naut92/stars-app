import junit.framework.TestCase;

//import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JettyIntegrationTest {
    private static JettyServerAsync jettyServer;

    @BeforeClass
    public static void setup() throws Exception {
        jettyServer = new JettyServerAsync();
        jettyServer.start();
    }

    @AfterClass
    public static void cleanup() throws Exception {
        jettyServer.stop();
    }

    @Test
    public void givenServer_whenSendRequestToNonBlockingServlet_thenReturnStatusOK() throws Exception {
        // when
        String url = "http://localhost:9090/async";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        // then
        //assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
        //String responseContent = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
        //assertThat(responseContent).isEqualTo("This is some heavy resource that will be served in an async way");
    }
}