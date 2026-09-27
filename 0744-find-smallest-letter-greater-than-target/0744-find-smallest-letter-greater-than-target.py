class Solution:
    def nextGreatestLetter(self, letters: list[str], target: str) -> str:
        N = len(letters)
        lo = 0
        hi = N - 1

        while lo != hi:
            mi = lo + (hi - lo) // 2
            if letters[mi] <= target:
                lo = mi + 1
            else:
                hi = mi
        
        if letters[lo] <= target:
            return letters[0]
        return letters[lo]