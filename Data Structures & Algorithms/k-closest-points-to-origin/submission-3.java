class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int index = k - 1;
        int pivot = partition(points, 0, points.length - 1);
        int left = 0;
        int right = points.length - 1;
        while(pivot != index){
            if(pivot < index){
                left = pivot + 1;
                pivot = partition(points, left, right);
            } else if(pivot > index){
                right = pivot - 1;
                pivot = partition(points, left, right);
            } else{
                break;
            }
        }
        int[][] result = new int[k][2];
        System.arraycopy(points, 0, result, 0, k);
        return result;
    }

    private int partition(int[][] points, int l, int r){
        int p = l;
        for(int i = l; i < r; i++){
            if(dist(points[i]) < dist(points[r])){
                swap(points, i, p);
                p++;
            }
        }
        swap(points, p, r);
        return p;
    }

    private void swap(int[][] points, int a, int b){
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }

    private int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
