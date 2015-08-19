public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length == 0) {
			int middle = nums2.length / 2;
			if(nums2.length % 2 == 0) {
				return ((double)nums2[middle] + (double)nums2[middle - 1]) / 2;
			}
			else {
				return (double)nums2[middle];
			}
		}		
		if(nums2.length == 0) {
			int middle = nums1.length / 2;
			if(nums1.length % 2 == 0) {
				return ((double)nums1[middle] + (double)nums1[middle - 1]) / 2;
			}
			else {
				return (double)nums1[middle];
			}
		}
		int distance = (nums1.length + nums2.length - 1) / 2;
		int start1 = 0;
		int start2 = 0;
		while(distance > 0) {
			int step = (distance + 1) / 2;
			if(start1 + step > nums1.length) {
        step = nums1.length - start1;
      }
      if(start2 + step > nums2.length) {
        step = nums2.length - start2;
      }
			if(nums1[start1 + step - 1] < nums2[start2 + step - 1]) {
				start1 += step;
				distance -= step;
			}
			else {
				start2 += step;
				distance -= step;
			}
			if(start1 > nums1.length - 1){
        if((nums1.length + nums2.length) % 2 == 0) {
          return ((double)nums2[start2 + distance] + (double)nums2[start2 + distance + 1]) / 2;
        }
        else {
          return (double)nums2[start2 + distance];
        }
      }
      if(start2 > nums2.length - 1){
        if((nums1.length + nums2.length) % 2 == 0) {
         return ((double)nums1[start1 + distance] + (double)nums1[start1 + distance + 1]) / 2;
        }
        else {
          return (double)nums1[start1 + distance];
        }
      }
		}
		if((nums1.length + nums2.length) % 2 == 0) {
			if(nums1[start1] > nums2[start2] && start2 < nums2.length -1) {
				return ((double)Math.min(nums1[start1], nums2[start2 + 1]) + (double)nums2[start2]) / 2;
			}
			else if(nums1[start1] < nums2[start2] && start1 < nums1.length - 1){
				return ((double)Math.min(nums2[start2], nums1[start1 + 1]) + (double)nums1[start1]) / 2;
			}
			else {
				return ((double)nums2[start2] + (double)nums1[start1]) / 2;
			}
		}
		else {
			return Math.min((double)nums1[start1], (double)nums2[start2]);
		}
	}
}