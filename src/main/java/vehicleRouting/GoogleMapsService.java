package vehicleRouting;

import lombok.Getter;
import lombok.Setter;
import okhttp3.*;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class GoogleMapsService {

    public static int getDistance(String origin, String destination) {
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://maps.googleapis.com/maps/api/distancematrix/json")
                .newBuilder()
                .addQueryParameter("destinations", destination)
                .addQueryParameter("origins", origin)
                .addQueryParameter("key", "key");

        Request request = new Request.Builder().url(urlBuilder.build().url()).get().build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                AddressInfo res = objectMapper.readValue(response.body().string(), AddressInfo.class);
                return res.getRows().get(0).getElements().get(0).getDistance().getValue();
            } else {
                throw new RuntimeException("No data fetched from google maps api");
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }

    public static long[][] getDistanceMatrix(String origin, String destination, int size) {
        long[][] distanceMatrix = new long[size][size];
        OkHttpClient okHttpClient = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://maps.googleapis.com/maps/api/distancematrix/json")
                .newBuilder()
                .addQueryParameter("destinations", destination)
                .addQueryParameter("origins", origin)
                .addQueryParameter("key", "key");

        Request request = new Request.Builder().url(urlBuilder.build().url()).get().build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ObjectMapper objectMapper = new ObjectMapper();
                AddressInfo res = objectMapper.readValue(response.body().string(), AddressInfo.class);

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        distanceMatrix[i][j] = res.getRows().get(i).getElements().get(j).getDistance().getValue();
                    }
                }
            } else {
                throw new RuntimeException("No data fetched from google maps api");
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }

        return distanceMatrix;
    }
}


@Getter
@Setter
class AddressInfo {
    private List<String> destination_addresses;
    private List<String> origin_addresses;
    private List<Row> rows;
    private String status;
}


@Getter
@Setter
class Row {
    private List<Element> elements;
}


@Getter
@Setter
class Element {
    private Distance distance;
    private Duration duration;
    private String status;
}


@Getter
@Setter
class Distance {
    private String text;
    private int value;
}


@Getter
@Setter
class Duration {
    private String text;
    private int value;
}
