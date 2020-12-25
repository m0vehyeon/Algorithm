N = int(input())
word = []
for _ in range(N):
    word.append(input())
word = list(set(word))
word.sort(key = lambda x:(len(x),x))
for v in word:
    print(v)