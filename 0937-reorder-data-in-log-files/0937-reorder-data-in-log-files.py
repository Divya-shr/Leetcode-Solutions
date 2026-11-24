class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        
        letters = []
        digits = []

        for log in logs:
            identifier, content = log.split(" ", 1)

            if content[0].isdigit():
                digits.append(log)
            else:
                letters.append(log)
            
        letters.sort(key=lambda log: (
            log.split(" ", 1)[1],
            log.split(" ", 1)[0]
        ))

        return letters + digits