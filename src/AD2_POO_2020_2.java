import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AD2_POO_2020_2 {

    public static void main(String[] args) throws IOException {

        if(args.length == 0) {
            throw new IOException("Arquivo não informado");
        }

        String arquivo = args[0];

        Scanner sc = new Scanner(arquivo);
        ArrayList<Integer> nodes = new ArrayList<>();
        List<String[]> edges = new ArrayList<>();
        Grafo grafo = new Grafo();

        File file = new File(sc.nextLine());

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String[] n = br.readLine().split(" ");
            for (String num : n){
                nodes.add(Integer.parseInt(num));
            }
            String line = br.readLine();

            while (line != null) {
                edges.add(line.split(" "));
                line = br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            sc.close();
        }

        int noOrigem;
        int noDestino;
        List<Integer> adj = new ArrayList<>(Collections.nCopies(nodes.size(), 0));

        int countEdge = 0;
        int countNode = 0;
        int index;
        for (int node : nodes){
            for (String[] edge : edges){
                noOrigem = Integer.parseInt(edge[0]);
                noDestino = Integer.parseInt(edge[1]);
                if (noOrigem == node){
                    index = nodes.indexOf(noDestino);
                    adj.set(index, 1);
                }
                countEdge++;
            }
            countNode++;
            countEdge = 0;
            grafo.addConexao(node, adj);
            adj = new ArrayList<>(Collections.nCopies(nodes.size(), 0));
        }
        System.out.println(grafo);
    }
}
