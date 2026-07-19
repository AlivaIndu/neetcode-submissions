class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(j<arr.length){
            if(j-i+1<=k){
                list.add(arr[j]);
            }else{
                if(Math.abs(x-arr[i])>Math.abs(x-arr[j]))
                {
                    list.remove(0);
                    list.add(arr[j]);
                    i++;
                }
                else if(Math.abs(x-arr[i])<Math.abs(x-arr[j])) return list;
            }
            j++;
        }

        return list;
    }
}