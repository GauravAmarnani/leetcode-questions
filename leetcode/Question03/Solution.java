class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] merged = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        if(n1 == 0)
            while (j < n2)
                merged[k++] = nums2[j++];
        else if(n2 == 0)
            while (i < n1)
                merged[k++] = nums1[i++];
        else {
            if (nums1[n1 - 1] < nums2[0]) {
                while (i < n1)
                    merged[k++] = nums1[i++];
                while (j < n2)
                    merged[k++] = nums2[j++];
            } else if (nums2[n2 - 1] < nums1[0]) {
                while (j < n2)
                    merged[k++] = nums2[j++];
                while (i < n1)
                    merged[k++] = nums1[i++];
            } else {
                while (i < n1 && j < n2) {
                    if (nums1[i] < nums2[j])
                        merged[k++] = nums1[i++];
                    else
                        merged[k++] = nums2[j++];
                }
                while (i < n1)
                    merged[k++] = nums1[i++];
                while (j < n2)
                    merged[k++] = nums2[j++];
            }
        }
        if (merged.length % 2 != 0)
            return merged[merged.length / 2];
        else {
            int total = (merged[merged.length / 2]) + (merged[merged.length / 2 - 1]);
            return total / 2.0;
        }
    }
}
