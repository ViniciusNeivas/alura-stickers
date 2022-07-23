import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer u,a conexão HTTP e buscar os top 250 filmes

        // String url = "https://imdb-api.com/en/API/Top250Movies/k_2318nrmw";
        // ExtratorConteudoImdb extrator = new ExtratorConteudoImdb();
       
        // https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD.json";
        ExtratorConteudoNasa extrator =  new ExtratorConteudoNasa();
       
        var http = new ClientHttp();
        String json = http.buscaDados(url);

       
        
        // exibir e maninuplar os dados 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new FigurinhasInc();
        
        for (int i = 0; i <3; i++) {
            
            Conteudo conteudo = conteudos.get(i);
            
        

            InputStream inputStream = new URL (conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);
           
            System.out.println(conteudo.getTitulo());
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRating"));
            System.out.println();
        }


    }
}
