import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
       
        public static void main(String[] args) throws Exception {
                /*
                 * // criar cliente
                 * HttpClient client = HttpClient.newHttpClient();
                 * HttpRequest requestPopMovies = HttpRequest.newBuilder(
                 * URI.create("https://imdb-api.com/en/API/MostPopularMovies/" +
                 * "properties.getKey")).GET()
                 * .build();
                 * HttpResponse<String> sResponse = client.send(requestPopMovies,
                 * BodyHandlers.ofString());
                 * String jsonBody = sResponse.body();
                 * // System.out.println(jsonBody);
                 * 
                 * JsonParser parser = new JsonParser();
                 * // List<Map<String, String>> listaFilmesPopulares = parser.parse(jsonBody);
                 * 
                 * HttpRequest request250BestTV = HttpRequest.newBuilder(
                 * URI.create("https://imdb-api.com/en/API/Top250TVs/" +
                 * "properties.getKey")).GET().build()
                 * ;
                 * sResponse = client.send(request250BestTV, BodyHandlers.ofString());
                 * jsonBody = sResponse.body();
                 * // System.out.println(jsonBody);
                 * 
                 * // List<Map<String, String>> listaMelhoresSeries = parser.parse(jsonBody);
                 * 
                 * HttpRequest requestPopSeries = HttpRequest.newBuilder(
                 * URI.create("https://imdb-api.com/en/API/MostPopularTVs/" +
                 * "properties.getKey")).GET().
                 * build();
                 * sResponse = client.send(requestPopSeries, BodyHandlers.ofString());
                 * jsonBody = sResponse.body();
                 * // System.out.println(jsonBody);
                 * 
                 * List<Map<String, String>> listaPopSeries = parser.parse(jsonBody);
                 * 
                 * // System.out.println(listaFilmesPopulares.size());
                 * // System.out.println(listaMelhoresSeries.size());
                 * System.out.println(listaPopSeries.size());
                 * 
                 * for (Map<String, String> serie : listaPopSeries) {
                 * 
                 * System.out.println(serie.get("title"));
                 * System.out.println(serie.get("imDbRating"));
                 * System.out.println("");
                 * }
                 */

                // Fazer uma conexão HTTP e buscar top 250 filmes
                String URL = "https://imdb-api.com/en/API/Top250Movies/" + properties.getKey();
                // String URL = "https://alura-filmes.herokuapp.com/conteudos";
                URI uri = URI.create(URL);
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
                HttpResponse<String> stringResponse = client.send(request, BodyHandlers.ofString());
                String body = stringResponse.body();
                // System.out.println(body);

                // Transformar os dados
                // JsonParser parser = new JsonParser();
                ObjectMapper 
                List<Map<String, String>> listaDeFilmes = parser.parse(body);

                for (Map<String, String> filme : listaDeFilmes) {
                        double nota = Double.parseDouble(filme.get("imDbRating"));
                        System.out.println(filme.get("title"));
                        System.out.println(filme.get("image"));
                        System.out.print(nota + ": ");
                        for (int i = 0; i < Math.toIntExact(Math.round(nota)); i++) {
                                System.out.print("🌟");
                        }

                        System.out.print("\n");
                        System.out.println("");

                }

        }
}
