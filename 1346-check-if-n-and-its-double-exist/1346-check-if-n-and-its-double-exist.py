class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        arr.sort()
        for i in range(len(arr)):
            product = arr[i]*2
            lo,hi = 0,len(arr)-1
            while lo<=hi:
                mid = (lo+hi)//2
                if arr[mid]==product and mid!= i:
                    return True
                elif arr[mid]<product:
                    lo+=1
                else:
                    hi-=1
        return False