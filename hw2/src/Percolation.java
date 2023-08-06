import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final boolean[][] matrix;
    private int openSites;

    private final int[] dx={0,0,1,-1};
    private final int[] dy={1,-1,0,0};

    private final WeightedQuickUnionUF disjointSet;

    public Percolation(int N) {
        if(N<=0){
            throw new IllegalArgumentException();
        }
        openSites=0;
        matrix = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                matrix[i][j]=false;
            }
        }
        disjointSet = new WeightedQuickUnionUF( N * N );
    }

    public void open(int row, int col) {
        if(!isValid(row,col)){
            throw new IndexOutOfBoundsException();
        }
        if(isOpen(row,col))return;
        matrix[row][col]=true;
        openSites+=1;

        for(int i=0;i<4;i++){
            int x=row+dx[i];
            int y=col+dy[i];
            if(isValid(x,y) && isOpen(x,y)){
                disjointSet.union(cordToNumber(row,col),cordToNumber(x,y));
            }
        }


    }

    public boolean isOpen(int row, int col) {
        if(!isValid(row,col)){
            throw new IndexOutOfBoundsException();
        }
        return matrix[row][col];
    }

    public boolean isFull(int row, int col) {
        if(!isValid(row,col)){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<matrix[0].length;i++){
            if(isOpen(0,i) && disjointSet.connected(cordToNumber(0,i),cordToNumber(row,col))){
                return true;
            }
        }
        return false;
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        int n=matrix.length;

        for(int i=0;i<n;i++){
            if(isOpen(n-1,i) && isFull(n-1,i)){
                return true;
            }
        }

        return false;
    }



    private int cordToNumber(int row,int col){
        return row * matrix[0].length + col;
    }

    private boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
    }

}
