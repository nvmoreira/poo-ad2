import java.util.*;

public class Grafo {

    private final HashMap<Integer, List<Integer>> grafo = new HashMap<>();
    private ArrayList<Integer> nodes;
    private ArrayList<List<Integer>> edges;
    private List<Integer> adj;
    private ArrayList<Integer> visitados;
    boolean[] visited;
    private int numNodes;

    public Grafo(){
        this.numNodes = 0;
    }

    public void setVisited(int size){
        this.visited = new boolean[size];
    }

    public void setNodes(){
        this.nodes = new ArrayList<>(grafo.keySet());
    }

    public void setEdges(){
        this.edges = new ArrayList<>(grafo.values());
    }

    public void addConexao(Integer node, List<Integer> edges){
        grafo.put(node, edges);
        this.numNodes++;
    }

    public String verificaConexo(){
        setNodes();
        setEdges();
        setVisited(this.numNodes);
        DFS2(0);
//        return checkDSF();
        int count = 0;
        for (boolean b : this.visited) {
            if (b)
                count++;
        }
        if (numNodes == count) {
            return "conexo";
        } else {
            return "desconexo";
        }
    }

    public String verificaOrientado(){
        setNodes();
        setEdges();
        int no = 0;
        int count = 0;
        for (int node : nodes) {
            this.adj = grafo.get(node);
            for (int value : this.adj){
                if (value == 1){
                    if (edges.get(no).get(count) == 1){
                        return "não-orientado";
                    }
                }
                no++;
            }
            no = 0;
            count++;
        }
        return "orientado";
    }

    public void DFS (Integer key) {
        visitados = new ArrayList<>();
        realDFS(key);
    }

    public void realDFS (Integer key) {
        if (!visitados.contains(key)) {
            System.out.println(key);
            visitados.add(key);
            for(Integer k : nodes) {
                realDFS(k);
            }
        }
    }

    public String verificaCiclo(){
        return "to do";
    }

    @Override
    public String toString() {
        return verificaOrientado() +
                " - " + verificaCiclo() +
                " - " + verificaConexo();
    }

    public String getGrafo(){
        return grafo.toString();
    }

    public void DFS2(int idx){

        this.visited[idx] = true;
        this.edges = new ArrayList<>(grafo.values());
        this.adj = edges.get(idx);

        for (int v : adj){
            if (!adj.contains(1)){
                break;
            }
            if (v == 1){
                idx = adj.indexOf(v);
                adj.set(idx, -1);
                DFS2(idx);
            }
        }
        for (List<Integer> a : edges){
            this.adj = edges.get(edges.indexOf(a));
            if (this.adj.contains(1) && this.adj.contains(-1)){
                DFS2(edges.indexOf(a));
            }
        }
    }

//    public String checkDSF() {
//        this.nodes = new ArrayList<>(grafo.keySet());
//        int numNodes = this.nodes.size();
//        int count = 0;
//        for (boolean b : this.visited) {
//            if (b)
//                count++;
//        }
//        if (numNodes == count) {
//            return "conexo";
//        } else {
//            return "desconexo";
//        }
//    }

}
