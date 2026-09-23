class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        store = []
        count = 0
        res = []
        for i in range(len(s)):
            if s[i] == c:
                store.append(i)

        for i in range(len(s)):
            if s[i] == c:
                count += 1
                res.append(0)
            elif count == 0:
                res.append(abs(i - store[0]))
            elif count > 0 and count < len(store):
                if abs(i - store[count - 1]) < abs(i - store[count]):
                    res.append(abs(i - store[count - 1]))
                else:
                    res.append(abs(i - store[count]))
            elif count == len(store):
                res.append(abs(i - store[count - 1]))

        return res