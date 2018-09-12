

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BEDApiResponse {

    private final String USER_AGENT="Mozilla/5.0";
    public String GetResponse(String commentid) throws ClientProtocolException, IOException
    {
        StringBuffer result=new StringBuffer();
        HttpClient client=new DefaultHttpClient();
        String url="https://v2.staging-spot.im/api/rank/comment/"+commentid;
        HttpPost request=new HttpPost(url);
        request.addHeader("User-Agent",USER_AGENT);
        request.addHeader("x-spotim-spotid","sp_1FaiP6Ry");
        request.addHeader("x-spotim-token","011809087pdZaa");

        HttpResponse response=client.execute(request);
        int responseCode=response.getStatusLine().getStatusCode();
        System.out.println("Response Code: " + responseCode);
        try{
            if(responseCode==200)

            {
                System.out.println("post Response is Successfull");
                BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line="";
                while((line=reader.readLine())!=null)
                {
                    result.append(line);
                    System.out.println(result.toString());
                }
            }
            return result.toString();

        }
        catch(Exception ex)
        {
            result.append("Get Response Failed");
            return result.toString();
        }

    }
}