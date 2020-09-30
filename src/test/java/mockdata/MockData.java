package mockdata;

import beans.Response;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

public class MockData {

  public static ImmutableList<Response> getResponses() throws IOException {
    InputStream inputStream = Resources.getResource("testingtime.json").openStream();
    String json = IOUtils.toString(inputStream);
    Type listType = new TypeToken<ArrayList<Response>>() {
    }.getType();
    List<Response> responses = new Gson().fromJson(json, listType);
    return ImmutableList.copyOf(responses);
  }

}
