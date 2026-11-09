class Solution:
    def longestPalindrome(self, s: str, t: str) -> int:
        
        def palinSize(word):
            w, res = len(word), 1

            for wordLen in range(w+w-1):
                idxLeft = wordLen // 2
                idxRght = idxLeft + wordLen%2

                if word[idxLeft] == word[idxRght]:
                    
                    while 0 < idxLeft and idxRght < w-1:
                        if word[idxLeft - 1] != word[idxRght + 1]: break
                        idxLeft+= -1
                        idxRght+=  1
                    res = max(res, idxRght - idxLeft + 1)

            return res        


        m, n, ans = len(s), len(t), 1

        for sRght in range(m + 1):
            for tLeft in range(n + 1):

                if sRght + n - tLeft <= ans: continue
                word = s[:sRght] + t[tLeft:]
                ans = max(ans, palinSize(word))

        if m > ans: ans = max(ans, palinSize(s))
        if n > ans: ans = max(ans, palinSize(t))
            
        return ans