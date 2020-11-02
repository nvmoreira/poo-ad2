import java.util.*;

public class Grafo {

    private final HashMap<Integer, List<Integer>> grafo = new HashMap<>();
    private ArrayList<Integer> vertices;
    private ArrayList<List<Integer>> arestas;
    private List<Integer> adj;
    boolean[] visitados;
    private int numVertices;
    private String orientado;

    public Grafo(){
        this.numVertices = 0;
    }

    public void setVisitados(int size){
        this.visitados = new boolean[size];
    }

    public void setVertices(){
        this.vertices = new ArrayList<>(grafo.keySet());
    }

    public void setArestas(){
        this.arestas = new ArrayList<>(grafo.values());
    }

    public void addConexao(Integer node, List<Integer> arestas){
        grafo.put(node, arestas);
        this.numVertices++;
    }

    public String verificaOrientado(){
        setVertices();
        setArestas();
        int no = 0;
        int count = 0;
        for (int node : vertices) {
            this.adj = grafo.get(node);
            for (int value : this.adj){
                if (value == 1){
                    if (arestas.get(no).get(count) == 1){
                        orientado = "não-orientado";
                        return "nao-orientado";
                    }
                }
                no++;
            }
            no = 0;
            count++;
        }
        orientado = "orientado";
        return "orientado";
    }

    public String verificaCiclo(){
        setArestas();
        setVisitados(this.numVertices);
        boolean[] arestasRecursao = new boolean[this.numVertices];
        String ciclo;
        if(orientado.equals("orientado")){
            for (int i = 0; i < this.numVertices; i++){
                if (cicloOrientadoDFS(i, this.visitados, arestasRecursao)){
                    ciclo = "ciclico";
                }
            }
        ciclo = "aciclico";
        } else {
            for (List<Integer> a : arestas){
                for (int conexoes : a){
                    if (conexoes == -1){
                        a.set(a.indexOf(-1), 1);
                    }
                }
            }
            for (int x = 0; x < this.numVertices; x++) {
                if (!this.visitados[x])
                    if (cicloNaoOrientadoDFS(x, this.visitados, -1))
                        return "ciclico";
            }
            return "acíclico";
        }
        return ciclo;
    }

    public String verificaConexo(){
        setVisitados(this.numVertices);
        conexoDFS(0);
        int count = 0;
        for (boolean b : this.visitados) {
            if (b)
                count++;
        }
        if (this.numVertices == count) {
            return "conexo";
        } else {
            return "desconexo";
        }
    }

    public void conexoDFS(int idx){

        this.visitados[idx] = true;
        ArrayList<List<Integer>> arestasCopia = new ArrayList<>(grafo.values());
        this.adj = arestasCopia.get(idx);

        for (int v : adj){
            if (!adj.contains(1)){
                break;
            }
            if (v == 1){
                idx = adj.indexOf(v);
                adj.set(idx, -1);
                conexoDFS(idx);
            }
        }
        for (List<Integer> a : arestasCopia){
            this.adj = arestasCopia.get(arestasCopia.indexOf(a));
            if (this.adj.contains(1) && this.adj.contains(-1)){
                conexoDFS(arestasCopia.indexOf(a));
            }
        }
    }

    private boolean cicloOrientadoDFS(int i, boolean[] visitados, boolean[] arestasRecursao) {
        if (arestasRecursao[i]) {
            return true;
        }

        if (visitados[i]) {
            return false;
        }

        visitados[i] = true;
        arestasRecursao[i] = true;
        this.adj = arestas.get(i);

        for (Integer c: this.adj) {
            if (cicloOrientadoDFS(c, visitados, arestasRecursao)) {
                return true;
            }
        }

        arestasRecursao[i] = false;

        return false;
    }

    private boolean cicloNaoOrientadoDFS(int v, boolean[] visitados, int parent) {
        visitados[v] = true;
        Integer vertice;

        ArrayList<Integer> vizinhos = new ArrayList<>();
        this.adj = this.arestas.get(v);

        for (int b = 0; b < this.adj.size(); b++){
            if (this.adj.get(b) == 1){
                vizinhos.add(b);
            }
        }
        for (Integer integer : vizinhos) {
            vertice = integer;
            if (!visitados[vertice]) {
                if (cicloNaoOrientadoDFS(vertice, visitados, v)) {
                    return true;
                }
            } else if (vertice != parent) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return verificaOrientado()
                + " - " + verificaCiclo()
                + " - " + verificaConexo();
    }
}
