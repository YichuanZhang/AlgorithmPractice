class UnionFind {
    private int[] parent;
    private int size;
    public UnionFind(int size){
        this.size = size;
        parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = -1;
        }
    }

    public void print(){
        for(int i : parent){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(0,6);
        uf.union(6,7);
        uf.union(7,8);
        uf.union(1,4);
        uf.union(1,9);
        uf.union(2,3);
        uf.union(2,5);
        uf.print();
        //System.out.println(uf.find(8));
        //System.out.println(uf.getSetSize(8));
    }

    public int find(int x){
        int oldX = x;
        while(parent[x] >= 0){
            x = parent[x];
        }
        //now the final root = x
        //merge the track
        while(oldX != x){
            int tmp = parent[oldX];
            parent[oldX] = x;
            oldX = tmp;
        }
        return x;
    }

    public void union(int x, int y){
        int root_x = find(x);
        int root_y = find(y);
        if(root_x == root_y)return;
        //merge together x, y
        parent[root_x] += parent[root_y];
        parent[root_y] = root_x;
    }

    public int getSetSize(int x){
        int root_x = find(x);
        return -parent[root_x];
    }
}