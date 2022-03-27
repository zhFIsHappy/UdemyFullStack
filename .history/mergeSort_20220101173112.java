public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        if(A== null|| A.length == 0) return;
        int[] temp= new int[A.length];
        mergeSort(A,0,A.length -1, temp);
    }
    private void mergeSort(int[] A, int start, int end, int[] temp){
        if(start >= end) return ;
        mergeSort(A, start, (start+end)/2, temp);
        mergeSort(A,(start+end)/2+1, end, temp);
        merge(A,start,end ,temp);
    }
    private void merge(int[] A, int start, int end, int[] temp){
        int middle = (start + end) /2;
        int leftindex = start;
        int rightindex = middle+1;
        int index = start;
        while(leftindex <= middle && rightindex <= end){
            if(A[leftindex] < A[rightindex]){
                temp[index++] = A[leftindex++];
            }else{
                temp[index++] = A[rightindex++];
            }
        }
        while(leftindex <= middle){
            temp[index++] = A[leftindex++];
        }
        while(rightindex<= end){
            temp[index++] = A[rightindex++];
        }
        for(int i = start; i <= end; i++){
            A[i]=temp[i];
        }
    }
}