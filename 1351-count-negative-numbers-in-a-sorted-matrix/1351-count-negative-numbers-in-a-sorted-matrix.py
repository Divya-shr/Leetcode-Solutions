class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0

        for row in grid:
            for cell in row:
                if cell < 0:
                    count += 1
        return count