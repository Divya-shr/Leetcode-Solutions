class Solution:
    def findReplaceString(self, s: str, indices: List[int], sources: List[str], targets: List[str]) -> str:
        # iterate from the greater index to the smallest
        for i, src, tg in sorted(list(zip(indices, sources, targets)), reverse=True):    
            # if found the pattern matches with the source, replace with the target accordingly
            if s[i:i+len(src)] == src: s = s[:i] + tg + s[i+len(src):]            
        return s