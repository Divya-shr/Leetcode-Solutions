class Solution:
    def validIPAddress(self, s: str) -> str:
        return (fullmatch(r'\:'.join([r'[a-fA-F\d]{1,4}']*8),s) and 'IPv6' or
            fullmatch(r'\.'.join([r'(25[0-5]|2[0-4]\d|1\d\d|[1-9]?\d)']*4),s) and 'IPv4'
                 or 'Neither')