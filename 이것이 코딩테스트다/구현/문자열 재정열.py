word = input()

num = 0
temp_word = []
for v in word:
    if v.isdigit():
        num += int(v)
    else:
        temp_word.append(v)

temp_word.sort()
if num > 0:
    temp_word.append(str(num))
result = ''.join(temp_word)
print(result)