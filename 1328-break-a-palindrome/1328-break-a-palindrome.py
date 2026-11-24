class Solution:
    def breakPalindrome(self, str):

        if len(str) == 1:
            return ""

        arr = list(str)
        n = len(arr)

        for i in range(n // 2):

            if arr[i] != 'a':
                arr[i] = 'a'
                return ''.join(arr)

        arr[n - 1] = 'b'

        return ''.join(arr)