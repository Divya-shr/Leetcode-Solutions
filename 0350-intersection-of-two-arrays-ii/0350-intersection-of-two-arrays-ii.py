class Solution:
    from collections import Counter
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        freq = Counter(nums2)
        result = []

        for val in nums1:
            if freq[val] > 0:
                result.append(val)
                freq[val] -= 1
        
        return result