class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        freq = Counter(nums)
        ans = []
        for x in freq:
            if freq[x] == 1:
                ans.append(x)
        return ans