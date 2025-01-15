class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(n <= 0)
            return triangle;
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for(int i = 1; i <= n; i++) {
            ArrayList<Integer> current = new ArrayList<>();
            for(int j = 0; j < i; j++)
                if (j == 0 || j == i - 1)
                    current.add(1);
                else
                    current.add(triangle.get(i-1).get(j - 1) + triangle.get(i-1).get(j));
            triangle.add(current);
        }
        triangle.subList(0, 1).clear();
        return triangle;
    }
}
