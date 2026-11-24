class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        contMap, ans = defaultdict(list), []
        for pStr in paths:
            sep = pStr.split(" ")
            for i in range(1, len(sep)):
                parts = sep[i].split('(')
                cont = parts[1][:-1]
                contMap[cont].append(sep[0] + '/' + parts[0])
        for v in contMap.values():
            if len(v) > 1: ans.append(v)
        return ans