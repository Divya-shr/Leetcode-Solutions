class Solution:
    def toGoatLatin(self, sentence: str) -> str:
        arr = sentence.split(" ")
        # print(arr)
        new_str = ''
        count = 1
        for i in arr:
            if i[0] in 'aeiouAEIOU':
                str_temp = i + "ma" + "a" * count + ' '
                new_str = new_str + str_temp
                count += 1
            else:
                str_temp = i[1:] + i[0] + "ma" + "a" * count + ' '
                new_str = new_str + str_temp
                count += 1
        return(new_str.rstrip())

        