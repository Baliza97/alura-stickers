import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
       
        public static void main(String[] args) throws Exception {
                
                // Fazer uma conexão HTTP e buscar top 250 filmes
                String URL = "https://imdb-api.com/en/API/Top250Movies/" + properties.getKey(); //Como a API esta caindo, a API abaixo pode ser utilizada
                // String URL = "https://alura-filmes.herokuapp.com/conteudos";
                URI uri = URI.create(URL);
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
                HttpResponse<String> stringResponse = client.send(request, BodyHandlers.ofString());
                String body = stringResponse.body();
                // System.out.println(body);

                // Transformar os dados
                JsonParser parser = new JsonParser();
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
